package com.example.netfilix.controller;

import com.example.netfilix.service.NetflixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping()
public class NetflixController {

@Autowired
private NetflixService netflixService;

    @GetMapping("/checkAndUpdate")
    public String checkAndUpdate() throws FileNotFoundException, IOException {
        return netflixService.checkCountAndUpdateDB();
    }


}
