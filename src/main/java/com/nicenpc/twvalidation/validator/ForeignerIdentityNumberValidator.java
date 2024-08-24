package com.nicenpc.twvalidation.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ForeignerIdentityNumberValidator {

    private static final Pattern ID_PATTERN = Pattern.compile("[A-Z][89]\\d{8}");
    private static final Integer LAST_ID_INDEX = 9;
    private static final Map<String, Integer> FIRST_LETTER_VALUE_MAP = new HashMap<>();
    private static final int[] MULTIPLIERS = {8, 7, 6, 5, 4, 3, 2, 1};
    static {
        FIRST_LETTER_VALUE_MAP.put("A", 1);
        FIRST_LETTER_VALUE_MAP.put("B", 0);
        FIRST_LETTER_VALUE_MAP.put("C", 9);
        FIRST_LETTER_VALUE_MAP.put("E", 7);
        FIRST_LETTER_VALUE_MAP.put("F", 6);
        FIRST_LETTER_VALUE_MAP.put("D", 8);
        FIRST_LETTER_VALUE_MAP.put("G", 5);
        FIRST_LETTER_VALUE_MAP.put("H", 4);
        FIRST_LETTER_VALUE_MAP.put("I", 9);
        FIRST_LETTER_VALUE_MAP.put("J", 3);
        FIRST_LETTER_VALUE_MAP.put("K", 2);
        FIRST_LETTER_VALUE_MAP.put("L", 2);
        FIRST_LETTER_VALUE_MAP.put("M", 1);
        FIRST_LETTER_VALUE_MAP.put("N", 0);
        FIRST_LETTER_VALUE_MAP.put("O", 8);
        FIRST_LETTER_VALUE_MAP.put("P", 9);
        FIRST_LETTER_VALUE_MAP.put("Q", 8);
        FIRST_LETTER_VALUE_MAP.put("R", 7);
        FIRST_LETTER_VALUE_MAP.put("S", 6);
        FIRST_LETTER_VALUE_MAP.put("T", 5);
        FIRST_LETTER_VALUE_MAP.put("U", 4);
        FIRST_LETTER_VALUE_MAP.put("V", 3);
        FIRST_LETTER_VALUE_MAP.put("W", 1);
        FIRST_LETTER_VALUE_MAP.put("X", 3);
        FIRST_LETTER_VALUE_MAP.put("Y", 2);
        FIRST_LETTER_VALUE_MAP.put("Z", 0);
    }

    public static boolean valid(final String identityNumber) {

        if (null == identityNumber) {
            return false;
        }

        if (identityNumber.isBlank()) {
            return false;
        }

        final String identityNumberUpperCase = identityNumber.toUpperCase();

        boolean result = ID_PATTERN.matcher(identityNumberUpperCase).matches();
        if (!result) {
            return false;
        }
        final char[] identityNumberChars = identityNumberUpperCase.toCharArray();
        final int checkSum = Character.getNumericValue(identityNumberChars[LAST_ID_INDEX]);
        final int calculateCheckSum = calculateCheckSum(identityNumberChars);
        return calculateCheckSum == checkSum;
    }

    /**
     * 計算checkSum
     */
    private static int calculateCheckSum(char[] identityNumberChars) {
        // 取得身份證字號第一個字母
        final String firstLetter = String.valueOf(identityNumberChars[0]);
        // 取得第一個字母對應的數字
        int sum = FIRST_LETTER_VALUE_MAP.get(firstLetter);

        // 開始計算並加總
        for (int i = 1; i < 9; i++) {
            sum += Character.getNumericValue(identityNumberChars[i]) * MULTIPLIERS[i - 1];
        }

        //除10取餘數
        int sumMod10 = sum % 10;
        return (sumMod10 == 0) ? 0 : (10 - sumMod10);
    }
}
