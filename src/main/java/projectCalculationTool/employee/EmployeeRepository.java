package projectCalculationTool.employee;

import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository implements EmployeeRepositoryInterface {
    private static Connection connection = DBManager.getConnection();

    @Override
    public Employee read(String employeeEmail, String employeePassword) {
        try {
            PreparedStatement ps = connection.prepareStatement("CALL read_employees(?,?) ");
            ps.setString(1, employeeEmail);
            ps.setString(2, employeePassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt(1));
                employee.setEmail(rs.getString(2));
                employee.setPassword(rs.getString(3));

                return employee;
            }

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;
    }

    public Employee create(Employee employee) {
        return null;
    }
}