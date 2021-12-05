package projectCalculationTool.subproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.project.Project;
import projectCalculationTool.util.exception.SubProjectException;
import projectCalculationTool.util.exception.ValidateException;

@Controller
public class SubProjectController {
    private SubProjectService SUB_PROJECT_SERVICE = new SubProjectService(new SubProjectRepository());

    @PostMapping("addSubProject")
    public String addSubProject(WebRequest webRequest) throws SubProjectException, ValidateException {

        String subProjectName = webRequest.getParameter("subprojectname");

        int projectID = Integer.parseInt(webRequest.getParameter("projectID"));

        SUB_PROJECT_SERVICE.createSubProject(subProjectName, projectID,
                (Project) webRequest.getAttribute("Project", WebRequest.SCOPE_SESSION));

        return "redirect:/project?id=" + projectID;
    }

    @ExceptionHandler({SubProjectException.class, ValidateException.class})
    public String handlerSQLException(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());
        return "/project";
    }
}