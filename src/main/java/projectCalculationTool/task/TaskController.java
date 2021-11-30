package projectCalculationTool.task;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.subproject.SubProject;

import java.sql.SQLException;

public class TaskController {
  private TaskService TASK_SERVICE = new TaskService(new TaskRepository());

  @GetMapping("/addTask")
  public String addTask(WebRequest webRequest) throws SQLException {

    String taskName = webRequest.getParameter("taskname");
    double taskTime = Double.parseDouble(webRequest.getParameter("tasktime"));
    SubProject subProject = (SubProject) webRequest.getAttribute("subproject", webRequest.SCOPE_SESSION);

    TASK_SERVICE.createTask(taskName, taskTime, subProject);

    return "/addTask"; //HTML SIDEN MAGLER
  }

  @ExceptionHandler(SQLException.class)
  public String crateFailedHandler(Model model, Exception exception){
    model.addAttribute("Error", exception.getMessage());

    return "/addTask"; //HTML SIDEN MAGLER
  }
}
