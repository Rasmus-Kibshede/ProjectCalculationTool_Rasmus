package projectCalculationTool.user;

public interface UserRepositoryInterface {

    User read(String userMail, String userPassword);
}
