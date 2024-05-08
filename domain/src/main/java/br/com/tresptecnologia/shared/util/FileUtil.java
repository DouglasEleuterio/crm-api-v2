package br.com.tresptecnologia.shared.util;

import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import java.net.URLConnection;
import java.util.Optional;

public final class FileUtil {

    private FileUtil() {
    }

    public static MediaType getMediaType(final String contentType) {
        MimeType mimeType = MimeTypeUtils.parseMimeType(contentType);
        return new MediaType(mimeType.getType(), mimeType.getSubtype());
    }


    public static String getExtension(final String file) {
        return Optional.ofNullable(file)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(file.lastIndexOf(".") + 1))
                .orElse(file);
    }

    public static String getContentType(final String file) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(file);

        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }

        return contentTypeFor;
    }
}
