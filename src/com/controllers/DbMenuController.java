package com.controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DbMenuController {

    Scanner scanner;

    public DbMenuController(){}

    public void DisplayDbMenu(){


        boolean again = true;

        System.out.println("\n******** Database Menu ********");
        System.out.println("What opérations do you want to perform on DB ? (or enter 0 to return to previous menu)");
        System.out.println("    (1) ==> Adding a user");
        System.out.println("    (2) ==> Look for a word");
        System.out.println("    (3) ==> Add a word");
        int inputUser;

        while (true){
            try {
                scanner = new Scanner(System.in);
                inputUser = scanner.nextInt();
                System.out.println("The choice you made is : " + inputUser);

                if(inputUser == 0){
                    break;
                }else if(inputUser ==1){
                    System.out.println("adding a user algo...");

                }else if(inputUser ==2){
                    System.out.println("looking for word algo...");

                }else if(inputUser ==3){
                    System.out.println("adding a word algo...");

                }else{
                    System.out.println("you have to enter a  valid number");
                }

            }
            catch (InputMismatchException e){
                System.out.println("you have to enter a number");
                scanner.close();
            }
        }

    }


}
