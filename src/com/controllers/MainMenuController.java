package com.controllers;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainMenuController {

    private Scanner scanner;

    public MainMenuController(){

    }

    public void DisplayMainMenu(){

        while(true){
            //clearScreen();
            System.out.println("\n    ******* MAIN MENU *******");
            System.out.println("What is your choice ? Enter a number\n");
            System.out.println("    (1) ==> CSV File Menu");
            System.out.println("    (2) ==> DataBase Management Menu");
            int inputUser;

            try {
                scanner = new Scanner(System.in);
                inputUser = scanner.nextInt();
                System.out.println("you choose the number : " + inputUser);

                switch (inputUser){
                    case 1:
                        System.out.println(" ==> Loading CSV File Menu");
                        this.AddCsvFileMenu();
                        break;
                    case 2 :
                        System.out.println(" ==> Loading Database Menu");
                        this.QueryDatabaseMenu();
                        break;
                    default:
                        System.out.println("You have to enter a number available");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("you have to enter a number");
                scanner.next();
            }
        }
    }

    public void AddCsvFileMenu(){
        CsvMenuController csvController = new CsvMenuController();
        csvController.DisplayCsvMenu();
    }

    public void QueryDatabaseMenu(){

        DbMenuController dbController = new DbMenuController();
        dbController.DisplayDbMenu();
    }


}
