package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubProjectRepository implements SubProjectRepositoryInterface {
    private static Connection connection = DBManager.getConnection();

    @Override
    public void create(Project project) throws SQLException {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CALL create_sub_project(?)");

            preparedStatement.setString(1, project.getSubProjects().get(0).getName());
            //preparedStatement.setArray(1, project.getSubProjects());

            //Found on https://stackoverflow.com/questions/1915166/how-to-get-the-insert-id-in-jdbc

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    project.getSubProjects().get(0).setSubProjectID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            //END

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public SubProject read(int subProjectID) {
        return null;
    }
}
