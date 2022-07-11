package main.java.com.netflix.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class NetflixServiceImpl implements NetflixService {

    @Override
    public void getNRowsOfSpecificType(int number, String type) throws IOException{
        System.out.println("Inside getNRowsOfSpecificType");
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
            if(line[1].equals(type) && number > 0){
                System.out.println(entry); 
                number--;
            }      
            if(number == 0){
                break;
            }     
        }
        System.out.println("Done");
    }

    @Override
    public void getNRowsWithListedIn(int number, String type) throws IOException {
        System.out.println("Inside getNRowsWithListedIn");
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
            if(line[10].contains(type) && number > 0){
                System.err.println(line[10]);
                System.out.println(entry); 
                number--;
            }    
            if(number == 0){
                break;
            }
        }
}

    @Override
    public void getNRowsOfSpecificTypeAndCountry(int number, String type, String country) throws IOException {
        System.out.println("Inside getNRowsOfSpecificTypeAndCountry");
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
            if(line[10].contains(type) && number > 0 && line[5].contains(country)){
                System.err.println(line[10]);
                System.out.println(entry); 
                number--;
            }    
            if(number == 0){
                break;
            }
        }
        
    }

    @Override
    public void getNRowsOfSpecificType(int number, String type, Date startDate, Date endDate) throws IOException {
        System.out.println("Inside getNRowsWithListedIn");
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
            // System.out.println(line[6]);
            Date showDate = null;
            try {
                showDate = new SimpleDateFormat("dd-MMM-yy").parse(line[6]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(line[10].contains(type) && number > 0 && showDate.compareTo(startDate) > 0 &&  showDate.compareTo(endDate) < 0){
                // System.err.println(line[10]);
                System.out.println(entry); 
                number--;
            }    
            if(number == 0){
                break;
            }
        }
    }

    @Override
    public void getNRowsWithListedIn(int number, String type, Date startDate, Date endDate) throws IOException {
        System.out.println("Inside getNRowsWithListedIn");
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
            Date showDate = null;
            try {
                showDate = new SimpleDateFormat("dd-MMM-yy").parse(line[6]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // System.out.println(line);
            if(line[10].contains(type) && number > 0 && showDate.compareTo(startDate) > 0 &&  showDate.compareTo(endDate) < 0){
                System.err.println(line[10]);
                System.out.println(entry); 
                number--;
            }    
            if(number == 0){
                break;
            }
        }
        
    }

    @Override
    public void getNRowsOfSpecificTypeAndCountry(int number, String type, String country, Date startDate, Date endDate)
            throws IOException {
                System.out.println("Inside getNRowsOfSpecificTypeAndCountry");
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
                    Date showDate = null;
                    try {
                        showDate = new SimpleDateFormat("dd-MMM-yy").parse(line[6]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(line[10].contains(type) && number > 0 && line[5].contains(country) && showDate.compareTo(startDate) > 0 &&  showDate.compareTo(endDate) < 0){
                        System.err.println(line[10]);
                        System.out.println(entry); 
                        number--;
                    }    
                    if(number == 0){
                        break;
                    }
                }
                
        
    }

}