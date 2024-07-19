package eshop.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Cart class represents a shopping cart in the e-shop system.
 * It holds a map of products and their respective quantities.
 */
public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    /**
     * Returns the items in the cart.
     * @return A map of the products and their quantities.
     */
    public Map<Product, Integer> getItems() {
        return items;
    }

    /**
     * Sets the items in the cart.
     * @param items A map of the products and their quantities.
     */
    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }

    /**
     * Adds a product and its quantity to the cart.
     * @param product The product to add.
     * @param quantity The quantity of the product.
     */
    public void addItem(Product product, int quantity) {
        this.items.put(product, quantity);
    }

    /**
     * Removes a product from the cart.
     * @param product The product to remove.
     */
    public void removeItem(Product product) {
        this.items.remove(product);
    }
}
