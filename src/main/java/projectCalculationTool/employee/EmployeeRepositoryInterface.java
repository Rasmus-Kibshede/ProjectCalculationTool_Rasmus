package projectCalculationTool.employee;

public interface EmployeeRepositoryInterface {

    Employee read(String EmployeeEmail, String EmployeePassword);
}
