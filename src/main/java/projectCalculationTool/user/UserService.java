package projectCalculationTool.user;

public class UserService {
  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User readUser(String userMail, String userPassword){
        return userRepository.read(userMail, userPassword);
    }
}
