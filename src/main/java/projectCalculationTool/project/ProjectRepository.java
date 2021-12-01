package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.subproject.SubProjectRepository;
import projectCalculationTool.task.Task;
import projectCalculationTool.task.TaskRepository;
import projectCalculationTool.util.DBManager;

import java.sql.*;
import java.util.ArrayList;

public class ProjectRepository implements ProjectRepositoryInterface {

  private static Connection connection = DBManager.getConnection();
  private final SubProjectRepository SUB_PROJECT_REPOSITORY = new SubProjectRepository();
  private final TaskRepository TASK_REPOSITORY = new TaskRepository();

  public void create(Project project) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("CALL create_project(?,?)");
      preparedStatement.setString(1, project.getName());
      preparedStatement.setInt(2, project.getEmployee().getEmployeeID());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace(); //MAKE OWN EXCEPTION???
    }
  }

  public Project readProject(int projectID) throws SQLException {

    try {
      // Resultset defaulæt kan kun bevæge sig frem - derfor gøres brug af type_scroll_insensitive og concur_read_only
      //læs på disse
      PreparedStatement preparedStatement = connection.prepareStatement("CALL read_project(?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      preparedStatement.setInt(1, projectID);

      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.getRow();
      Project project = new Project();


      if (resultSet.first()) {
        project.setProjectID(resultSet.getInt("project_id"));
        project.setName(resultSet.getString("project_name"));

        project.setSubProjects(SUB_PROJECT_REPOSITORY.read(resultSet));
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
}
