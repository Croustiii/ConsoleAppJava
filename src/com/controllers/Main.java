package com.controllers;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        MainMenuController mainMenuController = new MainMenuController();

        mainMenuController.DisplayMainMenu();




//        try {
//            List<String[]> results = readData();
//
//            for (String[] array : results) {
//
//                for (String str : array){
//                    System.out.println("************************");
//                    System.out.print(str + " , ");
//                }
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }





    }

    public static List<String[]> readData() throws IOException {
        int count = 0;
        String file = "testcsv.csv";
        List<String[]> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
