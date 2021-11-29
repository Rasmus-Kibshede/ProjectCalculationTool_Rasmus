package projectCalculationTool.task;

import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRepository implements TaskRepositoryInterface {
  private static Connection connection = DBManager.getConnection();

  @Override
  public void create(Task task) throws SQLException{

    try{
      PreparedStatement preparedStatement = connection.prepareStatement("CALL create_task(?)"); //LAV STORED PROCEDURE

      preparedStatement.setString(1, task.getName());
      preparedStatement.setDouble(2, task.getTimeHours());
      preparedStatement.setInt(3, task.getSubProject().getSubProjectID());

      preparedStatement.executeUpdate();

    }catch (SQLException e){
      throw new SQLException("Creating Task failed");
    }

  }

  @Override
  public Task read(int taskID) {
    return null;
  }
}
