package projectCalculationTool.subproject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

public class SubProjectController {
    private SubProjectService SUB_PROJECT_SERVICE = new SubProjectService(new SubProjectRepository());

    @GetMapping("/addSubProject")
    public String addSubProject(WebRequest webRequest) throws SQLException {

        String subProjectName = webRequest.getParameter("subprojectname");

        SUB_PROJECT_SERVICE.createSubProject(subProjectName);

        return "redirect:/editProject";
    }

    @ExceptionHandler(SQLException.class)
    public String sqlHandler(Model model, Exception exception) {
        model.addAttribute("error", exception.getMessage());
        return "/editProject";
    }

}
