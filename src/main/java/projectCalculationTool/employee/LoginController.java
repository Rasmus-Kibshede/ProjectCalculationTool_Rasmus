package projectCalculationTool.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.util.exception.LoginException;
import projectCalculationTool.util.exception.ValidateException;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
  private EmployeeService employeeService = new EmployeeService(new EmployeeRepository());

  @GetMapping("/")
  public String index(Model model, WebRequest webRequest) {
    model.addAttribute("message", webRequest.getParameter("message"));
    return "index";
  }

  @PostMapping("/login")
  public String login(WebRequest webRequest) throws LoginException, ValidateException {
    String email = webRequest.getParameter("email");
    String password = webRequest.getParameter("password");
    Employee employee = employeeService.readEmployee(email, password);

    if (employee != null) {
      webRequest.setAttribute("employee", employee, WebRequest.SCOPE_SESSION);
      return "redirect:/profile";
    }
    //Set session with user obj
    return "redirect:/";
  }

  @GetMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

  //Referance https://stackoverflow.com/questions/804581/spring-mvc-controller-redirect-to-previous-page
  @ExceptionHandler({LoginException.class, ValidateException.class})
  public String handleLoginException(Model model, Exception exception, WebRequest webRequest) {
    String referer = webRequest.getHeader("Referer");
    model.addAttribute("message", exception.getMessage());
    return "redirect:" + referer;
  }
}