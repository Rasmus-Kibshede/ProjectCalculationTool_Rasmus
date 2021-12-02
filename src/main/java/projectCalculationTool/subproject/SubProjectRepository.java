package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.task.TaskRepository;
import projectCalculationTool.util.DBManager;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class SubProjectRepository implements SubProjectRepositoryInterface {
  private static Connection connection = DBManager.getConnection();
  private final TaskRepository TASK_REPOSITORY = new TaskRepository();

  @Override
  public void createSubProject(Project project) throws SQLException {

    try {
      SubProject subProject = project.getSubProjects().get(project.getSubProjects().size() - 1);

      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subprojects(subproject_name, fk_project_id) VALUE (?, ?);", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, subProject.getName());
      preparedStatement.setInt(2, project.getProjectID());

      preparedStatement.executeUpdate();

      ResultSet resultSet = preparedStatement.getGeneratedKeys();

      if (resultSet.next()) {
        subProject.setSubProjectID(resultSet.getInt(1));
      }

    } catch (SQLException e) {
      throw new SQLException(e.getMessage());
    }
  }

  @Override
  public Project readSubProject(Project project) {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM subprojects WHERE fk_project_id = ?");

      preparedStatement.setInt(1, project.getProjectID());

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        SubProject subProject = new SubProject();

        subProject.setSubProjectID(resultSet.getInt("subproject_id"));
        subProject.setName(resultSet.getString("subproject_name"));

        subProject = TASK_REPOSITORY.readTask(subProject);

        project.addSubproject(subProject);
      }



      return project;

    } catch (SQLException e) {
      //Ret til en passende exception
      return null;
    }

  }

  @Override
  public SubProject updateSubProject(SubProject subProject) {
    return null;
  }

  @Override
  public void deleteSubProject(int subProjectID) {

  }
}
