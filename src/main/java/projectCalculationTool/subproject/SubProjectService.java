package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;

import java.sql.SQLException;

public class SubProjectService {
    private SubProjectRepositoryInterface subProjectRepositoryInterface;

    public SubProjectService(SubProjectRepositoryInterface subProjectRepositoryInterface) {
        this.subProjectRepositoryInterface = subProjectRepositoryInterface;
    }

    public void createSubProject(String subProjectName, int projectID) throws SQLException {
        Project project = new Project();
        project.setProjectID(projectID);
        project.addSubproject(new SubProject(subProjectName));

        subProjectRepositoryInterface.create(project);
    }

    //Edit method name in class diagram
    public SubProject readSubProject(int subProjectID) {
        //Return a SubProject
        return null;
    }

}
