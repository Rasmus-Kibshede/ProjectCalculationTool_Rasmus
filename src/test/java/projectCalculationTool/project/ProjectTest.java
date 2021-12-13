package projectCalculationTool.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.task.Task;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
  private Project project;

  @BeforeEach
  public void setup() {

    //Act
    project = new Project();
    project.setName("JUnit");

    ArrayList<Task> tasks = new ArrayList<>();
    tasks.add(new Task(4, "JUnit_1"));
    tasks.add(new Task(4, "JUnit_2"));
    tasks.add(new Task(1, "JUnit_3"));


    SubProject subProject = new SubProject("Sub_JUnit");

    subProject.setTasks(tasks);
    subProject.calculateDaysTotal();

    project.addSubproject(subProject);
    project.calculateWorkdaysDaysTotal();
  }

  @Test
  void calculateWorkdaysDaysTotalSuccessfully() {
    int workdays = 2;

    assertEquals(workdays, project.getProjectDaysTotal());
  }

  @Test
  public void calculateWorkdaysDaysTotalWrong(){
    int workdays = 1;

    assertNotEquals(workdays, project.getProjectDaysTotal());
  }
}