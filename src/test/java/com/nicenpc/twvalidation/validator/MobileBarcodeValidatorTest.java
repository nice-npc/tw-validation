package com.nicenpc.twvalidation.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobileBarcodeValidatorTest {
    @DisplayName("[正確的手機條碼且含數字、大寫英文、符號][驗證格式][驗證成功]")
    @Test
    void isValid0() {
        assertTrue(MobileBarcodeValidator.isValid("/KA-IU+0"));
    }

    @DisplayName("[不足8碼][驗證格式][驗證失敗]")
    @Test
    void isValid1() {
        assertFalse(MobileBarcodeValidator.isValid("/.KA-IU"));
    }

    @DisplayName("[超過8碼][驗證格式][驗證失敗]")
    @Test
    void isValid2() {
        assertFalse(MobileBarcodeValidator.isValid("/.KA-IU+2048"));
    }

    @DisplayName("[含有異常字元][驗證格式][驗證失敗]")
    @Test
    void isValid3() {
        assertFalse(MobileBarcodeValidator.isValid("/.KA:IU+"));
    }

    @DisplayName("[開頭不是斜線][驗證格式][驗證失敗]")
    @Test
    void isValid4() {
        assertFalse(MobileBarcodeValidator.isValid("A.KA-IU+"));
    }

    @DisplayName("[含有英文小寫][驗證格式][驗證失敗]")
    @Test
    void isValid5() {
        assertFalse(MobileBarcodeValidator.isValid("/.ka-IU+"));
    }
}
