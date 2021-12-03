package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.DBManager;
import projectCalculationTool.util.exception.ProjectException;

import java.sql.*;

public class TaskRepository implements TaskRepositoryInterface {
  private static Connection connection = DBManager.getConnection();

  @Override
  public SubProject createTask(SubProject subProject) throws ProjectException {

    try {
      Task task = subProject.getTasks().get(subProject.getTasks().size() - 1);

      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUE (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, task.getName());
      preparedStatement.setDouble(2, task.getTimeHours());
      preparedStatement.setInt(3, subProject.getSubProjectID());

      preparedStatement.executeUpdate();

      ResultSet resultSet = preparedStatement.getGeneratedKeys();

      if (resultSet.next()){
        task.setTaskID(resultSet.getInt(1));
      }

      return subProject;

    } catch (SQLException e) {
      throw new ProjectException("Creating Task failed");
    }
  }

  @Override
  public SubProject readTask(SubProject subProject) {

    try {

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks WHERE fk_subproject_id = ?;");
      preparedStatement.setInt(1, subProject.getSubProjectID());

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Task task = new Task(resultSet.getDouble("task_hours"), resultSet.getString("task_name"));
        task.setTaskID(resultSet.getInt("task_id"));
        subProject.addTask(task);
      }

      return subProject;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }

  @Override
  public Task updateTask(Task task) throws ProjectException {

    try{
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tasks(task_name, task_hours) " +
          "VALUE (?, ?) WHERE task_ID = ?;");

      preparedStatement.setString(1, task.getName());
      preparedStatement.setDouble(2, task.getTimeHours());

      preparedStatement.executeQuery();

      return task;

    }catch (SQLException e){
      throw new ProjectException("Task wasn't updated");
    }
  }

  @Override
  public void deleteTask(int taskID) {
  }
}