package com.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvManager {

    private Path path;

    BufferedReader bufferedReader;

    public CsvManager() {
    }

    public CsvManager (Path _path){
        this.setPath(_path);

    }

    // read a file
    public void read() throws  IOException {

        try {
            BufferedReader reader = Files.newBufferedReader(path);

            List<String> lines = new ArrayList<>();
            String line ="";
            while ((line = reader.readLine()) != null){

                System.out.println(line);
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public Path getPath() {
        return path;
    }
    public void setPath (Path path) {
        this.path = path;
    }

}
