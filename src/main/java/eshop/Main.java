package eshop;

import eshop.model.Cart;
import eshop.model.Product;
import eshop.model.User;
import eshop.service.AuthService;
import eshop.service.CartService;
import eshop.service.ProductService;
import eshop.service.UserService;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This is the main entry point of the application.
 * It provides the user interface for interacting with the e-shop system.
 * It uses AuthService, ProductService, UserService, and CartService to handle the operations.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuthService authService = new AuthService();
    private static final ProductService productService = new ProductService();
    private static final UserService userService = new UserService();
    private static final CartService cartService = new CartService(productService);


    /**
     * A method to get user input from the console.
     * @param prompt The prompt to display to the user.
     * @return The user input.
     */
    private static String getInput(String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Exiting...");
            System.exit(0);
        }

        return null;
    }

    /**
     * The main method starts the application and provides a user interface for login, registration, and exiting the application.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            String option = getInput("Welcome! Please select: ");

            switch (option) {
                case "1" -> {
                    String username = getInput("Enter username: ");
                    String password = getInput("Enter password: ");
                    User user = authService.login(username, password);
                    if (user != null) {
                        shop(user);
                    } else {
                        System.out.println("Invalid username or password");
                    }
                }
                case "2" -> {
                    String newUsername = getInput("Enter username: ");
                    String newPassword = getInput("Enter password: ");
                    authService.register(new User(newUsername, newPassword, 0, new Cart()));

                    System.out.println("Registration successful! Please login.");
                }
                case "0" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    /**
     * This method provides a user interface for shopping, viewing the cart, adding balance, viewing balance, and logging out.
     * @param user the user who is currently logged in
     */
    private static void shop(User user) {
        while (true) {
            System.out.println("1. Shop");
            System.out.println("2. View Cart");
            System.out.println("3. Add balance");
            System.out.println("4. View balance");
            System.out.println("0. Logout");
            String option = getInput("Welcome " + user.getUsername() + "! Please select: ");

            switch (option) {
                case "1" -> {
                    System.out.println("Available products:");
                    for (Product product : productService.getProducts()) {
                        if (product.getCount() == 0) {
                            continue;
                        }

                        System.out.println(product.getId() + ". " + product.getName() + " - " + product.getPrice() + " - (" + product.getCount() + product.getUnit() + ")");
                    }
                    String productName = getInput("Enter product number to buy or 'back' to go back: ");
                    if (!productName.equalsIgnoreCase("back")) {
                        Product product;
                        if (!productName.matches("\\d+")) {
                            System.out.println("Invalid product number");
                            break;
                        } else {
                            product = productService.getProductById(Integer.parseInt(productName));
                        }

                        if (product != null) {
                            String quantityString = getInput("Enter quantity: ");
                            if (!quantityString.matches("\\d+")) {
                                System.out.println("Invalid quantity");
                                break;
                            }

                            int quantity = Integer.parseInt(quantityString);

                            if (quantity > product.getCount()) {
                                System.out.println("Not enough stock");
                                break;
                            }

                            if (quantity < 0) {
                                System.out.println("Invalid quantity");
                                break;
                            }

                            cartService.addToCart(user.getCart(), product, quantity);
                            System.out.println("Product added to cart");
                        } else {
                            System.out.println("Invalid product name");
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Your cart: ");
                    double sum = 0;
                    for (Product product : user.getCart().getItems().keySet()) {
                        sum += product.getPrice() * user.getCart().getItems().get(product);
                        System.out.println(product.getName() + " - " + user.getCart().getItems().get(product) + " - " + product.getPrice() * user.getCart().getItems().get(product));
                    }
                    System.out.println("Total: " + sum);
                    String cartOption = getInput("Enter product name to remove or 'checkout' to buy or 'back' to go back: ");
                    if (cartOption.equalsIgnoreCase("checkout")) {
                        if (user.getCart().getItems().isEmpty()) {
                            System.out.println("Cart is empty");
                            break;
                        }

                        cartService.checkout(user);
                    } else if (!cartOption.equalsIgnoreCase("back")) {
                        Product product = productService.getProductByName(cartOption);
                        if (product != null) {
                            cartService.removeFromCart(user.getCart(), product);
                            System.out.println("Product removed from cart");
                        } else {
                            System.out.println("Invalid product name");
                        }
                    }
                }
                case "3" -> {
                    String amountString = getInput("Enter amount to add to balance: ");
                    if (!amountString.matches("\\d+\\.?\\d*")) {
                        System.out.println("Invalid amount");
                        break;
                    }
                    double amount = Double.parseDouble(amountString);
                    userService.addBalance(user, amount);
                    System.out.println("Balance added");
                }
                case "4" -> System.out.println("Your balance: " + user.getBalance());
                case "0" -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}

                           
