package com.twitter.demo.modules;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SecretKeyService {

    private final int LENGTH = 256;
    private final String UPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWERCASE = "abcdefghijklmnopqrstuvxyz";
    private final String NUMBERS = "0123456789";

    public String generate() {
        String alphaNumericString = UPERCASE + NUMBERS + LOWERCASE;
        StringBuilder stringBuilder = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = (int)(alphaNumericString.length() * Math.random());
            stringBuilder.append(alphaNumericString.charAt(index));
        }
        return stringBuilder.toString();

    }
}
