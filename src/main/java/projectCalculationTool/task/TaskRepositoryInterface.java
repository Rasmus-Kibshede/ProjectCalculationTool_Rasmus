package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.TaskException;

public interface TaskRepositoryInterface {
  SubProject createTask(SubProject subProject) throws TaskException;

  SubProject readAllTasks(SubProject subProject) throws ProjectException;

  Task readTask(int taskID) throws ProjectException;

  Task updateTask(Task task) throws ProjectException;

  void deleteTask(int taskID) throws ProjectException;
}