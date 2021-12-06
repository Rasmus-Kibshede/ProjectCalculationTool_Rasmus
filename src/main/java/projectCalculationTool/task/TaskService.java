package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.TaskException;
import projectCalculationTool.util.exception.ValidateException;

public class TaskService {
    private TaskRepositoryInterface taskRepositoryInterface;

    public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
        this.taskRepositoryInterface = taskRepositoryInterface;
    }

    public void createTask(String taskName, String taskTime, SubProject subProject) throws ValidateException, TaskException {
        String newTaskName = validateTaskName(taskName);
        int newTaskTime = validateTaskTime(taskTime);

        Task task = new Task(newTaskTime, newTaskName);
        subProject.addTask(task);

        taskRepositoryInterface.createTask(subProject);
    }

    public Task readTask(int taskID) throws TaskException {
        return taskRepositoryInterface.readTask(taskID);
    }

    public void updateTask(String taskTime, String taskName, int taskID) throws TaskException, ValidateException {
        String newTaskName = validateTaskName(taskName);
        int newTaskTime = validateTaskTime(taskTime);

        Task task = new Task(newTaskTime, newTaskName);
        task.setTaskID(taskID);
        taskRepositoryInterface.updateTask(task);
    }

    public void deleteTask(int taskID) throws TaskException {
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
            throw new ValidateException("Task time cannot be empty and has to be a number in hours.");
        }
    }
}