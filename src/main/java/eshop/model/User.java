package eshop.model;

import com.google.gson.annotations.Expose;

/**
 * User class represents a user in the e-shop system.
 * It holds user information such as username, password, balance and cart.
 */
public class User {
    @Expose
    private String username;
    @Expose
    private String password;
    private Cart cart;
    @Expose
    private double balance;

    /**
     * Constructor to create a user without a cart.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param balance The balance of the user.
     */
    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Constructor to create a user with a cart.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param balance The balance of the user.
     * @param cart The shopping cart of the user.
     */
    public User(String username, String password, double balance, Cart cart) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.cart = cart;
    }

    /**
     * Returns the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username The new username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The new password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the shopping cart of the user.
     * @return The shopping cart of the user.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Sets the shopping cart of the user.
     * @param cart The new shopping cart of the user.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Returns the balance of the user.
     * @return The balance of the user.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the user.
     * @param balance The new balance of the user.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Calculates and returns the total cost of the items in the user's cart.
     * @return The total cost of the items in the user's cart.
     */
    public double getCartTotal() {
        double total = 0;
        for(Product product : cart.getItems().keySet()) {
            total += product.getPrice() * cart.getItems().get(product);
        }
        return total;
    }
}
