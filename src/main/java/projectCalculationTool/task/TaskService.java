package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;

public class TaskService {
    private TaskRepositoryInterface taskRepositoryInterface;

    public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
        this.taskRepositoryInterface = taskRepositoryInterface;
    }

    public void createTask(String taskName, String taskTime, SubProject subProject) throws ProjectException {
        Task task = new Task(validateTaskTime(taskTime), validateTaskName(taskName));
        subProject.addTask(task);

        taskRepositoryInterface.createTask(subProject);
    }

    public Task readTask(int taskID) throws ProjectException {
        return taskRepositoryInterface.readTask(taskID);
    }

    public Task updateTask(String taskTime, String taskName) throws ProjectException{
        Task task = new Task(validateTaskTime(taskTime), validateTaskName(taskName));
        taskRepositoryInterface.updateTask(task);
        return task;
    }

    public void deleteTask(int taskID) throws ProjectException {
        taskRepositoryInterface.deleteTask(taskID);
    }

    //ER DET DEN RIGTIGE EXCEPTION??
    public String validateTaskName(String taskName)throws ProjectException{
        if (taskName != null && !taskName.isEmpty() && taskName.length() <= 45) {
            return taskName;
        } else {
            throw new ProjectException("Task name can't be null or longer then 45 characters.");
        }
    }

    //ER DET DEN RIGTIGE EXCEPTION??
    public int validateTaskTime(String taskTime) throws ProjectException{
        int taskTimeNew;

        if (taskTime != null && !taskTime.isEmpty()) {
            taskTimeNew = Integer.parseInt(taskTime);
            return taskTimeNew;
        } else {
            throw new ProjectException("Task time has to be a number."); //Tager ikke højde for komma/punktum
        }
    }
}
