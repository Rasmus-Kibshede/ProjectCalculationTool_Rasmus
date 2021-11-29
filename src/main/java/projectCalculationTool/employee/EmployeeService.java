package projectCalculationTool.employee;

import projectCalculationTool.util.exception.LoginException;

public class EmployeeService {
  private EmployeeRepositoryInterface employeeRepositoryInterface;

    public EmployeeService(EmployeeRepositoryInterface employeeRepositoryInterface) {
        this.employeeRepositoryInterface = employeeRepositoryInterface;
    }

    public Employee readEmployee(String employeeEmail, String employeePassword) throws LoginException {
        return employeeRepositoryInterface.read(employeeEmail, employeePassword);
    }

    public Employee createEmployee(Employee employee) {
        return null;
    }
}