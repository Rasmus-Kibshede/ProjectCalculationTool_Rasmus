package projectCalculationTool.project;

import projectCalculationTool.util.DBManager;

import java.sql.*;

public class ProjectRepository implements ProjectRepositoryInterface {

  private static Connection connection = DBManager.getConnection();

  public Project create(Project project){

    try{
      String SQL = "INSERT INTO projects (project_name) VALUES (?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      //PreparedStatement preparedStatement = connection.prepareStatement("CALL create_project(?,?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, project.getName());
      //preparedStatement.setDouble(2, project.getProjectHoursTotal());

      //preparedStatement.executeQuery();
      preparedStatement.executeUpdate();

      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      resultSet.next();
      int id = resultSet.getInt(1);

      project.setProjectID(id);

      return project;

    }catch (SQLException e){
      e.printStackTrace(); //MAKE OWN EXCEPTION???
    }

    return null;
  }

  public Project read(int projectID){

    try{
      PreparedStatement preparedStatement = connection.prepareStatement("CALL read_project(?)");
      preparedStatement.setInt(1, projectID);

      ResultSet resultSet = preparedStatement.executeQuery();

      if(resultSet.next()){
        Project project = new Project();
        project.setProjectID(projectID);
        project.setName(resultSet.getString("project_name"));

        return project;
      }
    }catch (SQLException e){
      e.printStackTrace();
    }

    return null;
  }
}
