import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpRequest {

	public static String getResponse(String address)
	{
		 URL url;
		 String result="";
		try {
			url = new URL(address);
			//System.out.println(url);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();  
			
			//GET Request Define:   
			urlConnection.setRequestMethod("GET");  
			//urlConnection.setRequestProperty("connection", "Keep-Alive");
			urlConnection.connect();
			//System.out.print(urlConnection.getResponseCode());
			
			BufferedReader read = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream(),"UTF-8"));
			String line;//—≠ª∑∂¡»°
            while ((line = read.readLine()) != null) {
                result += line;
            }
            read.close();
            urlConnection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
}
