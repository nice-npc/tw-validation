
import com.nicenpc.twvalidation.validator.NationalIdentityNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class NationalIdentityNumberValidatorTest {


    @Test
    @DisplayName("[正確的身分證號碼][驗證格式][驗證成功]")
    public void test1()  {
        boolean result = NationalIdentityNumberValidator.valid("A123456789");
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("[身分證開頭不是大寫英文][驗證格式][驗證成功]")
    public void test2() {
        boolean result = NationalIdentityNumberValidator.valid("a123456789");
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("[身分證開頭不是大寫英文][驗證格式][驗證失敗]")
    public void test3() {
        boolean result = NationalIdentityNumberValidator.valid("@123456789");
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("[錯誤的身分證號碼][驗證格式][驗證失敗]")
    public void test4() {
        boolean result = NationalIdentityNumberValidator.valid("A000000000");
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("[錯誤的身分證號碼][驗證格式][驗證失敗]")
    public void test5() {
        boolean result = NationalIdentityNumberValidator.valid("A123456788");
        Assertions.assertFalse(result);
    }


}