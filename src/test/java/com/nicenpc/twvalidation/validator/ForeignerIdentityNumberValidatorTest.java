package com.nicenpc.twvalidation.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ForeignerIdentityNumberValidatorTest {

    @Test
    @DisplayName("[正確的外來人口統一證號][驗證格式][驗證成功]")
    public void test1() {
        boolean result = ForeignerIdentityNumberValidator.valid("A861084629");
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("[外來人口統一證號開頭不是大寫英文][驗證格式][驗證成功]")
    public void test2() {
        boolean result = ForeignerIdentityNumberValidator.valid("k840280175");
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("[外來人口統一證號開頭不是大寫英文][驗證格式][驗證失敗]")
    public void test3() {
        boolean result = ForeignerIdentityNumberValidator.valid("@123456789");
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("[錯誤的外來人口統一證號][驗證格式][驗證失敗]")
    public void test4() {
        boolean result = ForeignerIdentityNumberValidator.valid("A000000000");
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("[錯誤的外來人口統一證號][驗證格式][驗證失敗]")
    public void test5() {
        boolean result = ForeignerIdentityNumberValidator.valid("A123456788");
        Assertions.assertFalse(result);
    }

}