package projectCalculationTool.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

  private ProjectRepository projectRepository;

  @Test
  public void test_create(){
    Project project = new Project();
    project.setName("TestProject");


    //Project newProject = projectRepository.create(project);

    assertEquals(project.getName(), "TestProject"); // Find ud af returtype reporsitory wise

  }

  public void test_read(){

  }

}