package com.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvManager {
    //C:\Users\Sam\Desktop\Test\JavaConsoleApp\testcsv.csv

    private Path path;

    private BufferedReader bufferedReader;

    private List<String[]> file = new ArrayList<>();

    public Path getPath() {
        return path;
    }
    public void setPath (String path) {
        this.path = Paths.get(path);
    }

    public CsvManager() {}

    public CsvManager (String _path){
        this.setPath(_path);
    }

    // read a file
    public List<String[]> read() throws  IOException {

        List<String[]> lines = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String line ="";
            System.out.println("    Beggining of File Content : \n");
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                lines.add(line.split(";"));
            }
            System.out.println("\n    End of File Content : ");

            file = lines;
            return lines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public void ReadLoadedFile(){
        for(String[] line : file){
            System.out.println(Arrays.toString(line));
        }
    }

    public void AnalyseCsvFile(){

        // Checking columns headers
        String[] headers = file.get(0);

        System.out.println(Arrays.toString(headers));


    }






}
