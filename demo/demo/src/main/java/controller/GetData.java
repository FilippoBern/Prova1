package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DownAndDec;

import model.StockRecords;
import service.StockData;

@RestController
public class GetData {
	 
	
	//Metodo che restituisce tutti i dati presenti nella collection in formato Json
	@GetMapping ("/data")
	public Vector<JSONObject> getData () {
		
		ArrayList<StockRecords> database= StockData.getRecords();
		int n= database.size();
		Vector<JSONObject> vector =new Vector<JSONObject>();
		for (int i=0; i<n; i++)
		{		
			JSONObject obj= new JSONObject();
			obj.put("Ind", database.get(i).getIndirizzo() );
			obj.put("Att", database.get(i).getAttiva());
			obj.put("ZonaDec", database.get(i).getZona());
			obj.put("Long", database.get(i).getLon());
			obj.put("Lat", database.get(i).getLat());
			obj.put("Loc", database.get(i).getLoc());
			
			vector.add(obj);
		}
		
		return vector;
	}
	
	//Metodo che restituisce i metadati in formato Json
    @GetMapping("/metadata")
	public Vector<JSONObject>  getMetaData () {
		
    	String filename= DownAndDec.getFilename();
    	Vector<JSONObject> vector =new Vector<JSONObject>();
		try {		
		  Scanner file = new Scanner( new FileReader(filename));
		  String line="";
		  if (file.hasNext()) {
		  line=file.nextLine();
		  String[] attributi= line.split(";");
		  int l = attributi.length;
		  int i=0;	
		  while(i<l) {
			  JSONObject obj1= new JSONObject();
			  if (attributi[i].equals( "Indirizzo")) obj1.put("alias", "Ind");
			  else if (attributi[i].equals( "Attiva")) obj1.put("alias", "Att");
			  else if (attributi[i].equals( "ZonaDec")) obj1.put("alias", "ZonaDec");
			  else if (attributi[i].equals( "Longitudine")) obj1.put("alias", "Lon");
			  else if (attributi[i].equals( "Latitudine")) obj1.put("alias", "Lat");
			  else if (attributi[i].equals( "Location")) obj1.put("alias", "Loc");
			  obj1.put("sourceField", attributi[i]);
			  if (attributi[i].equals( "Indirizzo")) obj1.put("type", "string");
			  else if (attributi[i].equals( "Attiva") || attributi[i].equals("ZonaDec")) obj1.put("type", "integer");
			  else obj1.put("type", "double");
			  
			  vector.add(obj1);
			  i++;
		  }
		  }
		  file.close();
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  }
		  
		  return vector;
    }
}
