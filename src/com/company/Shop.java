package com.company;

import com.company.controllers.ClothesController;
import com.company.controllers.StyleController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {
    private final ClothesController clothesController;
    private final StyleController styleController;
    private final Scanner scanner;

    public Shop(ClothesController clothesController, StyleController styleController) {
        this.clothesController = clothesController;
        this.scanner = new Scanner(System.in);
        this.styleController = styleController;
    }

    public void Start() {
        while (true) {
            System.out.println("Welcome to Our Shop\n" +
                    "Select option:\n" +
                    "1. Get all clothes'\n" +
                    "2. Create clothing\n" +
                    "3. Get clothes by Style\n" +
                    "0. Exit\n");
            try {
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllClothesMenu();
                } else if (option == 2) {
                    createClothingMenu();
                } else if (option == 3) {
                    getClothesByStyleMenu();
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
}
