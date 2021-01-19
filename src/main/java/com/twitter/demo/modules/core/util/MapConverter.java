package com.twitter.demo.modules.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MapConverter implements AttributeConverter<Map<String, Object>, String> {

    private final Logger logger = Logger.getLogger(MapConverter.class.getSimpleName());

    @Override
    public String convertToDatabaseColumn(final Map<String, Object> customerInfo) {
        String customerInfoJson = null;
        try {
            customerInfoJson = new ObjectMapper().writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
            logger.warning(e.getMessage());
        }
        return customerInfoJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(final String input) {
        Map<String, Object> output = null;
        try {
            output = new ObjectMapper().readValue(input, Map.class);
        } catch (final IOException e) {
            logger.warning(e.getMessage());
        }
        return output;
    }

}