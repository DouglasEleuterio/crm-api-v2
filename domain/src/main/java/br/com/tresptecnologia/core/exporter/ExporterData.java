package br.com.tresptecnologia.core.exporter;

import br.com.tresptecnologia.shared.util.FileUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.Objects;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExporterData {

    String name;
    ExporterType type;
    byte[] stream;

    public String toBase64() {
        return Base64.getEncoder().encodeToString(stream);
    }

    public String getFileName() {
        if (!name.endsWith(type.getName())) {
            return name + type.getName();
        }
        return name;
    }

    public ResponseEntity<Resource> toResponseEntity() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(stream);
            HttpHeaders header = new HttpHeaders();
            header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + getFileName());
            InputStreamResource resource = new InputStreamResource(byteArrayInputStream);
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.noCache())
                    .contentLength(stream.length)
                    .headers(header)
                    .contentType(FileUtil.getMediaType(type.getMimeType()))
                    .body(resource);
        } catch (Exception ex) {
            log.debug("Falha o consultar os dados do relatorio", ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExporterData that = (ExporterData) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getFileName();
    }
}
