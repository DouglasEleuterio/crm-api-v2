package br.com.tresptecnologia.core.json.serializer;

import br.com.tresptecnologia.core.entity.BaseEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BaseEnumSerializer extends JsonSerializer<BaseEnum> {

    public void serialize(BaseEnum o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(o.getLabel());
    }
}
