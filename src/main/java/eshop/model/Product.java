package eshop.model;

import com.google.gson.annotations.Expose;

/**
 * Product class represents a product in the e-shop system.
 * It holds product information such as id, name, price, count, unit, and description.
 */
public class Product {
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private int count;
    @Expose
    private String unit;
    @Expose
    private String description;

    /**
     * Constructor to create a product.
     * @param id The id of the product.
     * @param name The name of the product.
     * @param price The price of the product.
     * @param count The count of the product.
     * @param unit The unit of the product.
     * @param description The description of the product.
     */
    public Product(int id, String name, double price, int count, String unit, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.unit = unit;
        this.description = description;
    }

    /**
     * Returns the id of the product.
     * @return The id of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the product.
     * @param id The new id of the product.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the product.
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * @param name The new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the product.
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price The new price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the count of the product.
     * @return The count of the product.
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count of the product.
     * @param count The new count of the product.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Returns the unit of the product.
     * @return The unit of the product.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the unit of the product.
     * @param unit The new unit of the product.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Returns the description of the product.
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     * @param description The new description of the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
