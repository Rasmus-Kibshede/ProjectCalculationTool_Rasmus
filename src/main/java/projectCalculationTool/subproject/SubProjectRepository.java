package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.task.TaskRepository;
import projectCalculationTool.util.DBManager;
import projectCalculationTool.util.exception.SubProjectException;
import projectCalculationTool.util.exception.TaskException;

import java.sql.*;

public class SubProjectRepository implements SubProjectRepositoryInterface {
  private static Connection connection = DBManager.getConnection();
  private final TaskRepository TASK_REPOSITORY = new TaskRepository();

  @Override
  public void createSubProject(Project project) throws SubProjectException {

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
      throw new SubProjectException("Failed creating subproject", e);
    }
  }

  @Override
  public SubProject readSubProject(int subprojectID) throws SubProjectException {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM subprojects WHERE subproject_id = ?");
      preparedStatement.setInt(1, subprojectID);

      ResultSet resultSet = preparedStatement.executeQuery();
      SubProject subProject = null;

      while (resultSet.next()) {
        subProject = new SubProject(resultSet.getString("subproject_name"));

        subProject.setSubProjectID(resultSet.getInt("subproject_id"));

        subProject = TASK_REPOSITORY.readAllTasks(subProject);
      }
      return subProject;

    }catch (SQLException err) {
      throw new SubProjectException("Could not read subproject", err);
    }catch (TaskException err) {
      throw new SubProjectException("Could not read tasks", err);
    }
  }

  @Override
  public Project readSubProjects(Project project) throws SubProjectException {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM subprojects WHERE fk_project_id = ?");

      preparedStatement.setInt(1, project.getProjectID());

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        SubProject subProject = new SubProject(resultSet.getString("subproject_name"));

        subProject.setSubProjectID(resultSet.getInt("subproject_id"));

        subProject = TASK_REPOSITORY.readAllTasks(subProject);

        project.addSubproject(subProject);
      }

      return project;

    } catch (SQLException e) {
      throw new SubProjectException("Read subproject failed", e);

    }catch (TaskException err) {
      throw new SubProjectException("Read tasks failed", err);
    }
  }

  @Override
  public void updateSubProject(int id, String name) throws SubProjectException {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE subprojects SET subproject_name = ? WHERE subproject_id = ?");
      preparedStatement.setString(1, name);
      preparedStatement.setInt(2, id);

      preparedStatement.executeUpdate();

    }catch (SQLException err) {
      throw new SubProjectException("Could not update subproject.", err);
    }
  }

  @Override
  public void deleteSubProject(int subProjectID) throws SubProjectException {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM subprojects WHERE subproject_id = ?;");
      preparedStatement.setInt(1, subProjectID);

      preparedStatement.executeUpdate();

    }catch (SQLException err) {
      throw new SubProjectException("Could not delete subproject", err);
    }
  }
}