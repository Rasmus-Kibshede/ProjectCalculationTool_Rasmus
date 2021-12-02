package projectCalculationTool.subproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.util.exception.ProjectException;

@Controller
public class SubProjectController {
    private SubProjectService SUB_PROJECT_SERVICE = new SubProjectService(new SubProjectRepository());

    @PostMapping("addSubProject")
    public String addSubProject(WebRequest webRequest) throws ProjectException {

        String subProjectName = webRequest.getParameter("subprojectname");
        /*String taskname1 = webRequest.getParameter("taskname1");
        int tasktime1= Integer.parseInt(webRequest.getParameter("tasktime1"));
        String taskname2 = webRequest.getParameter("taskname2");
        int tasktime2= Integer.parseInt(webRequest.getParameter("tasktime1"));
        String taskname3 = webRequest.getParameter("taskname3");
        int tasktime3= Integer.parseInt(webRequest.getParameter("tasktime1"));*/

        //tag imod et project object
        //project id er 0
        int projectID = Integer.parseInt(webRequest.getParameter("projectID"));

        SUB_PROJECT_SERVICE.createSubProject(subProjectName, projectID);

        return "redirect:/project?id=" + projectID;
    }

    @ExceptionHandler(ProjectException.class)
    public String handlerSQLException(Model model, Exception exception) {
        model.addAttribute("error", exception.getMessage());
        return "/project";
    }
}