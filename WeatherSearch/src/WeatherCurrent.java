import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherCurrent {

	public static String getByPost(String postcode)
	{
		String url="http://api.openweathermap.org/data/2.5/weather?"
				+ "zip="+postcode+",us&appid=d2ebba8d69c3d7d3c431dc63aa2fca35&units=imperial";
			
		String response=HttpRequest.getResponse(url);
		String result = "";
		try {
			JSONObject j_obj=new JSONObject(response);
			JSONArray arr_weather = j_obj.getJSONArray("weather");
			JSONObject j_main=j_obj.getJSONObject("main");
			JSONObject j_wind=j_obj.getJSONObject("wind");
			JSONObject j_weather=arr_weather.getJSONObject(0);
			String s_weather=j_weather.getString("main");
			double temp=j_main.getDouble("temp");
			double v_wind=j_wind.getDouble("speed");
			result+="weather:"+s_weather+"\ttemperature:"+temp+"\twind:"+v_wind;
			/*JSONObject temp=j_object.getJSONObject("temp");
			result+=temp.toString();*/
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getByCoordinates(double lat,double lon)
	{
		String url="http://api.openweathermap.org/data/2.5/weather?"
				+ "lat="+lat+"&lon="+lon+"&appid=d2ebba8d69c3d7d3c431dc63aa2fca35&units=imperial";
			
		String response=HttpRequest.getResponse(url);
		String result = "";
		try {
			JSONObject j_obj=new JSONObject(response);
			JSONArray arr_weather = j_obj.getJSONArray("weather");
			JSONObject j_main=j_obj.getJSONObject("main");
			JSONObject j_wind=j_obj.getJSONObject("wind");
			JSONObject j_weather=arr_weather.getJSONObject(0);
			String s_weather=j_weather.getString("main");
			double temp=j_main.getDouble("temp");
			double v_wind=j_wind.getDouble("speed");
			result+="weather:"+s_weather+"\ttemperature:"+temp+"\twind:"+v_wind;
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
		System.out.println(getByPost("90007"));
		System.out.println(getByCoordinates(34.034703,-118.287357));
	}
}
