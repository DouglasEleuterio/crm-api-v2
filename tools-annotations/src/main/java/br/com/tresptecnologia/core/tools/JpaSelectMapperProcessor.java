package br.com.tresptecnologia.core.tools;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static br.com.tresptecnologia.core.tools.JpaSelectMapperProcessor.ANNOTATION_NAME;

@SupportedAnnotationTypes(ANNOTATION_NAME)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class JpaSelectMapperProcessor extends AbstractProcessor {

    public static final String ANNOTATION_NAME = "br.com.tresptecnologia.core.jpa.annotation.JpaSelectMapper";
    public static final String ANNOTATION_MANY_TO_ONE = "OneToMany";
    public static final String ANNOTATION_MANY_TO_ONE_PROPERTY_VALUE = "mappedBy";

    private Filer filer;
    private Types typeUtils;
    private Messager messager;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getRootElements()) {
            try {
                if (hasInterfaceOrAnnotation(element)) {
                    final List<String> fields = new ArrayList<>();

                    fillVariables(element, "", fields, Optional.empty());

                    final String className = element.getSimpleName().toString() + "Select_";
                    final String packageName = elementUtils.getPackageOf(element).getQualifiedName().toString();

                    RequestSelectClassBuilder.generateAndSave(className,
                            packageName, fields, (javaFile -> {
                                try {
                                    javaFile.writeTo(filer);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }));
                }
            } catch (Exception e) {
                error(element, e.getMessage());
            }
        }
        return true;
    }

    private void fillVariables(final Element element,
                               final String prefix,
                               final List<String> fields,
                               final Optional<TypeParent> parentMappedBy) {
        if (element.getKind().isClass()) {
            final List<VariableElement> variableElements = ElementFilter.fieldsIn(element.getEnclosedElements());
            for (VariableElement variableElement : variableElements) {

                final TypeParent typeParent = new TypeParent();

                if (parentMappedBy != null && parentMappedBy.isPresent()) {
                    final String name = variableElement.getSimpleName().toString();
                    final TypeParent hasType = parentMappedBy.get();
                    if (hasType.getMappedBy() != null && hasType.getMappedBy().equals(name)) {
                        continue;
                    }
                }

                final Optional<String> hasMappedBy = getMappedBy(variableElement);
                hasMappedBy.ifPresent(typeParent::setMappedBy);

                final String name = prefix + variableElement.getSimpleName().toString();

                TypeMirror fieldType = variableElement.asType();
                if (isCollectionType(fieldType)) {
                    final List<? extends TypeMirror> typeArguments = ((DeclaredType) fieldType)
                            .getTypeArguments();
                    if (!typeArguments.isEmpty()) {
                        final TypeMirror elementType = typeArguments.get(0);
                        final Element innerElement = typeUtils.asElement(elementType);

                        if (innerElement != null) {
                            if (skipeRecursiveFields(innerElement, parentMappedBy)) {
                                continue;
                            }

                            typeParent.setParentType(innerElement.getSimpleName().toString());
                            fillVariables(innerElement, name + ".", fields, Optional.of(typeParent));
                        }
                    }
                } else {
                    if (isPrimitiveOrBoxedClass(variableElement)) {
                        fields.add(name);
                    } else {
                        final TypeMirror elementType = variableElement.asType();
                        final Element innerElement = typeUtils.asElement(elementType);

                        if (innerElement != null) {
                            if (skipeRecursiveFields(innerElement, parentMappedBy)) {
                                continue;
                            }

                            typeParent.setParentType(innerElement.getSimpleName().toString());
                            fillVariables(innerElement, name + ".", fields, Optional.of(typeParent));
                        }
                    }
                }
            }
        }
    }

    private boolean skipeRecursiveFields(final Element innerElement,
                                         final Optional<TypeParent> parentMappedBy) {
        if (innerElement != null && parentMappedBy != null && parentMappedBy.isPresent()) {
            final String nameInner = innerElement.getSimpleName().toString();
            final TypeParent hasType = parentMappedBy.get();
            if (hasType.getParentType() != null && hasType.getParentType().equals(nameInner)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCollectionType(TypeMirror typeMirror) {
        final TypeMirror collectionType = typeUtils.getDeclaredType(elementUtils.getTypeElement(Collection.class.getName()));
        return typeUtils.isAssignable(typeMirror, collectionType);
    }

    private boolean isPrimitiveOrBoxedClass(final VariableElement element) {
        final TypeMirror typeMirror = element.asType();
        final TypeKind typeKind = typeMirror.getKind();
        if (typeKind.isPrimitive() || isEnum(typeMirror)) {
            return true;
        } else if (typeMirror instanceof PrimitiveType) {
            final PrimitiveType primitiveType = (PrimitiveType) typeMirror;
            return primitiveType.getKind().isPrimitive();
        }
        final String typeName = typeMirror.toString();
        return isBoxedClass(typeName) || isNumber(typeMirror);
    }

    private boolean isBoxedClass(final String typeName) {
        return typeName.equals("java.lang.String") ||
                typeName.equals("java.lang.Boolean") ||
                typeName.equals("java.lang.Integer") ||
                typeName.equals("java.lang.Character") ||
                typeName.equals("java.lang.Byte") ||
                typeName.equals("java.lang.Short") ||
                typeName.equals("java.lang.Float") ||
                typeName.equals("java.lang.Long") ||
                typeName.equals("java.lang.Double") ||
                typeName.equals("java.sql.Date") ||
                typeName.equals("java.util.Date") ||
                typeName.equals("java.time.LocalTime") ||
                typeName.equals("java.time.LocalDate") ||
                typeName.equals("java.time.LocalDateTime");
    }

    private boolean isNumber(final TypeMirror typeMirror) {
        final TypeMirror collectionType = typeUtils.getDeclaredType(elementUtils.getTypeElement(Number.class.getName()));
        return typeUtils.isAssignable(typeMirror, collectionType);
    }

    private boolean isEnum(final TypeMirror typeMirror) {
        final TypeMirror enumType = typeUtils.getDeclaredType(elementUtils.getTypeElement(Enum.class.getName()));
        return typeUtils.isAssignable(typeMirror, enumType);
    }

    private void error(final Element element, final String msg, final Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), element);
    }

    private boolean hasInterfaceOrAnnotation(final Element element) {
        if (element.getKind().isClass()) {
            return hasAnnotation(element, ANNOTATION_NAME);
        }
        return false;
    }

    private boolean hasAnnotation(final Element element, final String annotation) {
        final List<? extends AnnotationMirror> annotations = element.getAnnotationMirrors();
        if (annotations != null && annotations.isEmpty()) {
            return false;
        }

        for (AnnotationMirror annotationMirror : annotations) {
            final Element annotationElement = annotationMirror.getAnnotationType().asElement();
            final String name = elementUtils.getPackageOf(annotationElement) + "." + annotationElement.getSimpleName().toString();
            if (name.equals(annotation)) {
                return true;
            }
        }

        return false;
    }

    private Optional<String> getMappedBy(VariableElement variableElement) {
        final List<? extends AnnotationMirror> annotations = variableElement.getAnnotationMirrors();
        if (!annotations.isEmpty()) {
            for (AnnotationMirror annotationMirror : annotations) {
                final Element annotationElement = annotationMirror.getAnnotationType().asElement();
                final String name = annotationElement.getSimpleName().toString();
                if (name.equals(ANNOTATION_MANY_TO_ONE)) {
                    Optional<? extends ExecutableElement> optionalObject = annotationMirror.getElementValues()
                            .keySet().stream().filter(x ->
                                    x.getSimpleName().toString()
                                            .equals(ANNOTATION_MANY_TO_ONE_PROPERTY_VALUE)).findFirst();
                    if (optionalObject.isPresent()) {
                        final AnnotationValue value = annotationMirror.getElementValues().get(optionalObject.get());
                        if (value != null) {
                            return Optional.of(String.valueOf(value.getValue()));
                        }
                    }
                }
            }
        }

        return Optional.empty();
    }
}