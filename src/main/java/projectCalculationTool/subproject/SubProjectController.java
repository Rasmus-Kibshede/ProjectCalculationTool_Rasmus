package projectCalculationTool.subproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/projects/{projectID}/subprojekt/{subprojectID}")
    public String subproject(@PathVariable int subprojectID, @PathVariable int projectID, Model model,
                             WebRequest webRequest) throws SubProjectException {

        if(webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION) == null){
            return "redirect:index";
        }

        SubProject subProject = SUB_PROJECT_SERVICE.readSubProject(subprojectID);

        model.addAttribute("subproject", subProject);
        model.addAttribute("projectID", projectID);
        model.addAttribute("message", webRequest.getParameter("message"));

        return "subproject";
    }

    @PostMapping("projects/{projectID}/subprojekt/{subprojectID}")
    public String updatSubproject(
            @PathVariable int subprojectID,
            @PathVariable int projectID,
            WebRequest webRequest
    ) throws ValidateException, SubProjectException {

        String name = webRequest.getParameter("name");
        SUB_PROJECT_SERVICE.updateSubProject(subprojectID, name);

        return "redirect:/project?id=" + projectID;
    }

    @PostMapping("projects/{projectID}/subprojekt/{subprojectID}/slet")
    public String deleteSubproject(@PathVariable int subprojectID, @PathVariable int projectID) throws SubProjectException {
        SUB_PROJECT_SERVICE.deleteSubProject(subprojectID);

        return "redirect:/project?id=" + projectID;
    }

    //Referance https://stackoverflow.com/questions/804581/spring-mvc-controller-redirect-to-previous-page
    @ExceptionHandler({SubProjectException.class, ValidateException.class})
    public String handlerSQLException(Model model, Exception exception, WebRequest webRequest) {
        String referer = webRequest.getHeader("Referer");
        model.addAttribute("message", exception.getMessage());
        return "redirect:" + referer;
    }
}