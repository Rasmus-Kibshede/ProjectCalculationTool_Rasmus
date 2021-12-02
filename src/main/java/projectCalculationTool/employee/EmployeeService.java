package projectCalculationTool.employee;

import projectCalculationTool.util.exception.LoginException;

public class EmployeeService {
  private EmployeeRepositoryInterface employeeRepositoryInterface;

    public EmployeeService(EmployeeRepositoryInterface employeeRepositoryInterface) {
        this.employeeRepositoryInterface = employeeRepositoryInterface;
    }

    public Employee readEmployee(String employeeEmail, String employeePassword) throws LoginException {
        return employeeRepositoryInterface.read
            (validateEmail(employeeEmail), validatePasswordLength(employeePassword));
    }

    public String validateEmail(String email) throws LoginException{
      email = validateEmailLength(email);

      // regexApproved string Fra https://regexr.com/3e48o
      String regexApproved = "^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$";
      if (email.matches(regexApproved)) {
        return email;
      } else {
        throw new LoginException("This is not an email");
      }
    }

    public String validateEmailLength(String email) throws LoginException{
      if (email != null && !email.isEmpty() && email.length() <= 128) {
        return email;
      } else {
        throw new LoginException("Incorrect login information");
      }
    }

    public String validatePasswordLength(String password) throws LoginException{
      if (password != null && !password.isEmpty() && password.length() <= 128) {
        return password;
      } else {
        throw new LoginException("Incorrect login information");
      }
    }
}