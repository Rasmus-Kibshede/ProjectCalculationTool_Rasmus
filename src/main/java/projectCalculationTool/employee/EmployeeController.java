package projectCalculationTool.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.util.exception.LoginException;

@Controller
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService(new EmployeeRepository());

    @PostMapping("/login")
    public String login(WebRequest webRequest) throws LoginException {
        String email = webRequest.getParameter("email");
        String password = webRequest.getParameter("password");
        Employee employee = employeeService.readEmployee(email, password);
//er det sikkert at sende password op i webrequest
        if (employee != null) {
            webRequest.setAttribute("employee", employee, WebRequest.SCOPE_SESSION);
            return "redirect:/profile";
        }
        //Set session with user obj
        return "redirect:/";
    }

    @ExceptionHandler(LoginException.class)
    public String handleLoginException(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());
        return "index";
    }
}