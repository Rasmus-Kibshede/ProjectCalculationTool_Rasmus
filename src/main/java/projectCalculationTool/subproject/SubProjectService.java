package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.task.Task;

import java.sql.SQLException;

public class SubProjectService {
    private SubProjectRepositoryInterface subProjectRepositoryInterface;

    public SubProjectService(SubProjectRepositoryInterface subProjectRepositoryInterface) {
        this.subProjectRepositoryInterface = subProjectRepositoryInterface;
    }

    public void createSubProject(
            String subProjectName,
            int projectID,
            String taskName1,
            int taskTime1,
            String taskName2,
            int taskTime2,
            String taskName3,
            int taskTime3
    ) throws SQLException {

        Project project = new Project();
        project.setProjectID(projectID);
        SubProject subProject = new SubProject(subProjectName);
        subProject.addTask(new Task(taskTime1, taskName1));
        subProject.addTask(new Task(taskTime2, taskName2));
        subProject.addTask(new Task(taskTime3, taskName3));
        project.addSubproject(subProject);

        subProjectRepositoryInterface.create(project);
    }

    //Edit method name in class diagram
    public SubProject readSubProject(int subProjectID) {
        //Return a SubProject
        return null;
    }

}
