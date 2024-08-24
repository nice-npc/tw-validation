package com.nicenpc.twvalidation.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalPhoneNumberValidatorTest {

    @DisplayName("[正確的電話號碼][驗證格式][驗證成功]")
    @Test
    void isValid0() {
        assertTrue(LocalPhoneNumberValidator.isValid("0912345678"));
    }

    @DisplayName("[不足10碼][驗證格式][驗證失敗]")
    @Test
    void isValid1() {
        assertFalse(LocalPhoneNumberValidator.isValid("091234567"));
    }

    @DisplayName("[超過10碼][驗證格式][驗證失敗]")
    @Test
    void isValid2() {
        assertFalse(LocalPhoneNumberValidator.isValid("09123456789"));
    }

    @DisplayName("[非09開頭][驗證格式][驗證失敗]")
    @Test
    void isValid3() {
        assertFalse(LocalPhoneNumberValidator.isValid("0812345678"));
    }

}
