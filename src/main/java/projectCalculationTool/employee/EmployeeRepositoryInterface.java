package projectCalculationTool.employee;

import projectCalculationTool.util.exception.LoginException;

public interface EmployeeRepositoryInterface {

    Employee read(String EmployeeEmail, String EmployeePassword) throws LoginException;
}
