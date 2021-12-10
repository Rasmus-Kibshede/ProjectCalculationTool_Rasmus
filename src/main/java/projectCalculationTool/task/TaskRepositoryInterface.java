package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.TaskException;

public interface TaskRepositoryInterface {
    void createTask(SubProject subProject) throws TaskException;

    SubProject readAllTasks(SubProject subProject) throws TaskException;

    Task readTask(int taskID) throws TaskException;

    void updateTask(Task task) throws TaskException;

    void deleteTask(int taskID) throws TaskException;
}