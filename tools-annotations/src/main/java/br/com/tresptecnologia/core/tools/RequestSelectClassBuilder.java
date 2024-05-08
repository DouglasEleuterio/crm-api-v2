package br.com.tresptecnologia.core.tools;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public final class RequestSelectClassBuilder {

    private RequestSelectClassBuilder() {
    }

    public static void generateAndSave(String name, String packageName, List<String> fields,
                                       Consumer<JavaFile> save) {
        TypeSpec.Builder classSelectBuilder = TypeSpec.classBuilder(name)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL);

        TypeName listOfStrings = ParameterizedTypeName.get(ClassName.get(List.class), ClassName.get(String.class));

        MethodSpec.Builder allBuilder = MethodSpec.methodBuilder("getAll")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(listOfStrings);

        allBuilder.addStatement("$T properties = new $T<>()", listOfStrings, ArrayList.class);

        for (String field : fields) {
            final String fieldName = field.replace(".", "_").toUpperCase();
            classSelectBuilder.addField(FieldSpec.builder(String.class, fieldName)
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .initializer("$S", field)
                    .build());

            allBuilder.addStatement("properties.add($N)", fieldName);

        }

        allBuilder.addStatement("return properties", Collections.class)
                .build();


        MethodSpec privateConstructorSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .build();


        classSelectBuilder.addMethod(allBuilder.build());

        classSelectBuilder.addMethod(privateConstructorSpec);

        JavaFile javaFile = JavaFile.builder(packageName, classSelectBuilder.build())
                .build();

        save.accept(javaFile);
    }

}
