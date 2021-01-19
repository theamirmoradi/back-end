package com.twitter.demo.modules.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ListConverter implements AttributeConverter<List<String>, String> {

    private final Logger logger = Logger.getLogger(MapConverter.class.getSimpleName());

    @Override
    public String convertToDatabaseColumn(final List<String> customerInfo) {
        String customerInfoJson = null;
        try {
            customerInfoJson = new ObjectMapper().writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
            logger.warning(e.getMessage());
        }
        return customerInfoJson;
    }

    @Override
    public List<String> convertToEntityAttribute(final String input) {
        List<String> output = null;
        try {
            output = new ObjectMapper().readValue(input, List.class);
        } catch (final IOException e) {
            logger.warning(e.getMessage());
        }
        return output;
    }

}