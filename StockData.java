package provaparse;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StockData {
	
private ArrayList<StockRecords> records;
	
	public StockData() {
		records = new ArrayList<StockRecords>();
	}

    public StockRecords getRecordNumber(int i) {
    	return records.get(i);
    }
	
	public int getNumberOfrecords() {
		return records.size();
	}

	public void LoadDatafromFile( String filepath) {
		try {
			Scanner scanner= new Scanner(new FileReader(filepath));
			String line;
			StockRecords record;
			
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				line=scanner.nextLine();
				String[] results= line.split(";");			 
			    int attiva= Integer.parseInt(results[1]); 
			    int zona= Integer.parseInt(results[2]);
			    double lon= Double.parseDouble(results[3]);	
			    double lat= Double.parseDouble(results[4]);	
			    String[] results1= results[5].split(",");
			    double loc= Double.parseDouble(results1[1]);
			    
			
			    record = new StockRecords(results[0],attiva,zona,lon,lat,loc);
			    records.add(record);
			}
			scanner.close();
		}
		catch(Exception e){
			System.out.println("Error");
		}
		
	}

}

