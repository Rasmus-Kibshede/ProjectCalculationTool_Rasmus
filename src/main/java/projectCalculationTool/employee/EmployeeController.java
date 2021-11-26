package projectCalculationTool.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService(new EmployeeRepository());

    @PostMapping("/login")
    public String login(WebRequest webRequest) {
        String mail = webRequest.getParameter("mail");
        String password = webRequest.getParameter("password");
        Employee employee = employeeService.readUser(mail, password);

        if (employee != null) {
            webRequest.setAttribute("employee", employee, WebRequest.SCOPE_SESSION);
            return "redirect:/profile";
        }
        //Set session with user obj
        return "redirect:/";

    }
}