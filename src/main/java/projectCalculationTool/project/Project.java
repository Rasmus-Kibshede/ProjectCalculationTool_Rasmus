package projectCalculationTool.project;

public class Project {
  private String name;
  private double projectHoursTotal;
  private int projectID;

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

}
