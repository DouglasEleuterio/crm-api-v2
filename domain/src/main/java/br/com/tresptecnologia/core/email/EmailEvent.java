package br.com.tresptecnologia.core.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EmailEvent {

    final String subject;
    final String from;
    final List<String> to;
    final Templates template;
    final Map<String, Object> params;
    final List<EmailAttachment> attachments;

    public String[] getToArray(){
        return getTo().toArray(new String[0]);
    }

    public List<String> getTo() {
        if (to == null) {
            return Collections.emptyList();
        }
        return to;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            return new HashMap<>();
        }
        return params;
    }

    public List<EmailAttachment> getAttachments() {
        if (attachments == null) {
            return Collections.emptyList();
        }
        return attachments;
    }

    public String toPrintTable(String parsedTemplate) {
        return "---------------------------------------\n" +
                "Envio de Email\n" +
                "---------------------------------------\n" +
                "Assunto:" + subject + "\n" +
                "De:" + from + "\n" +
                "Para:" + String.join(",", getTo()) + "\n" +
                "Anexos:" + getAttachments().stream().map(EmailAttachment::getName).collect(Collectors.joining(",")) + "\n" +
                "Mensagem:\n" + parsedTemplate + "\n" +
                "---------------------------------------\n";
    }

}
