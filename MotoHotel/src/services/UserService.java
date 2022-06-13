package services;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import repositories.UserRepository;
import models.User;
/*
    Layer #2: Business Logic
*/
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   /* public String getUsersWithLongUsername() throws SQLException {
        // 1. Get all users
        List<User> users = userRepository.GetUser();
        // 2. Filter only those users that have username length bigger than 5 characters
        users = users.stream().filter(user -> user.getUsername().length() > 5).collect(Collectors.toList());
        // 3. Convert the result to string representation and return it
        return users.toString();
    }*/
}
