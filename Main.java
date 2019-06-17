package provaparse;
public class Main {
public static void main(String[] args) {
		
		DownAndDec.Decode();
		StockData stockdata= new StockData();
		stockdata.LoadDatafromFile("C:\\Users\\Andrea\\eclipse-workspace\\Prova1\\" + DownAndDec.getFilename());
		System.out.println("Sono stati registrati " + stockdata.getNumberOfrecords() + " records");
		for (int i=0; i<stockdata.getNumberOfrecords(); i++) {
		 System.out.println(stockdata.getRecordNumber(i));
			{		
		 
}
		/*try {
		GetRequest.Call();
		}
		catch(Exception e) {
		e.printStackTrace();
		}*/
	
}	



