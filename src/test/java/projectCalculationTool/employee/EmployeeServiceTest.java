package projectCalculationTool.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import projectCalculationTool.util.exception.LoginException;
import projectCalculationTool.util.exception.ValidateException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService(null);
    }

    @ParameterizedTest
    @CsvSource(value = {"test@", "test", "@hej.dk", ".", "hej.dk"})
    public void invalidEmailTest(String email) {
        assertThrows(LoginException.class, () -> employeeService.validateEmail(email));
    }

    @Test
    void validatePasswordLength() throws ValidateException {
        String pw = "what a password";

        String actual = employeeService.validatePasswordLength(pw);

        assertEquals(pw, actual);
    }

    @Test
    void emailTooLong() throws ValidateException {
        String email = "Thismailisgoingtobeaverylong@emailandcrashtheprogram´justafewmorejusttobesafebecauseimnotsurehowlongthisisjhagshfgaslfhgasfhgasfkjahsgfjhsafgkjasfgkasfgkhasfgasjkfgsahfkghasgashkf.com";

        Throwable exception = assertThrows(ValidateException.class, () -> employeeService.validateEmail(email));

        assertEquals("Incorrect login information", exception.getMessage());
    }


}