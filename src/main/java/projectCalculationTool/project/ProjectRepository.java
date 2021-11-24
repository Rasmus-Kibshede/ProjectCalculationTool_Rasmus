package projectCalculationTool.project;

import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRepository implements ProjectRepositoryInterface {

  private static Connection connection = DBManager.getConnection();


  public void create(Project project){

    try{
      PreparedStatement preparedStatement = connection.prepareStatement("CALL create_project(?,?)");
      preparedStatement.setString(1, project.getName());
      preparedStatement.setDouble(2, project.getProjectHoursTotal());

      preparedStatement.executeQuery();
    }catch (SQLException e){
      e.printStackTrace(); //MAKE OWN EXCEPTION???
    }
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
