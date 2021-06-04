package com.controllers;

import com.services.CsvManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvMenuController {

    Scanner scanner;

    private CsvManager csvManager;

    public CsvMenuController() {
        csvManager = new CsvManager();
    }

    public void DisplayCsvMenu(){

        boolean again = true;
        boolean fileLoaded = false;
        scanner= new Scanner(System.in);
        List<String[]> FileLines = new ArrayList<>();

        while (true){
            System.out.println("\n    ******* CSV MENU *******");
            System.out.println("    What is your choice ? Enter a number (0 to return to previous menu)\n");

            System.out.println("    (1) ==> Read a CSV File");
            System.out.println("    (2) ==> Analyse a CSV File before integration");
            System.out.println("    (3) ==> Add a CSV File to Database");

            if (fileLoaded){
                System.out.println("\n    *** File LOADED ***");
                System.out.println("    (4) ==> Read Loaded File\n");

            }

            String inputStringUser;
            try {
                inputStringUser = scanner.nextLine();
                int inputInt = Integer.parseInt(inputStringUser);

                if (inputInt == 0){
                    break;
                }else if (inputInt == 1){
                    System.out.println("You choose :read a csv file");
                    System.out.println("\nWhat's the path of your file ?");
                    String inputPath = scanner.nextLine();
                    System.out.println("\n*** you entered the path : " + inputPath + " ***\n");

                    csvManager.setPath(inputPath);

                    var result = csvManager.read();
                    if (result!=null){
                        fileLoaded = true;
                        System.out.println();
                    }

                }else if (inputInt == 2){
                    csvManager.AnalyseCsvFile();
                    break;
                }else if (inputInt == 3){
                    System.out.println("Adding a csv file");
                    break;
                }else  if(inputInt == 4 && fileLoaded == true){
                    csvManager.ReadLoadedFile();
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("\n*************");
                System.out.println(e.getClass().getName());
                System.out.println("This is not a number !!\n");
            }
            catch (IOException e){
//                System.out.println("\n*************");
//                System.out.println(e.getClass().getName());
//                Object o = e.getClass();
//                System.out.println("This is a IO Exception !!\n");
                if(e instanceof NoSuchFileException){
                    System.out.println("File not found with this path !");
                }else if (e instanceof IOException){
                    System.out.println("this is an io Exception");
                }else{
                    e.printStackTrace();
                }
            }
        }
    }

    public void ReadCsvFile(String path){

        boolean again = true;
        scanner= new Scanner(System.in);


        System.out.println("What is the path of file ? (or enter number 0 to return)");
        System.out.println("Format of the file must be the following : ");
        System.out.println("Fist Collumn : Word in English");
        System.out.println("Second Collumn : Translation in french");

        try {
            CsvManager csvManager = new CsvManager(path);
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
            System.out.println("This path is not a file Path ...\n");
        }
        catch (IOException e){
            System.out.println("\n*************");
            System.out.println(e.getClass().getName());
            System.out.println("This is a IO exception !!\n");
        }

    }



}
