package com.nicenpc.twvalidation.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NationalPhoneNumberValidatorTest {

    @DisplayName("[正確的電話號碼][驗證格式][驗證成功]")
    @Test
    void isValid() {
        assertTrue(NationalPhoneNumberValidator.isValid("+886912345678"));
    }

    @DisplayName("[不足13碼][驗證格式][驗證失敗]")
    @Test
    void isValid1() {
        assertFalse(NationalPhoneNumberValidator.isValid("+88691234567"));
    }

    @DisplayName("[超過13碼][驗證格式][驗證失敗]")
    @Test
    void isValid2() {
        assertFalse(NationalPhoneNumberValidator.isValid("+8869123456789"));
    }

    @DisplayName("[非+886開頭][驗證格式][驗證失敗]")
    @Test
    void isValid3() {
        assertFalse(NationalPhoneNumberValidator.isValid("0912345678"));
    }

}
