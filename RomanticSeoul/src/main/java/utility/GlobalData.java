package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GlobalData {
	public static final String HOST_URL = "http://localhost:8000";
	public static final String POST_START = "/start";
	public static final String GET_ONCALLS = "/oncalls";
	public static final String POST_ACTION = "/action";
	
	public void main() throws IOException {
		URL url = new URL("http://localhost:8089");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		while((inputLine = in.readLine()) != null)
			content.append(inputLine);
		
		in.close();
		con.disconnect();
		
		System.out.println("Response status: " + status);
		System.out.println();
	}
}
