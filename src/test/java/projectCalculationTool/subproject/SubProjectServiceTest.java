package projectCalculationTool.subproject;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;
import projectCalculationTool.project.Project;
import projectCalculationTool.util.exception.SubProjectException;
import projectCalculationTool.util.exception.ValidateException;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectServiceTest {
    SubProjectService subProjectService = new SubProjectService(null);

    @Test
    void valdiateNullName() {
        //Arrange
        String name = null;

        Throwable exception = assertThrows(ValidateException.class, () -> subProjectService.validateSubProjectName(name));

        //Assert
        assertEquals("Task name can't be null or longer than 45 characters.", exception.getMessage());

    }

    @Test
    void valdiateLongNameName() {
        //Arrange
        String name = "thisnameiswaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaymorethan45characters";

        Throwable exception = assertThrows(ValidateException.class, () -> subProjectService.validateSubProjectName(name));

        //Assert
        assertEquals("Task name can't be null or longer than 45 characters.", exception.getMessage());

    }
}