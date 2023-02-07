package com.company.entities;

import com.company.controllers.CartController;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Cart {

    private final Scanner scanner;
    private final CartController cartController;

    public Cart(CartController cartController) {
        this.cartController = cartController;
        this.scanner = new Scanner(System.in);
    }

    public void showCart(ArrayList<Clothing> clothes) {

        while (true) {
            System.out.println("Cart contents:");
            for (Clothing clothing : clothes) {
                System.out.println(clothing.getId() + " " + clothing.getName() + " " + clothing.getPrice() + " " + clothing.getColor() + " " + clothing.getAmount());
            }
            System.out.println();
            System.out.println("Select option\n" +
                    "1. Buy clothes\n" +
                    "2. Remove clothing\n" +
                    "3. Clear cart\n" +
                    "4. Go back\n");
            int option = scanner.nextInt();
            if (option == 1) {
                for (Clothing clothing : clothes) {
                    String response = cartController.buyClothes(clothing);
                    System.out.println(response);
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                for (int i = 0; i < clothes.size(); i++) {
                    clothes.remove(i);
                }
                for (int i = 0; i < clothes.size(); i++) {
                    clothes.remove(i);
                }

            } else if (option == 2) {
                System.out.println("Enter id of the clothing");
                int id = scanner.nextInt();
                for (int i = 0; i < clothes.size(); i++) {
                    if (id == clothes.get(i).getId()) {
                        clothes.remove(i);
                    }
                }
            } else if (option == 3) {
                for (int i = 0; i < clothes.size(); i++) {
                    clothes.remove(i);
                }
                for (int i = 0; i < clothes.size(); i++) {
                    clothes.remove(i);
                }
            } else if (option == 4) {
                break;
            }
        }

    }
}
