package projectCalculationTool.subproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@Controller
public class SubProjectController {
    private SubProjectService SUB_PROJECT_SERVICE = new SubProjectService(new SubProjectRepository());

    @PostMapping("addSubProject")
    public String addSubProject(WebRequest webRequest) throws SQLException {

        String subProjectName = webRequest.getParameter("subprojectname");
        String taskname1 = webRequest.getParameter("taskname1");
        int tasktime1= Integer.parseInt(webRequest.getParameter("tasktime1"));
        String taskname2 = webRequest.getParameter("taskname2");
        int tasktime2= Integer.parseInt(webRequest.getParameter("tasktime1"));
        String taskname3 = webRequest.getParameter("taskname3");
        int tasktime3= Integer.parseInt(webRequest.getParameter("tasktime1"));

        int projectID = Integer.parseInt(webRequest.getParameter("projectID"));

        SUB_PROJECT_SERVICE.createSubProject(subProjectName, projectID, taskname1, tasktime1, taskname2, tasktime2, taskname3, tasktime3);

        return "redirect:/project?id=" + projectID;
    }

    /*@ExceptionHandler(SQLException.class)
    public String sqlHandler(Model model, Exception exception) {
        model.addAttribute("error", exception.getMessage());
        return "redirect:/project";
    }

     */

}
