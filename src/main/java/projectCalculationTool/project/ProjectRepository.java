package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.subproject.SubProjectRepository;
import projectCalculationTool.util.DBManager;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.SubProjectException;

import java.sql.*;
import java.util.ArrayList;

public class ProjectRepository implements ProjectRepositoryInterface {

  private static Connection connection = DBManager.getConnection();
  private final SubProjectRepository SUBPROJECT_REPOSITORY = new SubProjectRepository();

  public void createProject(Project project) throws ProjectException {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO projects(project_name, fk_employee_ID) VALUE (?, ?);", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, project.getName());
      preparedStatement.setInt(2, project.getEmployee().getEmployeeID());

      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();

      if (resultSet.next()) {
        project.setProjectID(resultSet.getInt(1));
      }

    } catch (SQLException e) {
      throw new ProjectException("Creating project failed", e);
    }
  }


  public Project readProject(int projectID) throws ProjectException {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM projects WHERE project_id = ?;");
      preparedStatement.setInt(1, projectID);

      ResultSet resultSet = preparedStatement.executeQuery();

      Project project = new Project();

      if (resultSet.next()) {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        project.setName(name);
        project.setProjectID(id);

        project = SUBPROJECT_REPOSITORY.readAllSubProjects(project);
        project.calculateWorkdaysDaysTotal();
        return project;
      } else {
        throw new ProjectException("Invalid Project");
      }

    } catch (SQLException err) {
      throw new ProjectException("Failed read project", err);
    } catch (SubProjectException err) {
      throw new ProjectException("Failed read subproject", err);
    }
  }

  public ArrayList<Project> readAllProjects(Employee employee) throws ProjectException {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM projects WHERE fk_employee_id = ?;");
      preparedStatement.setInt(1, employee.getEmployeeID());
      ResultSet resultSet = preparedStatement.executeQuery();


      ArrayList<Project> projects = new ArrayList<>();

      while (resultSet.next()) {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        Project project = new Project();
        project.setName(name);
        project.setProjectID(id);
        projects.add(project);
        project.setSubProjects(SUBPROJECT_REPOSITORY.readAllSubProjects(project).getSubProjects());
        project.calculateWorkdaysDaysTotal();
      }

      return projects;
    } catch (SQLException e) {
      throw new ProjectException("Reading projects failed.", e);
    } catch (SubProjectException err) {
      throw new ProjectException("Failed read subproject", err);
    }
  }

  @Override
  public void updateProject(Project project) throws ProjectException {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE projects SET project_name = ? WHERE project_id = ?");
      preparedStatement.setString(1, project.getName());
      preparedStatement.setInt(2, project.getProjectID());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new ProjectException("Updating project failed.", e);
    }
  }

  @Override
  public void deleteProject(int projectID) throws ProjectException {
    try {

      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM projects WHERE project_id = ?;");
      preparedStatement.setInt(1, projectID);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new ProjectException("Deleting project failed", e);
    }
  }
}