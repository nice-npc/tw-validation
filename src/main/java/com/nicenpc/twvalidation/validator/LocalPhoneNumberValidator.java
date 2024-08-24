package com.nicenpc.twvalidation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 驗證台灣本地手機號碼09開頭
 */
public class LocalPhoneNumberValidator {

    private static final String REGEX = "09\\d{8}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static boolean isValid(final String localPhoneNumber) {
        if (null == localPhoneNumber) {
            return false;
        }

        if (localPhoneNumber.isBlank()) {
            return false;
        }

        Matcher matcher = PATTERN.matcher(localPhoneNumber);
        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

}
