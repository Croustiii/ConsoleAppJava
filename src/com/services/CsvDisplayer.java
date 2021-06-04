package com.services;

import java.util.List;

public class CsvDisplayer {

    public CsvDisplayer(){

    }

    public void DisplayCsv(List<String[]> content){

        for(String[] sArr : content){
            System.out.println();
        }

    }

}
