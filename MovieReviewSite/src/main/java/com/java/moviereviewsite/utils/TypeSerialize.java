package com.java.moviereviewsite.utils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.java.moviereviewsite.model.Type;

import java.io.IOException;
public class TypeSerialize extends JsonSerializer<Type> {
    @Override
    public void serialize(Type value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getName());
    }
}
