package com.example.netfilix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class NetfilixApplication {
	public static int oldcount=0;

	public static void main(String[] args) {
		SpringApplication.run(NetfilixApplication.class, args);
		while(true) {
			try {

				URL url = new URL("http://localhost:8080/checkAndUpdate");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP Error code : "
							+ conn.getResponseCode());
				}
				InputStreamReader in = new InputStreamReader(conn.getInputStream());
				BufferedReader br = new BufferedReader(in);
				String output;
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
				conn.disconnect();
				Thread.sleep(10000);

			} catch (Exception e) {
				System.out.println("Exception in NetClientGet:- " + e);
			}
		}
	}
}