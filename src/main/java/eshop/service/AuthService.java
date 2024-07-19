package eshop.service;

import eshop.model.User;
import eshop.utils.JSONLoader;
import java.util.List;

/**
 * AuthService class provides the authentication services in the e-shop system.
 * It allows for user login and registration.
 */
public class AuthService {
    private static List<User> users;

    /**
     * Constructor to initialize the AuthService.
     * It loads the list of users from the JSON data file.
     */
    public AuthService() {
        users = JSONLoader.loadUsers();
    }

    /**
     * Verifies the user credentials and logs in the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The User object if the login is successful, null otherwise.
     */
    public User login(String username, String password){
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Registers a new user and saves the updated list of users to the JSON data file.
     * @param user The User object to register.
     */
    public void register(User user){
        users.add(user);
        JSONLoader.saveUsers(users);
    }

    /**
     * Returns the list of users.
     * @return The list of users.
     */
    public static List<User> getUsers(){
        return users;
    }
}
