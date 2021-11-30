package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.task.TaskRepository;
import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubProjectRepository implements SubProjectRepositoryInterface {
    private static Connection connection = DBManager.getConnection();
    private final TaskRepository TASK_REPOSITORY = new TaskRepository();

    @Override
    public void create(Project project) throws SQLException {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CALL create_sub_project(?,?)");

            ArrayList<SubProject> subprojects = project.getSubProjects();
            int lastIndex = subprojects.size() - 1;
            SubProject lastSubProject = subprojects.get(lastIndex);

            preparedStatement.setInt(2, project.getProjectID());
            preparedStatement.setString(1, lastSubProject.getName());


            connection.setAutoCommit(false);
            int affectedRows = preparedStatement.executeUpdate();

            /*Found on https://stackoverflow.com/questions/1915166/how-to-get-the-insert-id-in-jdbc  */
            if (affectedRows == 0) {
                throw new SQLException("Creating subproject failed");
            }
            /*Done*/

            TASK_REPOSITORY.create(lastSubProject);
            connection.commit();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public SubProject read(int subProjectID) {
        return null;
    }
}
