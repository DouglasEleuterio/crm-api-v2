package br.com.tresptecnologia.shared.util;

import java.security.SecureRandom;
import java.text.Normalizer;

public final class StringUtil {

    private static final SecureRandom random = new SecureRandom();

    private StringUtil() {
    }

    public static String ignoreAccents(final String value) {
        if (value != null) {
            String normalized = Normalizer.normalize(value, Normalizer.Form.NFD);
            return normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        }
        return null;
    }

    public static String getRandomString(int i) {
        var theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        var builder = new StringBuilder(i);
        for (int index = 0; index < i; index++) {
            var randomValue = (theAlphaNumericS.length() * random.nextInt());
            builder.append(theAlphaNumericS.charAt(randomValue));
        }
        return builder.toString();
    }


}
