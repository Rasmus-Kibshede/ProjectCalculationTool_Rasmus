package projectCalculationTool.user;

public class UserService {
    UserRepositoryInterface userRepositoryInterface;

    public UserService(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }
}