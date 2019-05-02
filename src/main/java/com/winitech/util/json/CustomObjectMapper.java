package com.winitech.util.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;
    public CustomObjectMapper(){
    	
        getSerializerProvider().setNullValueSerializer(new NullToEmptyStringSerializer());
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }
}