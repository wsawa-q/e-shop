package eshop.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eshop.model.Cart;
import eshop.model.Product;
import eshop.model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.google.gson.GsonBuilder;

/**
 * JSONLoader class provides the functionalities to load and save data to JSON files.
 * It uses the Gson library to convert JSON data into Java objects and vice versa.
 */
public class JSONLoader {
    static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    static String homeDir = System.getProperty("user.home");

    private static List<?> loadJson(String filename, TypeToken<?> typeToken) {
        try {
            Path eshopDir = Path.of(homeDir, ".eshop");
            if (!Files.exists(eshopDir)) {
                Files.createDirectory(eshopDir);
            }

            Path sourceFile = Path.of("src/main/resources/" + filename);
            Path destinationFile = Path.of(eshopDir.toString(), filename);
            if (!Files.exists(destinationFile)) {
                Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            FileReader reader = new FileReader(destinationFile.toString());
            return gson.fromJson(reader, typeToken.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Loads the list of products from the JSON data file.
     * @return The list of Product objects.
     */
    public static List<Product> loadProducts(){
        return (List<Product>) loadJson("products.json", new TypeToken<List<Product>>() {});
    }

    /**
     * Loads the list of users from the JSON data file.
     * It also sets a new empty cart for each user.
     * @return The list of User objects.
     */
    public static List<User> loadUsers(){
        List<User> users = (List<User>) loadJson("users.json", new TypeToken<List<User>>() {});
        for (User user : users) {
            user.setCart(new Cart());
        }
        return users;
    }

    private static void saveJson(String filename, Object object) {
        try {
            Path eshopDir = Path.of(homeDir, ".eshop");
            if (!Files.exists(eshopDir)) {
                Files.createDirectory(eshopDir);
            }

            Path destinationFile = Path.of(eshopDir.toString(), filename);
            FileWriter writer = new FileWriter(destinationFile.toString());
            gson.toJson(object, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the list of users to the JSON data file.
     * @param users The list of User objects to save.
     */
    public static void saveUsers(List<User> users) {
        saveJson("users.json", users);
    }

    /**
     * Saves the list of products to the JSON data file.
     * @param products The list of Product objects to save.
     */
    public static void saveProducts(List<Product> products) {
        saveJson("products.json", products);
    }

}
