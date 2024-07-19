# E-Shop User Documentation
## Introduction
E-Shop is a simple, console-based online shopping application where users can browse products, add them to a cart, and make purchases. This document describes how to use the application.

## Getting Started
To start the application, run the `Main` class in the `eshop` package.

To test the application with the dummy data, move `users.json` and `products.json` from the root directory to the Downloads folder under the user's home directory. The application will load the data from these files.

## User Registration and Login
When the application starts, you will see three options:

```
1. Login
2. Register
0. Exit
Welcome! Please select:
```

- Choose option `1` to log in. You will be asked to enter your username and password.
- Choose option `2` to register. You will be asked to enter a new username and password. Your account will be created with an initial balance of 0 and an empty shopping cart.
- Choose option `0` to exit the application.

## Shopping

After you log in, you will see the following options:

```
1. Shop
2. View Cart
3. Add balance
4. View balance
0. Logout
Welcome <username>! Please select:
```

- Choose option `1` to shop. You will see a list of available products. Enter the number of the product you want to buy or type back to return to the previous menu. If you choose to buy a product, you will be asked to enter a quantity. The product will be added to your cart.
- Choose option `2` to view your cart. You will see a list of products in your cart. Enter the name of a product to remove it from the cart, type checkout to buy all the products in the cart, or type back to return to the previous menu. When you choose to check out, if you have enough balance, the total cost of the products will be deducted from your balance, and the products will be removed from your cart.
- Choose option `3` to add to your balance. You will be asked to enter the amount to add. The amount will be added to your balance.
- Choose option `4` to view your balance. You will see the current balance of your account.
- Choose option `0` to log out. You will be returned to the initial menu.

## Persistence
All changes you make, such as registering an account, adding balance, and making purchases, are saved in JSON files. When you start the application again, your changes will be loaded.

## JavaDoc
To generate JavaDoc for the application, run the `mvn javadoc:javadoc` command in the root directory of the project. The generated documentation will be saved in the `targe/site/apidocs` directory.

## End of Document
That's all you need to know to use the E-Shop application. Happy shopping!
