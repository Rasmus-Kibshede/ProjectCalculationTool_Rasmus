package projectCalculationTool.subproject;

import org.junit.jupiter.api.Test;
import projectCalculationTool.project.Project;
import projectCalculationTool.project.ProjectRepository;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.SubProjectException;
import projectCalculationTool.util.exception.ValidateException;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectRepositoryTest {

    SubProjectRepository subProjectRepository;
    ProjectRepository projectRepository;
/*
    @Test
    void createSubProject() throws ProjectException {

        Project project =  projectRepository.readProject(1);
        SubProject subProject = null;
        subProject.setName("name");
        subProject.setSubProjectID(1);


        //Arrange

        Throwable exception = assertThrows(SubProjectException.class,() -> subProjectRepository.createSubProject(project));
        //Act

        //Assert
        assertEquals("Creating Task failed",exception.getMessage());
    }

 */

    @Test
    void readSubProject() {
    }

    @Test
    void readSubProjects() {
    }

    @Test
    void updateSubProject() {
    }

    @Test
    void deleteSubProject() {
    }
}