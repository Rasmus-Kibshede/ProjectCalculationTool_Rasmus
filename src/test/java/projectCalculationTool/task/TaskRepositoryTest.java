package projectCalculationTool.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import projectCalculationTool.subproject.SubProject;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new TaskRepository();
    }
/*
    @Test
    public void testCreateTask() throws SQLException {
        // Arrange
        SubProject subProject = new SubProject("Fødselsdagssnacks");
        ArrayList<Task> tasks = new ArrayList<>();
        Task bakeTask = new Task(4, "Bake cake");
        Task shopTask = new Task(1, "Shop for chips and dip");
        tasks.add(bakeTask);
        tasks.add(shopTask);
        subProject.setTasks(tasks);

        // Act
        taskRepository.createTask(subProject);

        // Assert
        assertTrue(bakeTask.getTaskID() != 0);
        assertTrue(shopTask.getTaskID() != 0);
    }
 */
/*
    @ParameterizedTest
    @CsvSource(value = {}, delimiter = ':')
    public void testValidCreate() {
        String actualName;
        int actualTime;
    }

    @Test
    public void read

 */

}