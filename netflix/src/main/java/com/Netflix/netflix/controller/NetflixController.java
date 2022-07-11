package com.Netflix.netflix.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Netflix.netflix.service.NetflixService;

@RestController()
public class NetflixController {

    @Autowired
    private NetflixService netflixService;

    @GetMapping("/tvshows")
    public ResponseEntity<String> getTVShows(@RequestParam(value="count", required = false) Integer count, 
    @RequestParam(value="movieType", required = false) String movieType,
    @RequestParam(value="country", required = false) String country,
    @RequestParam(value="endDate", required = false) String endDate,
    @RequestParam(value="startDate", required = false) String startDate,
    HttpServletResponse response,HttpServletRequest request
    ) throws FileNotFoundException, IOException{
        String requestkey = request.getHeader("X-Auth-Token");
        if(requestkey == null){
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }
        if (count!=null){
            long start = System.currentTimeMillis();
            String val = netflixService.getNRowsOfSpecificType(count, "TV Show");
            long end = System.currentTimeMillis();
            System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            response.setHeader("X-TIME-TO-EXECUTE", (end-start)+"");
            return new ResponseEntity<String>(val,HttpStatus.OK);

        }else if (movieType!=null){
            long start = System.currentTimeMillis();
            String val = netflixService.getNRowsWithListedIn(movieType);
            long end = System.currentTimeMillis();
            System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            response.setHeader("X-TIME-TO-EXECUTE", (end-start)+"");
            return new ResponseEntity<String>(val,HttpStatus.OK);
        }else if(country!=null){
            long start = System.currentTimeMillis();
            String val = netflixService.getNRowsOfSpecificTypeAndCountry(country);
            long end = System.currentTimeMillis();
            System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            response.setHeader("X-TIME-TO-EXECUTE", (end-start)+"");
            return new ResponseEntity<String>(val,HttpStatus.OK);
        }else if(startDate!=null && endDate !=null ){
            Date sDate= null;
            try {
                sDate = new SimpleDateFormat("dd-MMM-yy").parse(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date eDate =null;
            try {
                eDate = new SimpleDateFormat("dd-MMM-yy").parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long start = System.currentTimeMillis();
            String val =netflixService.getNRowsOfSpecificDate(sDate,eDate);
            long end = System.currentTimeMillis();
            System.out.println("Elapsed Time in milli seconds: "+ (end-start));
            response.setHeader("X-TIME-TO-EXECUTE", (end-start)+"");
            return new ResponseEntity<String>(val,HttpStatus.OK);
            

        }
        return null;
        
    }

}

