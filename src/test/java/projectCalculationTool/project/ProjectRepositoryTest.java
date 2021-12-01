package projectCalculationTool.project;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCalculationTool.employee.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

  private ProjectRepository projectRepository;
  private Project project;
  private Employee employee;

  @BeforeEach
  public void setUp() {
    projectRepository = new ProjectRepository();
    project = new Project();

    employee = new Employee();
    employee.setEmployeeID(1);
    employee.setEmail("test@yes.com");
    employee.setPassword("123");
  }


  //-----------------------READ tests-----------------------
  @Test
  public void readProject() throws SQLException {
    Project project = projectRepository.readProject(18);

    assertEquals(18, project.getProjectID());

    // KILDE: https://github.com/Tine-m/2.semLoginSample/blob/testautomation/loginsample/src/test/java/login/repositories/UserRepositoryTest2.java
  }

  @Test
  public void readProjectWithException() {
    assertThrows(SQLException.class, () -> projectRepository.readProject(-1));
  }

  @Test
  public void readAllProjectNotNull() throws SQLException{

    ArrayList<Project> projects = projectRepository.readProjects(employee);

    assertNotNull(projects);
  }

  //-----------------------CREATE tests-----------------------
  @Test
  public void createProjectWithExceptionToLong() {
    project.setName("TestProject-with to many characters to se if it throws an exception");

    Throwable exception = assertThrows(SQLException.class, () -> projectRepository.createProject(project));

    assertEquals("Project name can't be null or longer then 45 characters.", exception.getMessage());

    // KILDE: https://www.vogella.com/tutorials/JUnit/article.html#testing-for-exceptions
  }

  @Test
  public void createProjectWithExceptionToShort() {
    project.setName(null);

    Throwable exception = assertThrows(SQLException.class, () -> projectRepository.createProject(project));

    assertEquals("Project name can't be null or longer then 45 characters.", exception.getMessage());
  }

  @Test
  public void createProject() throws SQLException{

    Project project1 = new Project();
    project1.setName("JUnitTest");
    project1.setEmployee(employee);

   projectRepository.createProject(project1);

   assertTrue(project1.getProjectID() != 0);

   projectRepository.deleteProject(project1.getProjectID());

  }

}