package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.subproject.SubProjectRepository;
import projectCalculationTool.util.DBManager;

import java.sql.*;
import java.util.ArrayList;

public class ProjectRepository implements ProjectRepositoryInterface {

    private static Connection connection = DBManager.getConnection();

    public void create(Project project)throws SQLException{
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CALL create_project(?,?)");
            if(project.getName() != null && project.getName().length() <= 45) {
                preparedStatement.setString(1, project.getName());
            } else {
                throw new SQLException("Project name can't be null or longer then 45 characters.");
            }
            preparedStatement.setInt(2, project.getEmployee().getEmployeeID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Project readProject(int projectID) throws SQLException {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CALL read_project(?)");

            preparedStatement.setInt(1, projectID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Project project = new Project();

                //Needs more information, like employee via joins
                project.setProjectID(resultSet.getInt("project_id"));
                project.setName(resultSet.getString("project_name"));

                return project;
            } else {
                throw new SQLException("Can´t read project from database");
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public ArrayList<Project> readProjects(Employee employee) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CALL read_projects(?)");
            preparedStatement.setInt(1, employee.getEmployeeID());
            ResultSet resultSet = preparedStatement.executeQuery();


            ArrayList<Project> projects = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                Project project = new Project();
                project.setName(name);
                project.setProjectID(id);
                projects.add(project);
            }

            return projects;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
