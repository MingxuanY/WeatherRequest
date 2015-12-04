import java.net.*;

import org.json.*;

import java.io.*;
public class WeatherHistory {
	
	public static String getByPost(String postcode,String datetime)
	{
		String url="https://api.weathersource.com/v1/64a0843f97ef7ec132cd/history_by_postal_code.json?"
				+ "period=hour&postal_code_eq="+postcode+"&country_eq=US&"
				+ "timestamp_eq="+datetime+"&"
				+ "fields=postal_code,country,timestamp,temp,precip,windSpd";
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		String response=HttpRequest.getResponse(url);
		//runtime++;
		//System.out.println(response);
		//System.out.println(runtime);
		
		String result = "";
		try {
			JSONArray j_arr = new JSONArray(response);
			JSONObject j_obj=j_arr.getJSONObject(0);
			int temp=j_obj.getInt("temp");
			int precip= j_obj.getInt("precip");
			int windSpd= j_obj.getInt("windSpd");
			result+="Temperature:"+temp+"\tprecipitation:"+precip+"\twind:"+windSpd;
			/*JSONObject temp=j_object.getJSONObject("temp");
			result+=temp.toString();*/
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static void main(String args[])
	{
		System.out.println(getByPost("90007","2015-10-10T08:00"));
	}
}
