package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.task.TaskRepository;
import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubProjectRepository implements SubProjectRepositoryInterface {
  private static Connection connection = DBManager.getConnection();
  private final TaskRepository TASK_REPOSITORY = new TaskRepository();

  @Override
  public void createSubProject(Project project) throws SQLException {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("CALL create_sub_project(?,?)");

      ArrayList<SubProject> subprojects = project.getSubProjects();
      int lastIndex = subprojects.size() - 1;
      SubProject lastSubProject = subprojects.get(lastIndex);

      preparedStatement.setInt(2, project.getProjectID());
      preparedStatement.setString(1, lastSubProject.getName());


      connection.setAutoCommit(false);
      int affectedRows = preparedStatement.executeUpdate();

      PreparedStatement preparedStatement2 = connection.prepareStatement("CALL get_last_id");
      ResultSet resultSet = preparedStatement2.executeQuery();

      if (resultSet.next()) {
        lastSubProject.setSubProjectID(resultSet.getInt(1));
      }

      /*Found on https://stackoverflow.com/questions/1915166/how-to-get-the-insert-id-in-jdbc  */
      if (affectedRows == 0) {
        throw new SQLException("Creating subproject failed");
      }
      /*Done*/

      TASK_REPOSITORY.createTask(lastSubProject);
      connection.commit();

    } catch (SQLException e) {
      throw new SQLException(e.getMessage());
    }
  }

  @Override
  public ArrayList<SubProject> readSubProject(ResultSet resultSet) throws SQLException {

    ArrayList<SubProject> subProjects = new ArrayList<>();

    while (resultSet.next()) {

      int id = resultSet.getInt("subproject_id");

      String name = resultSet.getString("subproject_name");
      SubProject subProject = new SubProject(name);
      subProject.setSubProjectID(id);

      subProject.setTasks(TASK_REPOSITORY.readTask(resultSet, id));

      subProjects.add(subProject);
    }


    return subProjects;
  }

  @Override
  public SubProject updateSubProject(SubProject subProject) {
    return null;
  }

  @Override
  public void deleteSubProject(int subProjectID) {

  }
}
