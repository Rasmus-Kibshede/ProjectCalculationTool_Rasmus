package projectCalculationTool.subproject;

import org.junit.jupiter.api.Test;
import projectCalculationTool.util.exception.ValidateException;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectServiceTest {
    SubProjectService subProjectService = new SubProjectService(null);

    @Test
    void valdiateNullName() {
        //Arrange
        String name = null;

        //Assert
        assertThrows(ValidateException.class, () -> subProjectService.validateSubProjectName(name));

    }

    @Test
    void valdiateLongNameName() {
        //Arrange
        String name = "thisnameiswaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaymorethan45characters";

        //Assert
        assertThrows(ValidateException.class, () -> subProjectService.validateSubProjectName(name));

    }

    @Test
    void validateSuccessfully() {
        //Arrange
        String name = "Test";

        //Assert
        assertDoesNotThrow(() -> subProjectService.validateSubProjectName(name));
    }
}