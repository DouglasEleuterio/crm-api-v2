package br.com.tresptecnologia.core.controller.swagger;

import io.swagger.v3.core.converter.ResolvedSchema;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Component
@Scope("singleton")
public class SchemaStoreSingleton {
    Map<String, ResolvedSchema> mapSchema = new ConcurrentHashMap<>();

    public synchronized void add(ResolvedSchema resolvedSchema) {
        mapSchema.put(resolvedSchema.schema.getName(), resolvedSchema);
    }

    public synchronized void clear() {
        mapSchema.clear();
    }
}
