package projectCalculationTool.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCalculationTool.employee.Employee;

import java.rmi.UnexpectedException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

    ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        projectRepository = new ProjectRepository();
    }

    @Test
    public void createWithException(){
        Project project = new Project();
        project.setName("TestProject-with to many characters to se if it throws an exception");
        project.setProjectHoursTotal(11);
        Employee employee = new Employee();
        project.setEmployee(employee);

        Throwable exception = assertThrows(SQLException.class, () -> projectRepository.create(project));

        assertEquals("Project name can't be longer then 45 characters.", exception.getMessage());

        // KILDE: https://www.vogella.com/tutorials/JUnit/article.html#testing-for-exceptions
    }


  /*
  public void test_read(){

    Project newProject = projectRepository.read(1);

    assertNull(newProject.getProjectID());

  }
   */

}