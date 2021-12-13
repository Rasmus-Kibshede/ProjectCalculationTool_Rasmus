package projectCalculationTool.employee;

import projectCalculationTool.util.DBManager;
import projectCalculationTool.util.exception.LoginException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository implements EmployeeRepositoryInterface {
    private static Connection connection = DBManager.getConnection();

    @Override
    public Employee readEmployee(String employeeEmail, String employeePassword) throws LoginException {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM employees WHERE employee_email = ? and employee_password = ?;");
            ps.setString(1, employeeEmail);
            ps.setString(2, employeePassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt(1));
                employee.setEmail(rs.getString(2));
                employee.setPassword(rs.getString(3));

                return employee;
            } else {
                throw new LoginException("Invalid email or password");
            }

        } catch (SQLException err) {
            throw new LoginException("Failed read employee", err);
        }
    }
}