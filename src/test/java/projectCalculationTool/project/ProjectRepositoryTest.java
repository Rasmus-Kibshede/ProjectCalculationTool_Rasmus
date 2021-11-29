package projectCalculationTool.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

    ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        projectRepository = new ProjectRepository();
    }

    @Test
    public void test_create() {

        //Arrange
        Project project = new Project();
        project.setName("TestProject");
        project.setProjectHoursTotal(11);

        //Act
        projectRepository.create(project);

        //Assert
        //assertTrue(newProject.getProjectID() != 0);

    }

  /*
  public void test_read(){

    Project newProject = projectRepository.read(1);

    assertNull(newProject.getProjectID());

  }
   */

}