package projectCalculationTool.employee;

public class EmployeeService {
  EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee readUser(String userMail, String userPassword){
        return employeeRepository.read(userMail, userPassword);
    }
}