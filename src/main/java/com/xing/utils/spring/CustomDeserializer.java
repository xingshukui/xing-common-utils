package com.xing.utils.spring;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * CustomDeserializer
 *
 * @author : xingshukui
 * @date : 2019/7/1 7:00 PM
 * @desc :
 *
 *
 * 安全问题
 */
@JsonComponent
public class CustomDeserializer {

    private static final String UID_STR = "userId";


    public static class LongSerializer extends JsonSerializer<Long> {
        @Override
        public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String key = jsonGenerator.getOutputContext().getCurrentName();
            if (UID_STR.equalsIgnoreCase(key) ) {
                aLong = null;
            }
            if (aLong == null) {
                jsonGenerator.writeNull();
            }else {
                jsonGenerator.writeNumber(aLong.longValue());
            }
        }
    }
}
