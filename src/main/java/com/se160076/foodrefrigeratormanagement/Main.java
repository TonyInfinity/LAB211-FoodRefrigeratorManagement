/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se160076.foodrefrigeratormanagement;

import java.util.ArrayList;

/**
 *
 * @author Tony
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Food> fl = new ArrayList<>();
        Validator validator = new Validator();

        while (true) {
            Manager.readFile(fl);
            Manager.printMenu();

            int choice = validator.checkMenuChoice(1, 5);

            switch (choice) {
                case 1:
                    Manager.createFood(fl);
                    break;
                case 2:
                    Manager.searchFoodByName(fl);
                    break;
                case 3:
                    Manager.deleteFoodById(fl);
                    break;
                case 4:
                    Manager.printFood(fl);
                    break;

                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
