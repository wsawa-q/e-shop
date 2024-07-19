package eshop.service;

import eshop.model.Product;
import eshop.utils.JSONLoader;

import java.util.List;

/**
 * ProductService class provides the product related services in the e-shop system.
 * It allows for retrieving products by name or by ID.
 */
public class ProductService {
    private final List<Product> products;

    /**
     * Constructor to initialize the ProductService.
     * It loads the list of products from the JSON data file.
     */
    public ProductService() {
        this.products = JSONLoader.loadProducts();
    }

    /**
     * Returns the list of products.
     * @return The list of products.
     */
    public List<Product> getProducts(){
        return products;
    }

    /**
     * Returns a product by its name.
     * @param name The name of the product.
     * @return The Product object if it is found, null otherwise.
     */
    public Product getProductByName(String name) {
        for(Product product : products) {
            if(product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Returns a product by its ID.
     * @param id The ID of the product.
     * @return The Product object if it is found, null otherwise.
     */
    public Product getProductById(int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
