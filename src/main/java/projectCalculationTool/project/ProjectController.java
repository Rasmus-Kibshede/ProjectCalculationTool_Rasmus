package projectCalculationTool.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.employee.EmployeeRepository;
import projectCalculationTool.employee.EmployeeService;

import java.util.ArrayList;

@Controller
public class ProjectController {

    private final ProjectService PROJECT_SERVICE = new ProjectService(new ProjectRepository());
    //private final EmployeeService EMPLOYEE_SERVICE = new EmployeeService(new EmployeeRepository());

    @GetMapping("/profile")
    public String profile(WebRequest webRequest, Model model) {

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
    public String createProject(WebRequest webRequest) {
        String projectName = webRequest.getParameter("projectname");

        PROJECT_SERVICE.createProject(projectName,
                (Employee) webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION));

        return "redirect:/profile";
    }
}