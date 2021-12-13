package projectCalculationTool.subproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCalculationTool.task.Task;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectTest {

  private SubProject subProject;

  @BeforeEach
  public void setup() {

    //Act
    subProject = new SubProject("JUnit");

    ArrayList<Task> tasks = new ArrayList<>();
    tasks.add(new Task(4, "JUnit_1"));
    tasks.add(new Task(4, "JUnit_2"));
    tasks.add(new Task(1, "JUnit_3"));

    subProject.setTasks(tasks);
    subProject.calculateDaysTotal();

  }

  @Test
  public void correctHoursToWorkDaysSuccessfully() {

    //Arrange
    int workDays = 2;

    //Assert
    assertEquals(workDays, subProject.getWorkdays());
  }

  @Test
  public void calculateWorkdaysSuccessfully(){

    //Arrange
    subProject.calculateWorkdays(9);

    //Assert
    assertEquals(2, subProject.getWorkdays());
  }

  //--------------------- Tests with Wrong Inputs ---------------------

  @Test
  public void correctHoursToWorkDaysWithWrongInput() {

    //Arrange
    int workDays = 1;

    //Assert
    assertNotEquals(workDays, subProject.getWorkdays());
  }

  @Test
  public void calculateWorkdaysWithWrongInput(){

    //Arrange
    subProject.calculateWorkdays(1);

    //Assert
    assertNotEquals(2, subProject.getWorkdays());
  }


}