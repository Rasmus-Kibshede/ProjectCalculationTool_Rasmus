package projectCalculationTool.employee;

import com.mysql.cj.log.Log;
import org.junit.jupiter.api.Test;
import projectCalculationTool.util.DBManager;
import projectCalculationTool.util.exception.LoginException;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Test()
    public void test_Login_Exception() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        assertThrows(LoginException.class, () -> employeeRepository.read("test", "123"));
    }

    @Test
    public void test_Login_credentials() throws LoginException {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = employeeRepository.read("test@yes.com","123");

        assertNotNull(employee);

    }



}