package projectCalculationTool.subproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.project.Project;
import projectCalculationTool.project.ProjectRepository;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.SubProjectException;
import projectCalculationTool.util.exception.ValidateException;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectRepositoryTest {

    private SubProjectRepository subProjectRepository = new SubProjectRepository();
    private ProjectRepository projectRepository = new ProjectRepository();

    private Employee employee;
    private Project project;
/*
    @Test
    void createSubProject() throws ProjectException, SubProjectException {
        Project project = new Project();
        project.setName("projectName");
        project.setEmployee(employee);

        project = projectRepository.readProject(1);
        SubProject subProject = null;
        subProject.setName("name");
        subProject.setSubProjectID(1);

        projectRepository.createProject(project);

        Throwable exception = assertThrows(SubProjectException.class, () -> subProjectRepository.createSubProject(project));


        assertEquals("Failed creating subproject", exception.getMessage());


    }

 */

    @BeforeEach
    public void setUp() {
        project = new Project();

        employee = new Employee();
        employee.setEmployeeID(1);
        employee.setEmail("test@yes.com");
        employee.setPassword("123");
    }
}
/*
    @Test
    void readSubProject() throws SubProjectException {
        SubProject subProject = subProjectRepository.readSubProject(50);

        assertEquals(18, subProject.getSubProjectID());

    }

    @Test
    void readSubProjects() {
    }

    @Test
    void updateSubProject() {
    }

    @Test
    void deleteSubProject() {
    }
}
 */