package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;

import java.sql.SQLException;

public interface TaskRepositoryInterface {
  SubProject createTask(SubProject subProject) throws ProjectException;

  SubProject readTask(SubProject subProject) throws ProjectException;

  Task updateTask(Task task) throws ProjectException;

  void deleteTask(int taskID);
}