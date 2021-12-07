package projectCalculationTool.task;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;
import projectCalculationTool.util.exception.ValidateException;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private final TaskService taskService = new TaskService(null);

    @Test
    void validateTaskTime() throws ValidateException {
        String tasktime = "2";

        int actual = taskService.validateTaskTime(tasktime);

        assertEquals(2, actual);
    }

    @Test
    void invalidInput()  {
        String tasktime = "test";

        Throwable exception = assertThrows(ValidateException.class, () -> taskService.validateTaskTime(tasktime));

        assertEquals("Task time has to be a number in hours.", exception.getMessage());
    }
}