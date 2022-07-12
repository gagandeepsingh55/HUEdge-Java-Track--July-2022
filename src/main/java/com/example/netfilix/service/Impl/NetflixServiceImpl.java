package com.example.netfilix.service.Impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.netfilix.service.NetflixService;
import com.example.netfilix.entity.NetflixEntity;
import com.example.netfilix.repository.NetflixRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.springframework.stereotype.Service;

import static com.example.netfilix.NetfilixApplication.oldcount;
@Service
public class NetflixServiceImpl implements NetflixService {

    @Autowired
    public NetflixRepository netflixRepository;

    @Override
    public String checkCountAndUpdateDB() {
        int currCount = getCount();
        Date showDate = null;
        java.sql.Date sqlDate = null;

        if (oldcount == currCount) {
            return "No Change in file";
        } else if (oldcount < currCount) {
            var path = System.getProperty("user.dir") + "\\src\\main\\resources\\netflix_titles.csv";
            System.out.println(path);
            var fileEntries = new ArrayList<String>();
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    fileEntries.add(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileEntries.remove(0);
            System.out.println(fileEntries.size());
            for (var entry : fileEntries) {
                if (entry.equals(",,,,,,,,,,,")){
                    break;
                }
                String[] row = entry.split(",(?=([^\"]|\"[^\"]*\")*$)");
                //Setting values
                NetflixEntity netflixEntity = new NetflixEntity();
                netflixEntity.setShowId(row[0]);
                netflixEntity.setShowType(row[1]);
                netflixEntity.setTitle(row[2]);
                netflixEntity.setDirector(row[3]);
                netflixEntity.setCast(row[4]);
                netflixEntity.setCountry(row[5]);
                try {
                    showDate = new SimpleDateFormat("dd-MMM-yy").parse(row[6]);
                    sqlDate = new java.sql.Date(showDate.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                netflixEntity.setDateAdded(sqlDate);
                netflixEntity.setRelease_year(row[7]);
                netflixEntity.setRating(row[8]);
                netflixEntity.setDuration(row[9]);
                netflixEntity.setListedIn(row[10]);
                netflixEntity.setDescription(row[11]);
                //Saving to DB
                NetflixEntity savedEntity = netflixRepository.save(netflixEntity);

            }
        }
        return "values Updated";
    }

    public int getCount() {
        int count = 0;
        var path = System.getProperty("user.dir") + "\\src\\main\\resources\\netflix_titles.csv";
        var fileEntries = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileEntries.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        count = fileEntries.size();
        return count;
    }

}