package main.java.com.netflix.service;

import java.io.IOException;
import java.util.Date;

public interface NetflixService {
    public void getNRowsOfSpecificType(int number , String type) throws IOException;
    public void getNRowsOfSpecificType(int number , String type , Date startDate, Date endDate) throws IOException;
    public void getNRowsWithListedIn(int number , String type) throws IOException;
    public void getNRowsWithListedIn(int number , String type, Date startDate, Date endDate) throws IOException;
    public void getNRowsOfSpecificTypeAndCountry(int number , String type,String country) throws IOException;
    public void getNRowsOfSpecificTypeAndCountry(int number , String type,String country,Date startDate, Date endDate) throws IOException;
}
