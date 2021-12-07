package projectCalculationTool.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.project.Project;
import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.TaskException;
import projectCalculationTool.util.exception.ValidateException;

@Controller
public class TaskController {
    private TaskService TASK_SERVICE = new TaskService(new TaskRepository());

    @PostMapping("addTask")
    public String addTask(WebRequest webRequest) throws ValidateException, TaskException {
        int subProjectID = Integer.parseInt(webRequest.getParameter("subprojectID"));

        Project project = (Project) webRequest.getAttribute("project", WebRequest.SCOPE_SESSION);

        SubProject subProject = project.findSubProject(subProjectID);

        String taskName = webRequest.getParameter("taskName");
        String taskTime = webRequest.getParameter("taskTime");

        TASK_SERVICE.createTask(taskName, taskTime, subProject);

        return "redirect:/project?id=" + project.getProjectID();
    }

    @GetMapping("/editTask")
    public String editTask(WebRequest webRequest, Model model) throws TaskException {
        if(webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION) == null){
            return "redirect:index";
        }

        Project project = (Project) webRequest.getAttribute("project", WebRequest.SCOPE_SESSION);
        int taskID = Integer.parseInt(webRequest.getParameter("id"));

        Task task = TASK_SERVICE.readTask(taskID);

        model.addAttribute("message", webRequest.getParameter("message"));
        model.addAttribute("task", task);
        model.addAttribute("project", project);
        return "editTask";
    }

    @PostMapping("updateTask")
    public String updateTask(WebRequest webRequest) throws TaskException, ValidateException {
        int projectID = Integer.parseInt(webRequest.getParameter("projectID"));
        int taskID = Integer.parseInt(webRequest.getParameter("id"));
        String taskName = webRequest.getParameter("taskName");
        String taskTime = webRequest.getParameter("taskTime");

        TASK_SERVICE.updateTask(taskTime, taskName, taskID);

        return "redirect:/project?id=" + projectID;
    }

    @GetMapping("deleteTask")
    public String deleteTask(WebRequest webRequest) throws TaskException {
        int taskID = Integer.parseInt(webRequest.getParameter("id"));
        Project project = (Project) webRequest.getAttribute("project", WebRequest.SCOPE_SESSION);
        //int projectID = Integer.parseInt(webRequest.getParameter("projectID"));
        TASK_SERVICE.deleteTask(taskID);

        return "redirect:/project?id=" + project.getProjectID();
    }

    //Referance https://stackoverflow.com/questions/804581/spring-mvc-controller-redirect-to-previous-page
    @ExceptionHandler({TaskException.class, ValidateException.class})
    public String crateFailedHandler(Model model, Exception exception, WebRequest webRequest) {
        String referer = webRequest.getHeader("Referer");
        model.addAttribute("message", exception.getMessage());

        return "redirect:" + referer;
    }
}