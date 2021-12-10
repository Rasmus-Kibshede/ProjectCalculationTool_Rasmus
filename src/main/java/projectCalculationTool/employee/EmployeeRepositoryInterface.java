package projectCalculationTool.employee;

import projectCalculationTool.util.exception.LoginException;

public interface EmployeeRepositoryInterface {

    Employee readEmployee(String EmployeeEmail, String EmployeePassword) throws LoginException;
}
