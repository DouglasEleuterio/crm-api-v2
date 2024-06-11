package br.com.tresptecnologia.shared.validation;

import br.com.tresptecnologia.core.message.Message;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;
import java.util.Objects;

public class RequiredListValidator extends LabelConstraintValidator
        implements ConstraintValidator<RequiredList, Object> {

    private static final String LABEL_PARAMETER = "{label}";
    private static final String MIN_PARAMETER = "{min}";
    private static final String ALIAS_PARAMETER = "{alias}";

    private String label;
    private boolean required;
    private int min;
    private String alias;
    private String customMessage;

    @Override
    public void initialize(final RequiredList constraintAnnotation) {
        min = constraintAnnotation.min();
        alias = constraintAnnotation.alias();
        label = constraintAnnotation.label();
        required = constraintAnnotation.required();
        customMessage = constraintAnnotation.customMessage();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        var labelValue = Message.toLocale(label);
        String errorMessage ;

        if (Objects.isNull(value) || (((Collection<?>) value).isEmpty() && required)) {
            if (Objects.nonNull(customMessage) && !customMessage.isEmpty() && !customMessage.isBlank())
                errorMessage = customMessage;
            else
                errorMessage = message("{validation.requiredListMinSize}")
                        .replace(LABEL_PARAMETER, labelValue);

            context.buildConstraintViolationWithTemplate(errorMessage)
                    .addConstraintViolation();
            return false;
        }
        if ((((Collection<?>) value).size() < min)) {
            context.buildConstraintViolationWithTemplate(message("{validation.requiredListMinSize}")
                            .replace(LABEL_PARAMETER, labelValue).replace(MIN_PARAMETER, String.valueOf(min)).replace(ALIAS_PARAMETER, alias))
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
