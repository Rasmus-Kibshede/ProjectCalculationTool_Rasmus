package projectCalculationTool.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.employee.EmployeeRepository;
import projectCalculationTool.employee.EmployeeService;
import projectCalculationTool.util.exception.LoginException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

@Controller
public class ProjectController {

    private final ProjectService PROJECT_SERVICE = new ProjectService(new ProjectRepository());

    @GetMapping("/project")
    public String project(WebRequest webRequest, Model model) throws SQLException {
        int projectID = Integer.parseInt(webRequest.getParameter("id"));
        Employee employee = (Employee) webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION);

        // send hele projektet videre --> ikke hent id i næste controller (evt i webrequest eller session?)
        Project project = PROJECT_SERVICE.readProject(projectID);

        project.setEmployee(employee);

        model.addAttribute("project", project);

        return "project";
    }

    @GetMapping("/profile")
    public String profile(WebRequest webRequest, Model model) throws SQLException {

        Employee employee = (Employee) webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION);

        if (employee != null) {
            ArrayList<Project> projects = PROJECT_SERVICE.readProjects(employee);
            model.addAttribute("employee", employee);

            model.addAttribute("project", projects);

            return "profile";
        }
        return "redirect:/";
    }

    @PostMapping("/addproject")
    public String createProject(WebRequest webRequest) throws MissingFormatArgumentException, SQLException {
        String projectName = PROJECT_SERVICE.validateProjectName(webRequest.getParameter("projectname"));

        PROJECT_SERVICE.createProject(projectName,
                (Employee) webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION));

        return "redirect:/profile";
    }

    @ExceptionHandler({SQLException.class, MissingFormatArgumentException.class})
    public String handleSQLException(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());

        return "profile";
    }
}