package projectCalculationTool.project;

import projectCalculationTool.subproject.SubProject;

import java.util.ArrayList;

public class Project {
  private String name;
  private double projectHoursTotal;
  private int projectID;
  private ArrayList<SubProject> subProjects;

  public ArrayList<SubProject> getSubProjects() {
    return subProjects;
  }

  public void setSubProjects(ArrayList<SubProject> subProjects) {
    this.subProjects = subProjects;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getProjectHoursTotal() {
    return projectHoursTotal;
  }

  public void setProjectHoursTotal(double projectHoursTotal) {
    this.projectHoursTotal = projectHoursTotal;
  }

  public int getProjectID() {
    return projectID;
  }

  public void setProjectID(int projectID) {
    this.projectID = projectID;
  }

  public void addSubproject(SubProject subProject){
    subProjects.add(subProject);
  }

}
