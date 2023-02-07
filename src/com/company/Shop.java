package com.company;

import com.company.controllers.CartController;
import com.company.controllers.ClothesController;
import com.company.controllers.FilterController;
import com.company.controllers.StyleController;
import com.company.entities.Cart;
import com.company.entities.Clothing;
import com.company.entities.Filter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {
    private final ClothesController clothesController;
    private final StyleController styleController;
    private final FilterController filterController;
    private final CartController cartController;

    private final Scanner scanner;
    private final Filter filter;
    private final Cart cart;
    ArrayList<Clothing> cartClothes;

    public Shop(ClothesController clothesController, StyleController styleController, FilterController filterController, CartController cartController) {
        this.clothesController = clothesController;
        this.scanner = new Scanner(System.in);
        this.styleController = styleController;
        this.filterController = filterController;
        this.cartController = cartController;
        this.filter = new Filter(filterController);
        this.cart = new Cart(cartController);
        this.cartClothes = new ArrayList<Clothing>();
    }

    public void Start() {
        while (true) {
            System.out.println("Welcome to Our Shop\n" +
                    "Select option:\n" +
                    "1. Get all clothes\n" +
                    "2. Show cart contents\n" +
                    "3. Get clothes by filter\n" +
                    "4. Add clothing to the cart\n" +
                    "0. Exit\n");
            try {
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllClothesMenu();
                } else if (option == 2) {
                    cart.showCart(cartClothes);
                } else if (option == 3) {
                    filter.getClothesByFilterMenu();
                } else if (option == 4){
                    addClothingToCartMenu();
                } else if (option == 0){
                    break;
                } else {
                    System.out.println("There is no option like that");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Input must be integer!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("---------------------------------");
        }
    }

    public void getAllClothesMenu() {
        clothesController.getAllClothes();
    }

    public void createClothingMenu() {
        System.out.println("Please enter shop name");
        scanner.nextLine();
        String shopName = scanner.nextLine();
        System.out.println("Please enter season name");
        String seasonName = scanner.next();
        System.out.println("Please enter style name");
        String styleName = scanner.next();
        System.out.println("Please enter gender name");
        String genderName = scanner.next();
        System.out.println("Please enter age name");
        String ageName = scanner.next();
        System.out.println("Please enter type name");
        String typeName = scanner.next();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter price");
        Double price = scanner.nextDouble();
        System.out.println("Please enter color");
        String color = scanner.next();
        System.out.println("Please enter amount");
        int amount = scanner.nextInt();

        String response = clothesController.createClothing(shopName,seasonName,styleName,genderName,ageName,typeName,name,price,color,amount);
        System.out.println(response);
    }

    public void getClothesByStyleMenu() {
        System.out.println("Please enter style name");
        scanner.nextLine();
        String styleName = scanner.nextLine();

        styleController.getClothesByStyle(styleName);
    }

    public void addClothingToCartMenu() {
        System.out.println("Enter the id of the clothing");
        int id = scanner.nextInt();

        Clothing clothing = clothesController.addClothingToCart(id);

        cartClothes.add(clothing);
    }
}
