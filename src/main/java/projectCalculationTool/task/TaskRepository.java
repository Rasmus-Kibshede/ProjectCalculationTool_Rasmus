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
    public Task read(ResultSet resultSet) throws SQLException {
    /*try {
      PreparedStatement ps = connection.prepareStatement("CALL read_task(?)");
      ps.setInt(1,taskID);
      ResultSet rs = ps.executeQuery();

      ArrayList<Task> tasks = new ArrayList<>();

      while (rs.next()){
        int id = rs.getInt(1);
        //Skal task have en constructor?
        Task task = new Task(20,"placeholder");

        tasks.add(task);
      }
    } catch (SQLException err){
      err.printStackTrace();
    }

     */

        String name = resultSet.getString("task_name");
        int id = resultSet.getInt("task_id");
        double hours = resultSet.getDouble("task_hours");
        Task task = new Task(hours, name);
        task.setTaskID(id);

        return task;
    }
}
