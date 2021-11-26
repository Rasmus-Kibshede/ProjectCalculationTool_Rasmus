package projectCalculationTool.employee;

public class EmployeeService {
  EmployeeRepositoryInterface employeeRepositoryInterface;

    public EmployeeService(EmployeeRepositoryInterface employeeRepositoryInterface) {
        this.employeeRepositoryInterface = employeeRepositoryInterface;
    }

    public Employee readEmployee(String employeeEmail, String employeePassword){
        return employeeRepositoryInterface.read(employeeEmail, employeePassword);
    }

    public Employee createEmployee(Employee employee) {
        return null;
    }
}