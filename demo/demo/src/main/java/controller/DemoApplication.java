package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.DownAndDec;

import service.StockData;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
		DownAndDec.Decode();
		StockData stockdata= new StockData();
		stockdata.LoadDatafromFile( DownAndDec.getFilename());
		
		
		System.out.println("Sono stati registrati " + stockdata.getNumberOfrecords() + " records");
		
	}

}
