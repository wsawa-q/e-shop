package eshop.service;

import eshop.model.Cart;
import eshop.model.Product;
import eshop.model.User;
import java.util.Map;

import eshop.utils.JSONLoader;

/**
 * CartService class provides the cart related services in the e-shop system.
 * It allows for adding and removing products from the cart and performing checkout.
 */
public class CartService {
    private final ProductService productService;

    /**
     * Constructor to initialize the CartService with a ProductService instance.
     * @param productService The ProductService instance to use.
     */
    public CartService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Adds a product and its quantity to a cart.
     * @param cart The cart to add the product to.
     * @param product The product to add.
     * @param quantity The quantity of the product.
     */
    public void addToCart(Cart cart, Product product, int quantity){
        cart.addItem(product, quantity);
    }

    /**
     * Removes a product from a cart.
     * @param cart The cart to remove the product from.
     * @param product The product to remove.
     */
    public void removeFromCart(Cart cart, Product product){
        cart.removeItem(product);
    }

    /**
     * Performs the checkout for a user.
     * It calculates the total amount, checks if the user has sufficient balance,
     * updates the product counts, saves the updated products and users data,
     * and clears the cart.
     * @param user The user performing the checkout.
     */
    public void checkout(User user){
        Cart cart = user.getCart();
        double total = 0;
        for(Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        if(user.getBalance() >= total) {
            user.setBalance(user.getBalance() - total);
            for(Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                product.setCount(product.getCount() - quantity);
            }
            JSONLoader.saveProducts(productService.getProducts()); // update products in the JSON file
            JSONLoader.saveUsers(AuthService.getUsers()); // update users in the JSON file
            cart.getItems().clear();
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
