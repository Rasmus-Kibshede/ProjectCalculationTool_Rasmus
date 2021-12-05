package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.TaskException;

public interface TaskRepositoryInterface {
    SubProject createTask(SubProject subProject) throws TaskException;

    SubProject readAllTasks(SubProject subProject) throws TaskException;

    Task readTask(int taskID) throws TaskException;

    Task updateTask(Task task) throws TaskException;

    void deleteTask(int taskID) throws TaskException;
}