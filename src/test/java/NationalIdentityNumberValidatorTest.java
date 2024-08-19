
import com.nicenpc.twvalidation.exception.InvalidNationalIdentityNumberException;
import com.nicenpc.twvalidation.validator.ErrorMessage;
import com.nicenpc.twvalidation.validator.NationalIdentityNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NationalIdentityNumberValidatorTest {


    @Test
    @DisplayName("[正確的身分證號碼][驗證格式][驗證成功]")
    public void test1() throws InvalidNationalIdentityNumberException {
        NationalIdentityNumberValidator.valid("A123456789");
    }

    @Test
    @DisplayName("[身分證開頭不是大寫英文][驗證格式][驗證失敗]")
    public void test2() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("a123456789");
        });
        assertEquals(ErrorMessage.WRONG_FORMAT.name(), exception.getMessage());
    }

    @Test
    @DisplayName("[身分證開頭不是大寫英文][驗證格式][驗證失敗]")
    public void test3() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("@123456789");
        });
        assertEquals(ErrorMessage.WRONG_FORMAT.name(), exception.getMessage());
    }

    @Test
    @DisplayName("[錯誤的身分證號碼][驗證格式][驗證失敗]")
    public void test4() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A000000000");
        });
        assertEquals(ErrorMessage.WRONG_FORMAT.name(), exception.getMessage());
    }

    @Test
    @DisplayName("[錯誤的身分證號碼][驗證格式][驗證失敗]")
    public void test5() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A123456788");
        });
        assertEquals(ErrorMessage.INVALID_NATIONAL_IDENTITY_NUMBER.name(), exception.getMessage());
    }


}