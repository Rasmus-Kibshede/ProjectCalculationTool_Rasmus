package projectCalculationTool.employee;

public interface EmployeeRepositoryInterface {

    Employee read(String userMail, String userPassword);
}
