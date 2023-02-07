package com.company.entities;

import com.company.controllers.FilterController;

import java.util.ArrayList;
import java.util.Scanner;

public class Filter {
    private final Scanner scanner;
    private final FilterController filterController;

    public Filter(FilterController filterController) {
        this.scanner = new Scanner(System.in);
        this.filterController = filterController;
    }

    public void getClothesByFilterMenu() {
        ArrayList<String> filters = new ArrayList<String>();
        ArrayList<String> filterName = new ArrayList<String>();

        while (true) {
            System.out.println("Current filters: ");
            for (int i = 0; i < filters.size(); i++) {
                System.out.println(filters.get(i) + " : " + filterName.get(i));
            }
            System.out.println();
            System.out.println("Select what to add to ur filter\n" +
                    "1. Season\n" +
                    "2. Style\n" +
                    "3. Gender\n" +
                    "4. Age\n" +
                    "5. Type\n" +
                    "6. Apply filter\n" +
                    "0. Go back to main menu\n");
            int option = scanner.nextInt();
            if (option == 1) {
                filters.add("SeasonName");
                System.out.println("Select season\n" +
                        "1. Summer\n" +
                        "2. Winter\n" +
                        "3. Demi season\n");
                int season = scanner.nextInt();
                if (season == 1) {
                    filterName.add("Summer");
                } else if (season == 2) {
                    filterName.add("Winter");
                } else if (season == 3) {
                    filterName.add("Demiseason");
                }
            } else if (option == 2) {
                filters.add("StyleName");
                System.out.println("Select style\n" +
                        "1. Casual\n" +
                        "2. Classic\n" +
                        "3. Sport\n");
                int style = scanner.nextInt();
                if (style == 1) {
                    filterName.add("Casual");
                } else if (style == 2) {
                    filterName.add("Classic");
                } else if (style == 3) {
                    filterName.add("Sport");
                }
            } else if (option == 3) {
                filters.add("GenderName");
                System.out.println("Select gender\n" +
                        "1. Male\n" +
                        "2. Female\n");
                int gender = scanner.nextInt();
                if (gender == 1) {
                    filterName.add("Male");
                } else if (gender == 2) {
                    filterName.add("Female");
                } else if (option == 4) {
                    filters.add("AgeName");
                    System.out.println("Select age\n" +
                            "1. Adult\n" +
                            "2. Kid\n" +
                            "3. Teenager\n");
                    int age = scanner.nextInt();
                    if (age == 1) {
                        filterName.add("Adult");
                    } else if (age == 2) {
                        filterName.add("Kid");
                    } else if (age == 3) {
                        filterName.add("Teenager");
                    }
                }
            } else if (option == 5) {
                filters.add("TypeName");
                System.out.println("Select type\n" +
                        "1. Accessories\n" +
                        "2. Top\n" +
                        "3. Bottom\n" +
                        "4. Shoes\n");
                int type = scanner.nextInt();
                if (type == 1) {
                    filterName.add("Accessories");
                } else if (type == 2) {
                    filterName.add("Top");
                } else if (type == 3) {
                    filterName.add("Bottom");
                } else if (type == 4) {
                    filterName.add("Shoes");
                }
            } else if (option == 6) {
                filterController.getClothesByFilter(filters, filterName);
                break;
            } else if (option == 0) {
                break;
            }
        }
    }
}
