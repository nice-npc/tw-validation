package com.nicenpc.twvalidation.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HalfWidthCharacterValidatorTest {

    @DisplayName("[半形字元][驗證成功]")
    @Test
    void isHalfWidth0() {
        assertTrue(HalfWidthCharacterValidator.isHalfWidth('A'));
    }

    @DisplayName("[全形字元][驗證失敗]")
    @Test
    void isHalfWidth1() {
        assertFalse(HalfWidthCharacterValidator.isHalfWidth('Ａ'));
    }

    @DisplayName("[半形標點符號][驗證成功]")
    @Test
    void isHalfWidth2() {
        assertTrue(HalfWidthCharacterValidator.isHalfWidth('!'));
    }

    @DisplayName("[全形標點符號][驗證失敗]")
    @Test
    void isHalfWidth3() {
        assertFalse(HalfWidthCharacterValidator.isHalfWidth('！'));
    }

    @DisplayName("[空白字元][驗證成功]")
    @Test
    void isHalfWidth4() {
        assertTrue(HalfWidthCharacterValidator.isHalfWidth(' '));
    }

}
