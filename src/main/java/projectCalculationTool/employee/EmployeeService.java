package projectCalculationTool.employee;

import projectCalculationTool.util.exception.LoginException;

import java.sql.SQLException;

public class EmployeeService {
  private EmployeeRepositoryInterface employeeRepositoryInterface;

    public EmployeeService(EmployeeRepositoryInterface employeeRepositoryInterface) {
        this.employeeRepositoryInterface = employeeRepositoryInterface;
    }

    public Employee readEmployee(String employeeEmail, String employeePassword) throws LoginException {
        return employeeRepositoryInterface.read
            (validateEmailLength(employeeEmail), validatePasswordLength(employeePassword));
    }

    //SKAL VEL FJERNES???
    public Employee createEmployee(Employee employee) {
        return null;
    }


    public String validateEmailLength(String email) throws LoginException{
      if (email != null && !email.isEmpty() && email.length() <= 128) {
        return email;
      } else {
        throw new LoginException("incorrect login information");
      }
    }

    public String validatePasswordLength(String password) throws LoginException{
      if (password != null && !password.isEmpty() && password.length() <= 128) {
        return password;
      } else {
        throw new LoginException("incorrect login information");
      }
    }


}