package projectCalculationTool.subproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.project.Project;

import java.sql.SQLException;

@Controller
public class SubProjectController {
    private SubProjectService SUB_PROJECT_SERVICE = new SubProjectService(new SubProjectRepository());

    @PostMapping("addSubProject")
    public String addSubProject(WebRequest webRequest) throws SQLException {

        String subProjectName = webRequest.getParameter("subprojectname");

        int projectID = Integer.parseInt(webRequest.getParameter("projectID"));

        SUB_PROJECT_SERVICE.createSubProject(subProjectName, projectID,
                (Project) webRequest.getAttribute("Project", WebRequest.SCOPE_SESSION));

        return "redirect:/project?id=" + projectID;
    }

    @ExceptionHandler(SQLException.class)
    public String handlerSQLException(Model model, Exception exception) {
        model.addAttribute("error", exception.getMessage());
        return "/project";
    }


}
