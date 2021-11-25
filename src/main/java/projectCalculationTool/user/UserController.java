package projectCalculationTool.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {
    UserService userService = new UserService(new UserRepository());

    @PostMapping("/login")
    public String login(WebRequest webRequest) {
        String mail = webRequest.getParameter("mail");
        String password = webRequest.getParameter("password");
        User user = userService.readUser(mail,password);

        //Set session with user obj

        return "/profile";
    }
}