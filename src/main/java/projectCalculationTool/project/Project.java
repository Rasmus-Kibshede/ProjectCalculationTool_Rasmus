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

    public void setProjectDaysTotal(int projectDaysTotal) {
        this.projectDaysTotal = projectDaysTotal;
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
}
