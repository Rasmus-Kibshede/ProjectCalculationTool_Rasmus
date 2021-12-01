package projectCalculationTool.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCalculationTool.employee.Employee;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

    ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        projectRepository = new ProjectRepository();
    }

    @Test
    public void createProjectWithExceptionToLong(){
        Project project = new Project();
        project.setName("TestProject-with to many characters to se if it throws an exception");
        Employee employee = new Employee();
        project.setEmployee(employee);

        Throwable exception = assertThrows(SQLException.class, () -> projectRepository.createProject(project));

        assertEquals("Project name can't be null or longer then 45 characters.", exception.getMessage());

        // KILDE: https://www.vogella.com/tutorials/JUnit/article.html#testing-for-exceptions
    }

    @Test
    public void createProjectWithExceptionToShort(){
        Project project = new Project();
        project.setName(null);
        Employee employee = new Employee();
        project.setEmployee(employee);

        Throwable exception = assertThrows(SQLException.class, () -> projectRepository.createProject(project));

        assertEquals("Project name can't be null or longer then 45 characters.", exception.getMessage());
    }

    @Test
    public void readProject() throws SQLException{
        Project project = projectRepository.readProject(1);
        //assertNotNull(project); HVORFOR LAVE DEN???
        assertEquals(1, project.getProjectID());

        // KILDE: https://github.com/Tine-m/2.semLoginSample/blob/testautomation/loginsample/src/test/java/login/repositories/UserRepositoryTest2.java
    }

    @Test
    public void readProjectWithException(){
        Throwable exception = assertThrows(SQLException.class, () -> projectRepository.readProject(500));

        assertEquals("Can´t read project from database", exception.getMessage());
    }

}