package com.nicenpc.twvalidation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 驗證台灣國際手機號碼+886開頭
 */
public class NationalPhoneNumberValidator {

    private static final String REGEX = "\\+886\\d{9}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static boolean isValid(final String nationalPhoneNumber) {
        if (null == nationalPhoneNumber) {
            return false;
        }

        if (nationalPhoneNumber.isBlank()) {
            return false;
        }

        Matcher matcher = PATTERN.matcher(nationalPhoneNumber);
        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

}
