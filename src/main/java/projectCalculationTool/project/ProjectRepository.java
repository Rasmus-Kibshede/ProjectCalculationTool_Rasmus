package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.subproject.SubProjectRepository;
import projectCalculationTool.util.DBManager;

import java.sql.*;
import java.util.ArrayList;

public class ProjectRepository implements ProjectRepositoryInterface {

  private static Connection connection = DBManager.getConnection();
  private final SubProjectRepository SUB_PROJECT_REPOSITORY = new SubProjectRepository();

  public void createProject(Project project) throws SQLException {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("CALL create_project(?,?)");
      if (project.getName() != null && project.getName().length() <= 45) {
        preparedStatement.setString(1, project.getName());
      } else {
        throw new SQLException("Project name can't be null or longer then 45 characters.");
      }

      preparedStatement.setInt(2, project.getEmployee().getEmployeeID());

      /*Found on https://stackoverflow.com/questions/1915166/how-to-get-the-insert-id-in-jdbc  */
      int affectedRows = preparedStatement.executeUpdate();

      //Do we need this?
      //How to trigger this?
      if (affectedRows == 0) {
        throw new SQLException("Creating subproject failed");
      }

      setProjectID(project);

    } catch (SQLException e) {
      throw new SQLException(e.getMessage());
    }
  }

  public void setProjectID(Project project) throws SQLException {
    PreparedStatement preparedStatement2 = connection.prepareStatement("CALL get_last_id()");
    ResultSet resultSet = preparedStatement2.executeQuery();

    if (resultSet.next()) {
      project.setProjectID(resultSet.getInt(1));
    }
  }


  public Project readProject(int projectID) throws SQLException {

    try {
      // Resultset default kan kun bevæge sig frem - derfor gøres brug af type_scroll_insensitive og concur_read_only
      //læs på disse

      //ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
      //Found on: https://www.codejava.net/java-se/jdbc/how-to-use-scrollable-result-sets-with-jdbc

      PreparedStatement preparedStatement = connection.prepareStatement("CALL read_project(?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      preparedStatement.setInt(1, projectID);

      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.getRow();
      Project project = new Project();


      if (resultSet.first()) {
        project.setProjectID(resultSet.getInt("project_id"));
        project.setName(resultSet.getString("project_name"));

        project.setSubProjects(SUB_PROJECT_REPOSITORY.readSubProject(resultSet));
      } else {
        throw new SQLException("Could not find an employee");
      }

      return project;

    } catch (SQLException e) {
      throw new SQLException(e.getMessage());
    }
  }

  public ArrayList<Project> readProjects(Employee employee) {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("CALL read_projects(?)");
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
      }

      return projects;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Project updateProject(Project project) {
    return null;
  }

  @Override
  public void deleteProject(int projectID) {

  }
}
