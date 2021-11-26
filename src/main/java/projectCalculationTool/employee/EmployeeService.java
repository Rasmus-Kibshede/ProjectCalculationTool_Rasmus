package projectCalculationTool.employee;

public class EmployeeService {
  EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee readUser(String employeeMail, String employeePassword){
        return employeeRepository.read(employeeMail, employeePassword);
    }
}