package projectCalculationTool.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.project.Project;
import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;

@Controller
public class TaskController {
    private TaskService TASK_SERVICE = new TaskService(new TaskRepository());

    @PostMapping("addTask")
    public String addTask(WebRequest webRequest) throws ProjectException {
        int subProjectID = Integer.parseInt(webRequest.getParameter("subprojectID"));

        Project project = (Project) webRequest.getAttribute("project", WebRequest.SCOPE_SESSION);

        SubProject subProject = project.findSubProject(subProjectID);

        String taskName = webRequest.getParameter("taskname");
        String taskTime = webRequest.getParameter("tasktime");

        TASK_SERVICE.createTask(taskName, taskTime, subProject);

        return "redirect:/project?id=" + project.getProjectID();
    }

    @GetMapping("/editTask")
    public String editTask(WebRequest webRequest, Model model) throws ProjectException {
        Project project = (Project) webRequest.getAttribute("project", WebRequest.SCOPE_SESSION);
        int taskID = Integer.parseInt(webRequest.getParameter("id"));

        Task task = TASK_SERVICE.readTask(taskID);

        model.addAttribute("task", task);
        model.addAttribute("project", project);
        return "editTask";
    }

    @PostMapping("updateTask")
    public String updateTask(WebRequest webRequest) throws ProjectException {
        int projectID = Integer.parseInt(webRequest.getParameter("projectID"));
        String taskName = webRequest.getParameter("taskName");
        String taskTime = webRequest.getParameter("taskTime");

        TASK_SERVICE.updateTask(taskTime, taskName);

        return "redirect:/project?id=" + projectID;
    }

    @GetMapping("deleteTask")
    public String deleteTask(WebRequest webRequest) throws ProjectException {
        int taskID = Integer.parseInt(webRequest.getParameter("id"));
        Project project = (Project) webRequest.getAttribute("project", WebRequest.SCOPE_SESSION);
        TASK_SERVICE.deleteTask(taskID);

        return "redirect:/project?id=" + project.getProjectID();
    }


    @ExceptionHandler(ProjectException.class)
    public String crateFailedHandler(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());

        return "/project";
    }
}