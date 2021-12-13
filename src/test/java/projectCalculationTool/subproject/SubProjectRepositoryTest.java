package projectCalculationTool.subproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCalculationTool.employee.Employee;
import projectCalculationTool.project.Project;
import projectCalculationTool.project.ProjectRepository;
import projectCalculationTool.testData.TestData;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.SubProjectException;
import projectCalculationTool.util.exception.ValidateException;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectRepositoryTest {

  private SubProjectRepository subProjectRepository;

  @BeforeEach
  public void setUp() {

    //Arrange
    TestData testData = new TestData();
    testData.setUp();

    //Arrange
    subProjectRepository = new SubProjectRepository();
  }

  @Test
  void readSubProject() throws SubProjectException {
    //Act
    SubProject subProject = subProjectRepository.readSubProject(1);

    //Assert
    assertEquals(1, subProject.getSubProjectID());
    assertEquals("testData_SubProject_1", subProject.getName());
  }

}
