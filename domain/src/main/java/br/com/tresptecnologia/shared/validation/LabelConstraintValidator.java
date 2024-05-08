package br.com.tresptecnologia.shared.validation;

import br.com.tresptecnologia.core.message.Message;

public class LabelConstraintValidator {
    protected String message(String messageCode) {
        if (messageCode.startsWith("{")) {
            return Message.toLocale(messageCode
                    .replace("{", "")
                    .replace("}", ""));
        }
        return messageCode;
    }
}
