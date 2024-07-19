package eshop.service;

import eshop.model.User;

/**
 * UserService class provides the user related services in the e-shop system.
 * It allows for adding balance to a user.
 */
public class UserService {
    /**
     * Adds balance to a user.
     * @param user The User object to add balance to.
     * @param amount The amount to add.
     */
    public void addBalance(User user, double amount){
        user.setBalance(user.getBalance() + amount);
    }
}

