package br.com.tresptecnologia.core.email;

import lombok.Getter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

@Getter
public class EmailAttachment {

    final InputStream inputStream;
    final String name;

    public EmailAttachment(InputStream inputStream, String name) {
        this.inputStream = inputStream;
        this.name = name;
    }

    public static EmailAttachment of(byte[] bytes) {
        return of(UUID.randomUUID().toString(), bytes);
    }

    public static EmailAttachment of(String name, byte[] bytes) {
        return of(name, new ByteArrayInputStream(bytes));
    }

    public static EmailAttachment of(String name, InputStream stream) {
        return new EmailAttachment(
                stream,
                name
        );
    }
}
