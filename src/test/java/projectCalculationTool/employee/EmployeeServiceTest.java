package projectCalculationTool.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import projectCalculationTool.util.exception.LoginException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private  EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService(null);
    }

    @ParameterizedTest
    @CsvSource(value = {"test@", "test", "@hej.dk", ".", "hej.dk"})
    public void invalidEmailTest(String email) {
        assertThrows(LoginException.class, ()->employeeService.validateEmail(email));
    }
}