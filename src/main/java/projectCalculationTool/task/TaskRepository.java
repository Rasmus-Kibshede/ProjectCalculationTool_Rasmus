package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskRepository implements TaskRepositoryInterface {
  private static Connection connection = DBManager.getConnection();

  @Override
  public void create(SubProject subProject) throws SQLException {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("CALL create_task(?,?,?)");

      for (Task task : subProject.getTasks()) {
        preparedStatement.setString(1, task.getName());
        preparedStatement.setDouble(2, task.getTimeHours());
        preparedStatement.setInt(3, subProject.getSubProjectID());
        preparedStatement.addBatch();
      }
      preparedStatement.executeBatch();

    } catch (SQLException e) {
      throw new SQLException("Creating Task failed");
    }
  }

  @Override
  public ArrayList<Task> read(ResultSet resultSet, int subProjectID) throws SQLException {

    ArrayList<Task> tasks = new ArrayList<>();

    int counter = resultSet.getRow() - 1;


    while (resultSet.absolute(counter) && resultSet.getInt("fk_subproject_id") == subProjectID) {

      String name = resultSet.getString("task_name");
      int id = resultSet.getInt("task_id");
      double hours = resultSet.getDouble("task_hours");
      Task task = new Task(hours, name);
      task.setTaskID(id);

      tasks.add(task);
      counter++;
    }

    return tasks;
  }
}
