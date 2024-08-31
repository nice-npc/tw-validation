package com.nicenpc.twvalidation.validator;

public class HalfWidthCharacterValidator {

    public static boolean isHalfWidth(char ch) {
        return (ch >= '\u0020' && ch <= '\u007E') || (ch >= '\uFF61' && ch <= '\uFFDC');
    }

}
