package projectCalculationTool.task;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.project.Project;
import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;

//PUHA NEJ NEJ NEJ FJERN
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class TaskController {
    private TaskService TASK_SERVICE = new TaskService(new TaskRepository());

    @PostMapping("addTask")
    public String addTask(WebRequest webRequest) throws SQLException, ProjectException {

        SubProject subProject = (SubProject) webRequest.getAttribute("subproject", WebRequest.SCOPE_SESSION);
        String taskName = webRequest.getParameter("taskname");

        int subprojectID = Integer.parseInt(webRequest.getParameter("subproject"));
        String taskTime = webRequest.getParameter("tasktime");

        int projectID = Integer.parseInt(webRequest.getParameter("projectID"));

        TASK_SERVICE.createTask(taskName, taskTime, subprojectID, subProject);

        return "redirect:/project?id=" + projectID;
    }

    @GetMapping("/task")
    public String editTask(WebRequest webRequest, Model model){

        int taskID = Integer.parseInt(webRequest.getParameter("taskID"));

        Task task = TASK_SERVICE.readTask(taskID);

        model.addAttribute("task", task);

        return "/task";
    }

    @PostMapping("/UpdateTask")
    public String updateTask(WebRequest webRequest) throws ProjectException{

        String taskName = webRequest.getParameter("taskname");
        String taskTime = webRequest.getParameter("tasktime");
        TASK_SERVICE.updateTask(taskTime, taskName);

        Project project = (Project) webRequest.getAttribute("project", WebRequest.SCOPE_SESSION);

        return "redirect:/project?=" + project.getProjectID();
    }


    @ExceptionHandler(ProjectException.class)
    public String crateFailedHandler(Model model, Exception exception) {
        model.addAttribute("Error", exception.getMessage());

        return "/project";
    }

}
