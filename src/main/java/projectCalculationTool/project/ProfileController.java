package projectCalculationTool.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.ValidateException;

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

    ArrayList<Project> projects = PROJECT_SERVICE.readAllProjects(employee);

    model.addAttribute("employee", employee);
    model.addAttribute("projects", projects);
    model.addAttribute("message", webRequest.getParameter("message"));

    return "profile";

  }

  //Referance https://stackoverflow.com/questions/804581/spring-mvc-controller-redirect-to-previous-page
  @ExceptionHandler({ProjectException.class, ValidateException.class})
  public String handleSQLException(Model model, Exception exception, WebRequest webRequest) {
    String referer = webRequest.getHeader("Referer");

    model.addAttribute("message", exception.getMessage());

    return "redirect:" + referer;
  }
}
