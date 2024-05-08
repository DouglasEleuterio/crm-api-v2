package br.com.tresptecnologia.shared.util;

import org.apache.commons.text.RandomStringGenerator;

public final class RandomPasswordGenerator {

    private RandomPasswordGenerator() {
    }

    static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generate(final int size) {
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder().selectFrom(CHARS.toCharArray()).build();

        return randomStringGenerator.generate(size);
    }
}
