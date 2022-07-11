package com.Netflix.netflix.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class NetflixService {

    public String getNRowsOfSpecificType(Integer count ,String type) throws FileNotFoundException, IOException{
        System.out.println("Inside getNRowsOfSpecificType");
        String returnString = null;
        var path = System.getProperty("user.dir") + "\\src\\main\\resources\\netflix_titles.csv";
        System.out.println(path);
        var fileEntries = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null) {
                fileEntries.add(line);
            }
        }
        fileEntries.remove(0);
        for(var entry: fileEntries) {
            // String[] line = entry.split(",");
            String[] line = entry.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            // System.out.println(line);
            if(line[1].equals(type) && count > 0){
                returnString = entry + "\r\n" + returnString ; 
                count--;
            }      
            if(count == 0){
                break;
            }     
        }
        return returnString;
    }
    public String getNRowsWithListedIn(String type) throws IOException {
        System.out.println("Inside getNRowsWithListedIn");
        String returnString = null;
        var path = System.getProperty("user.dir") + "\\src\\main\\resources\\netflix_titles.csv";
        System.out.println(path);
        var fileEntries = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null) {
                fileEntries.add(line);
            }
        }
        fileEntries.remove(0);
        for(var entry: fileEntries) {
            // String[] line = entry.split(",");
            String[] line = entry.split(",(?=([^\"]|\"[^\"]*\")*$)");
            // System.out.println(line);
            // System.out.println(line[10]);
            if(line[10].toUpperCase().contains(type.toUpperCase())){
                returnString = entry + "\n" + returnString;  
                // System.out.println("hello");            
            }
        }
        // System.out.println(type);
    return returnString;
}

public String getNRowsOfSpecificTypeAndCountry(String country) throws IOException {
    System.out.println("Inside getNRowsOfSpecificTypeAndCountry");
    String returnString = null;
    var path = System.getProperty("user.dir") + "\\src\\main\\resources\\netflix_titles.csv";
    System.out.println(path);
    var fileEntries = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line;
        while((line = br.readLine()) != null) {
            fileEntries.add(line);
        }
    }
    fileEntries.remove(0);
    for(var entry: fileEntries) {
        // String[] line = entry.split(",");
        String[] line = entry.split(",(?=([^\"]|\"[^\"]*\")*$)");
        // System.out.println(line);
        if(line[5].contains(country)){
            returnString = entry + "\n" + returnString; 
        }    
 
}
    return returnString;
    
}
public String getNRowsOfSpecificDate(Date startDate, Date endDate) throws IOException {
    System.out.println("Inside getNRowsOfSpecificDate");
    String returnString=null;
    var path = System.getProperty("user.dir") + "\\src\\main\\resources\\netflix_titles.csv";
    System.out.println(path);
    var fileEntries = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line;
        while((line = br.readLine()) != null) {
            fileEntries.add(line);
        }
    }
    fileEntries.remove(0);
    for(var entry: fileEntries) {
        // String[] line = entry.split(",");
        String[] line = entry.split(",(?=([^\"]|\"[^\"]*\")*$)");
        // System.out.println(startDate);
        // System.out.println(endDate);
        Date showDate = null;
        try {
            showDate = new SimpleDateFormat("dd-MMM-yy").parse(line[6]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(showDate != null && showDate.compareTo(startDate) >= 0 &&  showDate.compareTo(endDate) <= 0){
            // System.out.println(entry);
            returnString = entry + "\n" + returnString; 

        }    
    }
    return returnString;
}
}