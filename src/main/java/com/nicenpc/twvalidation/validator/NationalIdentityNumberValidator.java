package com.nicenpc.twvalidation.validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NationalIdentityNumberValidator {
    private static final Integer LAST_ID_INDEX = 9;
    private static final String REGEX = "[A-Z][12]\\d{8}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final int[] MULTIPLIERS = {8, 7, 6, 5, 4, 3, 2, 1};
    private static final Map<String, Integer> FIRST_LETTER_VALUE_MAP;

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 0);
        map.put("C", 9);
        map.put("D", 8);
        map.put("E", 7);
        map.put("F", 6);
        map.put("G", 5);
        map.put("H", 4);
        map.put("I", 9);
        map.put("J", 3);
        map.put("K", 2);
        map.put("L", 2);
        map.put("M", 1);
        map.put("N", 0);
        map.put("O", 8);
        map.put("P", 9);
        map.put("Q", 8);
        map.put("R", 7);
        map.put("S", 6);
        map.put("T", 5);
        map.put("U", 4);
        map.put("V", 3);
        map.put("W", 1);
        map.put("X", 3);
        map.put("Y", 2);
        map.put("Z", 0);
        FIRST_LETTER_VALUE_MAP = Collections.unmodifiableMap(map);
    }

    /**
     * 驗證身分證字號
     *
     * @param identityCardNumber 身份證字號
     */
    public static boolean valid(final String identityCardNumber) {
        if (null == identityCardNumber) {
            return false;
        }

        if (identityCardNumber.isBlank()) {
            return false;
        }

        final String upperCaseIdentityCardNumber = identityCardNumber.toUpperCase();

        boolean result = validFormat(upperCaseIdentityCardNumber);
        if (!result) {
            return false;
        }
        final char[] identityNumberChars = upperCaseIdentityCardNumber.toCharArray();
        final int checkSum = Character.getNumericValue(identityNumberChars[LAST_ID_INDEX]);
        final int calculateCheckSum = calculateCheckSum(identityNumberChars);
        return validCheckNumber(calculateCheckSum, checkSum);
    }

    /**
     * 驗證格式
     *
     * @param taiwanIdentityNumber 身份證字號
     */
    static boolean validFormat(String taiwanIdentityNumber) {
        final Matcher matcher = PATTERN.matcher(taiwanIdentityNumber);
        return matcher.matches();
    }


    /**
     * 計算checkSum
     *
     * @param identityNumberChars 身分證字號char[]
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

    /**
     * 計算出來的數值是否與最後一位檢查碼相同
     *
     * @param calculateCheckSum  計算出的checkSum
     * @param lastIdentityNumber 身分證字號最後一碼
     */
    private static boolean validCheckNumber(int calculateCheckSum, int lastIdentityNumber) {
        return calculateCheckSum == lastIdentityNumber;
    }


}
