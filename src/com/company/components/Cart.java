package com.company.components;

import com.company.controllers.CartController;
import com.company.entities.Clothing;

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
            System.out.printf("%-10s%-15s%-15s%-15s%-10s%n", "id", "name", "price", "color", "amount");
            for (Clothing clothing:clothes) {
                System.out.printf("%-10s", clothing.getId());
                System.out.printf("%-15s", clothing.getName());
                System.out.printf("%-15s", clothing.getPrice());
                System.out.printf("%-15s", clothing.getColor());
                System.out.printf("%-10s", clothing.getAmount());
                System.out.println();
            }
            System.out.println();
            System.out.println("Select option\n" +
                    "1. Buy clothes\n" +
                    "2. Remove clothing\n" +
                    "3. Clear cart\n" +
                    "4. Go back\n");
            int option = scanner.nextInt();
            if (option == 1) {
                buyClothesMenu(clothes);

                clearCartMenu(clothes);

            } else if (option == 2) {
                System.out.println("Enter id of the clothing");
                int id = scanner.nextInt();
                for (int i = 0; i < clothes.size(); i++) {
                    if (id == clothes.get(i).getId()) {
                        clothes.remove(i);
                    }
                }
            } else if (option == 3) {
                clearCartMenu(clothes);
            } else if (option == 4) {
                break;
            }
        }
    }
    public void buyClothesMenu(ArrayList<Clothing> clothes) {
        for (Clothing clothing : clothes) {
            String response = cartController.buyClothes(clothing);
            System.out.println(response);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void clearCartMenu(ArrayList<Clothing> clothes) {
        for (int i = 0; i < clothes.size(); i++) {
            clothes.remove(i);
        }
        for (int i = 0; i < clothes.size(); i++) {
            clothes.remove(i);
        }
    }

}
