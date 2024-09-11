package com.nicenpc.twvalidation.validator;

import java.util.regex.Pattern;

public class MobileBarcodeValidator {
    private static final String REGEX = "/[A-Z0-9.\\-+]{7}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static boolean isValid(final String mobileBarcode) {
        if (null == mobileBarcode) {
            return false;
        }

        var matcher = PATTERN.matcher(mobileBarcode);
        return matcher.matches();
    }
}
