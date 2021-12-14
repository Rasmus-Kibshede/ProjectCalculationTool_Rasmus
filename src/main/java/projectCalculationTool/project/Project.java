package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.subproject.SubProject;

import java.util.ArrayList;

public class Project {
    private String name;
    private Employee employee;
    private int projectDaysTotal;
    private int projectID;
    private ArrayList<SubProject> subProjects = new ArrayList<>();

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

    public int getProjectDaysTotal() {
        return projectDaysTotal;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void addSubproject(SubProject subProject) {
        subProjects.add(subProject);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void calculateWorkdaysDaysTotal() {
        int workdaysTotal = 0;

        for (int i = 0; i < this.subProjects.size(); i++) {
            this.subProjects.get(i).calculateDaysTotal();
            workdaysTotal += this.subProjects.get(i).getWorkdays();
        }
        this.projectDaysTotal = workdaysTotal;
    }

    public SubProject findSubProject(int subProjectID) {
        for (SubProject subproject: this.subProjects) {
            if (subproject.getSubProjectID() == subProjectID) {
                return subproject;
            }
        }
        // Returner exception - not found
        return null;
    }
}