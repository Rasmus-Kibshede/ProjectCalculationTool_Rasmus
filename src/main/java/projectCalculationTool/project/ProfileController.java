package projectCalculationTool.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.util.exception.ProjectException;

import java.util.ArrayList;

@Controller
public class ProfileController {

  private final ProjectService PROJECT_SERVICE = new ProjectService(new ProjectRepository());


  @GetMapping("/profile")
  // skal den throwe??
  public String profile(WebRequest webRequest, Model model) throws ProjectException {
    Employee employee = (Employee) webRequest.getAttribute("employee", WebRequest.SCOPE_SESSION);
    if (employee == null) {
      return "redirect:/";
    }

    ArrayList<Project> projects = PROJECT_SERVICE.readProjects(employee);

    model.addAttribute("employee", employee);
    model.addAttribute("projects", projects);
    model.addAttribute("message", webRequest.getParameter("message"));

    return "profile";

  }

}
