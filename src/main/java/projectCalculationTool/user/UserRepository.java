package projectCalculationTool.user;

import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements UserRepositoryInterface {
    Connection connect = DBManager.getConnection();

    @Override
    public User read(String userMail, String userPassword) {
        try {
            PreparedStatement ps = connect.prepareStatement("CALL read_user(?,?) ");
            ps.setString(1, userMail);
            ps.setString(2, userPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                return user;
            }

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;

    }
}