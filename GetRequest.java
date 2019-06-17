package provaparse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public class GetRequest {
	
	public static void Call() throws Exception {
		
		String url= "https://www.dati.gov.it/api/3/action/package_show?id=05c5f4de-5563-4890-8fc8-31bd0b839806";
		URL obj= new URL(url);
		HttpURLConnection con= (HttpURLConnection)obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode= con.getResponseCode();
		System.out.println("\nSending 'GET' request to url: " + url);
		System.out.println("Response Code =" + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputline;
		StringBuffer response = new StringBuffer();
		while ((inputline= in.readLine()) != null) {
			response.append(inputline);
		}
		in.close();
		
		System.out.println(response.toString());
		
	}
}
