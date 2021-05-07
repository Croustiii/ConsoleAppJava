package com.controllers;

import com.services.CsvManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CsvMenuController {

    Scanner scanner;

    public CsvMenuController() {
    }

    public void DisplayCsvMenu(){

        boolean again = true;
        scanner= new Scanner(System.in);


        while (true){
            System.out.println("\n    ******* CSV MENU *******");
            System.out.println("What is your choice ? Enter a number (0 to return to previous menu)\n");
            System.out.println("    (1) ==> Read a CSV File");
            System.out.println("    (2) ==> Analyse a CSV File before integration");
            System.out.println("    (3) ==> Add a CSV File to Database");


            String inputStringUser;
            try {
                inputStringUser = scanner.nextLine();
                int inputInt = Integer.parseInt(inputStringUser);
                if (inputInt == 0){
                    break;
                }else if (inputInt == 1){
                    System.out.println("read a csv file");
                    //break;
                }else if (inputInt == 2){
                    System.out.println("Analyzing a csv file");
                    break;
                }else if (inputInt == 3){
                    System.out.println("Adding a csv file");
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("\n*************");
                System.out.println(e.getClass().getName());
                System.out.println("This is not a number !!\n");
            }


        }



    }

    public void IntegrateCsvFile(){

        boolean again = true;
        scanner= new Scanner(System.in);


        while (true){
            System.out.println("What is the path of file ? (or enter number 0 to return)");
            System.out.println("Format of the file must be the following : ");
            System.out.println("Fist Collumn : Word in English");
            System.out.println("Second Collumn : Translation in french");


            String inputStringUser;
            try {
                inputStringUser = scanner.nextLine();
                int inputInt = Integer.parseInt(inputStringUser);
                if (inputInt == 0){
                    break;
                }

                System.out.println("The path you entered is : " + inputStringUser);
                Path inputUser = Paths.get(inputStringUser);
                CsvManager csvManager = new CsvManager(inputUser);
                csvManager.read();

            }
            catch (FileNotFoundException e){
                System.out.println("\n*************");
                System.out.println(e.getClass().getName());
                System.out.println("File cant be found\n");
            }
            catch (NoSuchFileException e){
                System.out.println("\n*************");
                System.out.println(e.getClass().getName());
                System.out.println("Mets un vrai chemin de fichier !!\n");
            }
            catch (IOException e){
                System.out.println("\n*************");
                System.out.println(e.getClass().getName());
                System.out.println("Ceci est une IO exception !!\n");
            }
        }
    }

}
