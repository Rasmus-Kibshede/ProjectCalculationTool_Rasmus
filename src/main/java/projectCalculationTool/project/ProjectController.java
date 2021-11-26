package projectCalculationTool.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import projectCalculationTool.user.User;
import projectCalculationTool.user.UserService;

@Controller
public class ProjectController {

    private final ProjectService PROJECT_SERVICE = new ProjectService(new ProjectRepository());
    //private final UserService USER_SERVICE = new UserService();

    /*   @GetMapping("/profile")
       public String projectPage(WebRequest webRequest, Model model) {

           //int projectID = Integer.parseInt(webRequest.getParameter("id"));
           //Get session with userID

         //  Project project = PROJECT_SERVICE.readProject(projectID);
           //User user = USER_SERVICE.readUser()
           //webRequest.setAttribute("user", user , webRequest.SCOPE_SESSION);
           Logik skal ikke ligge her skal ligge i repository
           //if (project != null) {
           //   model.addAttribute("project", project);
           //   return "profile";
           }

       // return "redirect:/";
       }
    */
    @PostMapping("/addproject")
    public String createProject(WebRequest webRequest) {

        String projectName = webRequest.getParameter("name");

        Project project = new Project();
        project.setName(projectName);
        PROJECT_SERVICE.createProject(project);

        return "redirect:/profile";
    }
}