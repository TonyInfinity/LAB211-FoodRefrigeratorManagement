/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se160076.foodrefrigeratormanagement;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author Tony
 */
public class Manager {

    public static void printMenu() {
        System.out.println("\n|---------------------------------------------------------------------------------------------------------|");
        System.out.println("| 1. Add A New Food.                                                                                      |");
        System.out.println("| 2. Search Food By Name.                                                                                 |");
        System.out.println("| 3. Remove Food By ID.                                                                                   |");
        System.out.println("| 4. Print Food List In Descending Order Of Expired Date.                                                 |");
        System.out.println("| 5. Quit.                                                                                                |");
        System.out.println("|---------------------------------------------------------------------------------------------------------|");
        System.out.println("Enter [1, 5]:\n");
    }

    public static void createFood(ArrayList<Food> fl) {
        do {
            String id;
            do {
                System.out.println("Enter Food Id: ");
                id = Validator.checkFoodId();
            } while (Validator.checkIfIdExists(fl, id) == true);

            System.out.println("Enter Food Name: ");
            String name = Validator.checkFoodName();

            System.out.println("Enter Food Weight (g): ");
            int weight = Validator.checkFoodWeight();

            System.out.println("Enter Food Type: ");
            String type = Validator.checkFoodType();

            System.out.println("Enter Food Place: ");
            String place = Validator.checkFoodPlace();

            String expiredDate;
            do {
                System.out.println("Enter Food Expired Date (dd/MM/yyyy): ");
                expiredDate = Validator.checkInputString();
            } while (Validator.checkFoodDate(expiredDate) == false);

            fl.add(new Food(id, name, weight, type, place, expiredDate));

            System.out.println("Create Food Successful.");

        } while (Validator.checkInputYN() == true);

        writeFile(fl);
    }

    public static void searchFoodByName(ArrayList<Food> fl) {
        boolean foundFood = false;
        do {
            System.out.println("\n1. Search By Name.");
            System.out.println("2. Search By Id.");
            System.out.println("3. Search By Weight.");
            System.out.println("4. Search By Type.");
            System.out.println("5. Search By Place.");
            System.out.println("6. Search By Expired Date.\n");

            int choice = Validator.checkMenuChoice(1, 6);

            switch (choice) {
                case 1:
                    System.out.println("Enter Food Name: ");
                    String name = Validator.checkInputString();
                    name = name.toLowerCase();
                    for (Food food : fl) {
                        if (food.getName().toLowerCase().contains(name) || food.getName().equalsIgnoreCase(name)) {
                            food.print();
                            foundFood = true;
                        }
                    }
                    if (!foundFood) {
                        System.out.println("This Food Does Not Exist.");
                        System.out.println("Please Try Again.");
                    }
                    break;
                case 2:
                    System.out.println("Enter Food Id: ");
                    String id = Validator.checkInputString();
                    id = id.toLowerCase();
                    for (Food food : fl) {
                        if (food.getId().toLowerCase().contains(id) || food.getId().equalsIgnoreCase(id)) {
                            food.print();
                            foundFood = true;
                        }
                    }
                    if (!foundFood) {
                        System.out.println("This Food Does Not Exist.");
                        System.out.println("Please Try Again.");
                    }
                    break;

                case 3:
                    System.out.println("Enter Food Weight (g): ");
                    int weight = Validator.checkFoodWeight();
                    for (Food food : fl) {
                        if (food.getWeight() == weight) {
                            food.print();
                            foundFood = true;
                        }
                    }
                    if (!foundFood) {
                        System.out.println("This Food Does Not Exist.");
                        System.out.println("Please Try Again.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Food Type: ");
                    System.out.println("1. Vegetables.\n"
                            + "2. Fruits.\n"
                            + "3. Grains.\n"
                            + "4. Meat.\n"
                            + "5. Seafood.\n"
                            + "6. Dairy.\n"
                            + "7. Eggs.\n");
                    int type = Validator.checkMenuChoice(1, 7);
                    switch (type) {
                        case 1:
                            for (Food food : fl) {
                                if (food.getType().equalsIgnoreCase("Vegetables")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        case 2:
                            for (Food food : fl) {
                                if (food.getType().equalsIgnoreCase("Fruits")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        case 3:
                            for (Food food : fl) {
                                if (food.getType().equalsIgnoreCase("Grains")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        case 4:
                            for (Food food : fl) {
                                if (food.getType().equalsIgnoreCase("Meat")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        case 5:
                            for (Food food : fl) {
                                if (food.getType().equalsIgnoreCase("Seafood")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        case 6:
                            for (Food food : fl) {
                                if (food.getType().equalsIgnoreCase("Dairy")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        case 7:
                            for (Food food : fl) {
                                if (food.getType().equalsIgnoreCase("Eggs")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Enter Food Place: ");
                    System.out.println("1. Freezer.\n"
                            + "2. Chiller.\n");
                    int place = Validator.checkMenuChoice(1, 2);
                    switch (place) {
                        case 1:
                            for (Food food : fl) {
                                if (food.getPlace().equalsIgnoreCase("Freezer")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;

                        case 2:
                            for (Food food : fl) {
                                if (food.getPlace().equalsIgnoreCase("Chiller")) {
                                    food.print();
                                    foundFood = true;
                                }
                            }
                            if (!foundFood) {
                                System.out.println("This Food Does Not Exist.");
                                System.out.println("Please Try Again.");
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                case 6:
                    System.out.println("Enter Food Expired Date (dd/MM/yyyy): ");
                    String expiredDate = Validator.checkInputString();
                    for (Food food : fl) {
                        if (food.getExpiredDate().contains(expiredDate) || food.getExpiredDate().equals(expiredDate)) {
                            food.print();
                            foundFood = true;
                        }
                    }
                    if (!foundFood) {
                        System.out.println("This Food Does Not Exist.");
                        System.out.println("Please Try Again.");
                    }
                    break;

                default:
                    break;
            }

        } while (Validator.checkInputYN() == true);
    }

    public static void deleteFoodById(ArrayList<Food> fl) {
        printFood(fl);
        do {
            String id;
            System.out.println("Enter Food Id To Delete: ");
            id = Validator.checkInputString();

            if (Validator.checkIfIdExistsToDelete(fl, id) == false) {
                System.out.println("\nFood With This Id Does Not Exist.");
            } else {
                if (Validator.checkDeleteConfirmation()) {
                    fl.remove(getIndexOfFood(fl, id));
                    System.out.println("\nFood Deleted Successfully.\n");
                } else {
                    return;
                }
            }
        } while (Validator.checkInputYN() == true);
        writeFile(fl);
    }

    public static void printFood(ArrayList<Food> fl) {
        if (fl.isEmpty()) {
            System.out.println("Food List Is Empty.");
            return;
        }

        Collections.sort(fl, new Comparator<Food>() {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public int compare(Food f1, Food f2) {
                try {
                    return f.parse(f2.getExpiredDate()).compareTo(f.parse(f1.getExpiredDate()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }

            }
        });

        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------|\n");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", "Id", "Name", "Weight", "Type", "Place", "ExpiredDate");
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------|\n");
        for (Food food : fl) {
            food.print();
        }
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------|\n");
    }

    public static int getIndexOfFood(ArrayList<Food> fl, String id) {
        for (int i = 0; i < fl.size(); i++) {
            if (fl.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void readFile(ArrayList<Food> fl) {
        try {
            File f = new File("foods.txt");
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String food;

            while ((food = bf.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(food, ",");
                String id = st.nextToken();
                String name = st.nextToken();
                int weight = Integer.parseInt(st.nextToken());
                String type = st.nextToken();
                String place = st.nextToken();
                String expiredDate = st.nextToken();

                if (Validator.checkIfIdExistsToAddToList(fl, id) == false) {
                    fl.add(new Food(id, name, weight, type, place, expiredDate));
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("An Error Occurred.");
        }
    }

    public static void writeFile(ArrayList<Food> fl) {
        try {
            FileWriter fw = new FileWriter("foods.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (Food food : fl) {
                pw.println(food.toString());
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("An Error Occurred.");
            e.printStackTrace();
        }
    }

}
