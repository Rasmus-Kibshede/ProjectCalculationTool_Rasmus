package projectCalculationTool.employee;

import projectCalculationTool.util.exception.LoginException;
import projectCalculationTool.util.exception.ValidateException;

public class EmployeeService {
  private EmployeeRepositoryInterface employeeRepositoryInterface;

    public EmployeeService(EmployeeRepositoryInterface employeeRepositoryInterface) {
        this.employeeRepositoryInterface = employeeRepositoryInterface;
    }

    public Employee readEmployee(String employeeEmail, String employeePassword) throws ValidateException, LoginException {
        return employeeRepositoryInterface.read
            (validateEmail(employeeEmail), validatePasswordLength(employeePassword));
    }

    public String validateEmail(String email) throws ValidateException {
      email = validateEmailLength(email);

      // regexApproved string Fra https://regexr.com/3e48o
      String regexApproved = "^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$";
      if (email.matches(regexApproved)) {
        return email;
      } else {
        throw new ValidateException("Please enter a valid email");
      }
    }

    public String validateEmailLength(String email) throws ValidateException{
      if (email != null && !email.isEmpty() && email.length() <= 128) {
        return email;
      } else {
        throw new ValidateException("Incorrect login information");
      }
    }

    public String validatePasswordLength(String password) throws ValidateException{
      if (password != null && !password.isEmpty() && password.length() <= 128) {
        return password;
      } else {
        throw new ValidateException("Incorrect login information");
      }
    }
}