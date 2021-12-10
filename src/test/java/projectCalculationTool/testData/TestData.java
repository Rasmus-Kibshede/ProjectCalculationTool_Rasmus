package projectCalculationTool.testData;

import projectCalculationTool.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestData {

  public void setUp() {
    try {
      Connection connection = DBManager.getConnection();
      PreparedStatement st;

      st = connection.prepareStatement("DELETE FROM projects WHERE project_id = 1");
      st.executeUpdate();

      st = connection.prepareStatement("DELETE FROM employees WHERE employee_id = 1");
      st.executeUpdate();


      st = connection.prepareStatement("INSERT INTO employees(employee_id, employee_email, employee_password) VALUES (1, 'testData@yes.com', '123')");
      st.executeUpdate();

      st = connection.prepareStatement("INSERT INTO projects(project_id, project_name, fk_employee_id) VALUES (1, 'testData_Project', 1)");
      st.executeUpdate();

      st = connection.prepareStatement("INSERT INTO subprojects(subproject_id, subproject_name, fk_project_id) VALUES (1, 'testData_SubProject_1', 1), (2, 'testData_SubProject_2', 1), (3, 'testData_SubProject_3', 1), (4, 'testData_SubProject_4', 1), (5, 'testData_SubProject_5', 1)");
      st.executeUpdate();

      st = connection.prepareStatement("INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ('testData_Task_1', 65, 1), ('testData_Task_2', 45, 1), ('testData_Task_3', 205, 2), ('testData_Task_4', 85, 2), ('testData_Task_5', 55, 2), ('testData_Task_6', 525, 3), ('testData_Task_7', 198, 3), ('testData_Task_8', 68, 4), ('testData_Task_9', 45, 4), ('testData_Task_10', 10, 5), ('testData_Task_11', 12, 5);");
      st.executeUpdate();


     /* st.addBatch("DELETE FROM employees WHERE employee_id = 1");
      st.addBatch("DELETE FROM projects WHERE project_id = 1");

      st.addBatch("INSERT INTO INSERT INTO employees(employee_id, employee_email, employee_password) VALUES (1, 'testData@yes.com', '123')");

      st.addBatch("INSERT INTO projects(project_id, project_name, fk_employee_id) VALUES (1, 'testData_Project', 1)");

      st.addBatch("INSERT INTO subprojects(subproject_id, subproject_name, fk_project_id) VALUES (1, 'testData_SubProject_1', 1), (2, 'testData_SubProject_2', 1), (3, 'testData_SubProject_3', 1), (4, 'testData_SubProject_4', 1), (5, 'testData_SubProject_5', 1)");

      st.addBatch("INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ('testData_Task_1', 65, 1), ('testData_Task_2', 45, 1), ('testData_Task_3', 205, 2), ('testData_Task_4', 85, 2), ('testData_Task_5', 55, 2), ('testData_Task_6', 525, 3), ('testData_Task_7', 198, 3), ('testData_Task_8', 68, 4), ('testData_Task_9', 45, 4), ('testData_Task_10', 10, 5), ('testData_Task_11', 12, 5);");

      st.executeBatch();

      connection.commit();*/


    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
