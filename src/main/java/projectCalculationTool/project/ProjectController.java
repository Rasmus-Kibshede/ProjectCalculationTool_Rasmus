package projectCalculationTool.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.employee.EmployeeRepository;
import projectCalculationTool.employee.EmployeeService;

@Controller
public class ProjectController {

    private final ProjectService PROJECT_SERVICE = new ProjectService(new ProjectRepository());
    private final EmployeeService EMPLOYEE_SERVICE = new EmployeeService(new EmployeeRepository());

    @GetMapping("/profile")
    public String projectPage(WebRequest webRequest, Model model) {

        Employee employee = (Employee) webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION);

        //int projectid = Integer.parseInt(webRequest.getParameter("id"));
        //Get session with userID

        //Logik skal ikke ligge her skal ligge i repository
        if (employee != null) {
            return "profile";
        }
        return "profile";
    }

    @PostMapping("/addproject")
    public String createProject(WebRequest webRequest) {

        String projectName = webRequest.getParameter("name");

        Project project = new Project();
        project.setName(projectName);
        PROJECT_SERVICE.createProject(project);

        return "redirect:/profile";
    }
}