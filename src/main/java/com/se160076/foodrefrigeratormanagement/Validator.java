/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se160076.foodrefrigeratormanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tony
 */
public class Validator {

    private final static Scanner sc = new Scanner(System.in);

    public static int checkMenuChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("\nChoice Must Be An Integer.");
                System.out.println("Please Enter Again\n");
                System.out.println("Enter [1, 5]:\n");
            }
        }
    }

    public static int checkFoodWeight() {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString());

                if (result <= 0 || result > 1000000) {
                    System.out.println("\nInput Must Be In Range [1, 1000000].");
                    System.out.println("Please Enter Again.\n");
                    System.out.println("Enter Food Weight: ");
                } else {
                    return result;
                }
            } catch(NumberFormatException e) {
                System.out.println("Food Weight Must Be An Integer. \n");
                System.out.println("Please Enter Again.\n");
                System.out.println("Enter Food Weight: ");
                
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("\nInput Must Not Be Empty.");
                System.out.println("Please Enter Again.\n");
            } else {
                return result;
            }
        }
    }

    public static String checkFoodId() {
        while (true) {
            String result = checkInputString();
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            Matcher matcher = pattern.matcher(result);
            if (!matcher.matches()) {
                System.out.println("\nId Must Not Contain Special Characters.");
                System.out.println("Please Enter Again.\n");
                System.out.println("Enter Food Id: ");
            } else {
                return result;
            }
        }
    }

    public static String checkFoodName() {
        while (true) {
            String result = checkInputString();
            Pattern pattern = Pattern.compile("[a-zA-Z ]*");
            Matcher matcher = pattern.matcher(result);
            if (!matcher.matches()) {
                System.out.println("\nName Must Not Contain Special Characters.");
                System.out.println("Please Enter Again.\n");
                System.out.println("Enter Food Name: ");
            } else {
                return result;
            }
        }
    }

    public static String checkFoodType() {
        int result;
        while (true) {
            System.out.println("1. Vegetables.\n"
                    + "2. Fruits.\n"
                    + "3. Grains.\n"
                    + "4. Meat.\n"
                    + "5. Seafood.\n"
                    + "6. Dairy.\n"
                    + "7. Eggs.\n");

            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0 || result >= 8) {
                    System.out.println("\nInput Must Be In Range [1, 7].");
                    System.out.println("Please Enter Again.\n");
                } else {
                    switch (result) {
                        case 1:
                            return "Vegetables";
                        case 2:
                            return "Fruits";
                        case 3:
                            return "Grains";
                        case 4:
                            return "Meat";
                        case 5:
                            return "Seafood";
                        case 6:
                            return "Dairy";
                        case 7:
                            return "Eggs";

                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput Must Be An Enteger.");
                System.out.println("Please ENter Again.\n");
                System.out.println("Enter Food Type: ");
            }
        }
    }

    public static String checkFoodPlace() {
        int result;
        while (true) {
            System.out.println("1. Freezer.\n"
                    + "2. Chiller.\n");

            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0 || result >= 3) {
                    System.out.println("\nInput Must Be In Range [1, 2].");
                    System.out.println("Please Enter Again.\n");
                } else {
                    switch (result) {
                        case 1:
                            return "Freezer";
                        case 2:
                            return "Chiller";
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput Must Be An Integer.");
                System.out.println("Please Enter Again.\n");
                System.out.println("Enter Food Place: ");
            }
        }
    }

    public static boolean checkInputYN() {
        System.out.println("\nDo You Wish To Continue? (Y/n)\n");

        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("\nInput Must Be Either Y/y Or N/n.");
                System.out.println("Please Enter Again.\n");
            }
        }
    }

    public static boolean checkFoodDate(String result) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        try {
            Date date = format.parse(result);
            if (date.before(new Date())) {
                System.out.println("\nDate Must Not Be Expired Today.");
                System.out.println("Please Enter Again.\n");
                return false;
            }
        } catch (ParseException e) {
            System.out.println("\nDate Must Be In Valid Format (dd/MM/yyyy).");
            System.out.println("Please Enter Again.\n");
            return false;
        }
        return true;
    }

    public static boolean checkIfIdExists(ArrayList<Food> fl, String id) {
        for (Food food : fl) {
            if (food.getId().equalsIgnoreCase(id)) {
                System.out.println("\nId Must Be Unique.");
                System.out.println("Please Try Again.\n");
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfIdExistsToAddToList(ArrayList<Food> fl, String id) {
        for (Food food : fl) {
            if (food.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfIdExistsToDelete(ArrayList<Food> fl, String id) {
        for (Food food : fl) {
            if (food.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /*
    public static boolean checkDeleteConfirmation() {
        System.out.println("\nDo You Wish To Delete This Food? (Y/n)\n");

        String result = checkInputString();

        if (result.equalsIgnoreCase("Y")) {
            return true;
        } else if (result.equalsIgnoreCase("N")) {
            return false;
        }
        System.out.println("\nInput Must Be Either Y/y Or N/n.");
        System.out.println("Please Enter Again.\n");
        return false;

    }
    */

    public static boolean checkDeleteConfirmation() {
        System.out.println("\nDo You Wish To Delete This Food? (Y/n)\n");

        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("\nInput Must Be Either Y/y Or N/n.");
                System.out.println("Please Enter Again.\n");
            }
        }
    }
}
