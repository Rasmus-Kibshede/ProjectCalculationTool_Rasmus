package projectCalculationTool.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@Controller
public class ProjectController {

    private final ProjectService PROJECT_SERVICE = new ProjectService(new ProjectRepository());


    @GetMapping("/overview")
    public String projectPage(WebRequest webRequest, Model model) {

        int projectID = Integer.parseInt((Objects.requireNonNull(webRequest.getParameter("id"))));

        Project project = PROJECT_SERVICE.readProject(projectID);

//Logik skal ikke ligge her skal ligge i repository
        if (project != null) {
            model.addAttribute("project", project);
            return "/overview";
        }

        return "redirect:/";
    }

    @PostMapping("/addproject")
    public String createProject(WebRequest webRequest) {

        String projectName = webRequest.getParameter("name");

        Project project = new Project();
        project.setName(projectName);
        PROJECT_SERVICE.createProject(project);

        return "redirect:/overview";
    }

}
