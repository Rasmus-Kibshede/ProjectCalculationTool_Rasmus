package projectCalculationTool.employee;

import org.junit.jupiter.api.Test;
import projectCalculationTool.util.exception.LoginException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    @Test
    void wrongLoginException() {
        String Email = "test@yes.com";
        String wrongpw = "nottherigtone";

        Throwable exception = assertThrows(LoginException.class, () -> employeeRepository.read(Email, wrongpw));

        assertEquals("Invalid email or password", exception.getMessage());

    }
}