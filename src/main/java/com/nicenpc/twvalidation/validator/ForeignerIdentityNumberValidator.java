package com.nicenpc.twvalidation.validator;

import java.util.regex.Pattern;

public class ForeignerIdentityNumberValidator {

    private static final Pattern ID_PATTERN = Pattern.compile("[A-Z][89]\\d{8}");


    public static boolean valid(final String identityNumber) {
        
        if (null == identityNumber) {
            return false;
        }

        if (identityNumber.isEmpty()) {
            return false;
        }

        final String identityNumberUpperCase = identityNumber.toUpperCase();

        return ID_PATTERN.matcher(identityNumberUpperCase).matches();
    }
}
