package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.TaskException;
import projectCalculationTool.util.exception.ValidateException;

public class TaskService {
    private TaskRepositoryInterface taskRepositoryInterface;

    public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
        this.taskRepositoryInterface = taskRepositoryInterface;
    }

    public void createTask(String taskName, String taskTime, SubProject subProject) throws ValidateException, TaskException {
        Task task = new Task(validateTaskTime(taskTime), validateTaskName(taskName));
        subProject.addTask(task);

        taskRepositoryInterface.createTask(subProject);
    }

    public Task readTask(int taskID) throws ProjectException {
        return taskRepositoryInterface.readTask(taskID);
    }

    public Task updateTask(String taskTime, String taskName) throws ProjectException, ValidateException {
        Task task = new Task(validateTaskTime(taskTime), validateTaskName(taskName));
        taskRepositoryInterface.updateTask(task);
        return task;
    }

    public void deleteTask(int taskID) throws ProjectException {
        taskRepositoryInterface.deleteTask(taskID);
    }

    public String validateTaskName(String taskName) throws ValidateException {
        if (taskName != null && !taskName.isEmpty() && taskName.length() <= 45) {
            return taskName;
        } else {
            throw new ValidateException("Task name can't be null or longer than 45 characters.");
        }
    }

    public int validateTaskTime(String taskTime) throws ValidateException {
        int time;

        if (taskTime != null && !taskTime.isEmpty()) {
            try {
                time = Integer.parseInt(taskTime);
                return time;
            } catch (NumberFormatException err) {
                throw new ValidateException("Task time has to be a number in hours.");
            }
        } else {
            throw new ValidateException("Task time cannot be empty.");
        }
    }
}