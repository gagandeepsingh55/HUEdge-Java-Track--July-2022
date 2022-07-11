package main.java.com.netflix.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import main.java.com.netflix.service.NetflixServiceImpl;

public class NetflixController {
    public static void main(String[] args) throws IOException{

        NetflixServiceImpl netflixService = new NetflixServiceImpl();

        System.out.println("Please enter query: Q1/Q2/Q3");
        Scanner sc= new Scanner(System.in);  
        String input = sc.nextLine();
        // String input = "Q1";
        if (input.equals("Q1")){
            System.out.println("Please enter number of records");
            int number = sc.nextInt();
            // int number = 4 ;
            System.out.println("Please enter type of records");
            sc.nextLine();
            String type = sc.nextLine();
            // String type = "TV Show";
            System.out.println("Do you want to add date filter? true/false");
            String dateFlag = sc.nextLine();
            // String dateFlag = "true";
            System.out.println(dateFlag);
            if(dateFlag.equals("true")){
                System.out.println("Enter Start date (DD-MMM-YY): ");
                String sDate = sc.nextLine();
                // String sDate = "10-10-19";
                Date startDate = null;
                try {
                    startDate = new SimpleDateFormat("dd-MMM-yy").parse(sDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }  
                System.out.println(startDate);
                System.out.println("Enter end date (DD-MMM-YY) : ");
                String eDate = sc.nextLine();
                // String eDate = "10-10-20";
                Date endDate = null;
                try {
                    endDate = new SimpleDateFormat("dd-MMM-yy").parse(eDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }  
                System.out.println(endDate);
                long start = System.currentTimeMillis();
                netflixService.getNRowsOfSpecificType(number, type, startDate ,endDate);
                long end = System.currentTimeMillis();
                System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            }else{   
                System.out.println("No Date Selected");
                long start = System.currentTimeMillis();
                netflixService.getNRowsOfSpecificType(number, type);
                long end = System.currentTimeMillis();
                System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            }
            
        }else if(input.equals("Q2")){
            System.out.println("Please enter number of records");
            int number = sc.nextInt();
            // int number = 4 ;
            sc.nextLine();
            System.out.println("Please enter Listed in");
            String type = sc.nextLine();
            // String type = "Documentaries";
            System.out.println("Do you want to add date filter? true/false");
            String dateFlag = sc.nextLine();
            // String dateFlag = "true";
            if(dateFlag.equals("true")){
                System.out.println("Enter Start date (DD-MMM-YY): ");
                String sDate = sc.nextLine();
                // String sDate = "10-10-19";
                Date startDate = null;
                try {
                    startDate = new SimpleDateFormat("dd-MMM-yy").parse(sDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }  
                System.out.println(startDate);
                System.out.println("Enter end date (DD-MMM-YY) : ");
                String eDate = sc.nextLine();
                // String eDate = "10-10-20";
                Date endDate = null;
                try {
                    endDate = new SimpleDateFormat("dd-MMM-yy").parse(eDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }  
                System.out.println(endDate);
                long start = System.currentTimeMillis();
                netflixService.getNRowsWithListedIn(number, type, startDate ,endDate);
                long end = System.currentTimeMillis();
                System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            }else{   
                System.out.println("No Date Selected");
                long start = System.currentTimeMillis();
                netflixService.getNRowsWithListedIn(number, type);
                long end = System.currentTimeMillis();
                System.out.println("Elapsed Time in milli seconds: "+ (end-start));
        }
        }else if(input.equals("Q3")){
            System.out.println("Please enter number of records");
            int number = sc.nextInt();
            // int number = 4 ;
            sc.nextLine();
            System.out.println("Please enter type of records");
            String type = sc.nextLine();
            // String type = "Movies";
            System.out.println("Please enter country");
            String country = sc.nextLine();
            // String country = "India";
            System.out.println("Do you want to add date filter? true/false");
            String dateFlag = sc.nextLine();
            // String dateFlag = "true";
            if(dateFlag.equals("true")){
                System.out.println("Enter Start date (DD-MMM-YY): ");
                String sDate = sc.nextLine();
                // String sDate = "10-10-19";
                Date startDate = null;
                try {
                    startDate = new SimpleDateFormat("dd-MMM-yy").parse(sDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }  
                System.out.println(startDate);
                System.out.println("Enter end date (DD-MMM-YY) : ");
                String eDate = sc.nextLine();
                // String eDate = "10-10-20";
                Date endDate = null;
                try {
                    endDate = new SimpleDateFormat("dd-MMM-yy").parse(eDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }  
                System.out.println(endDate);
                long start = System.currentTimeMillis();
                netflixService.getNRowsOfSpecificTypeAndCountry(number, type,country,startDate ,endDate);
                long end = System.currentTimeMillis();
                System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            }else{   
                System.out.println("No Date Selected");
                long start = System.currentTimeMillis();
                netflixService.getNRowsOfSpecificTypeAndCountry(number, type, country);
                long end = System.currentTimeMillis();
                System.out.println("Elapsed Time in milli seconds: "+ (end-start));
        }

        }
        
        sc.close();
    }
}
