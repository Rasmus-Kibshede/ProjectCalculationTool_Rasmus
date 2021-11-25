package projectCalculationTool.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {
    UserService userService = new UserService(new UserRepository());

    @PostMapping("/login")
    public String login(WebRequest webRequest) {
        webRequest.setAttribute("user", "hej", WebRequest.SCOPE_SESSION);
        return "profile";
    }
}
