package projectCalculationTool.subproject;

import projectCalculationTool.util.DBManager;

import java.sql.Connection;

public class SubProjectRepository implements SubProjectRepositoryInterface{
  private static Connection connection = DBManager.getConnection();

  @Override
  public SubProject create(SubProject subProject) {
    return null;
  }

  @Override
  public SubProject read(int subProjectID) {
    return null;
  }
}
