package uk.ac.soton.flavorfusion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherAPI {
  static String apiKey = "73af00dfcb1d4c3f9ca123723241603";
  static StringBuffer response;
  static JSONObject jsonResult;
//  float temperature;
//  float feels_like;
//  String condition;
//  int humidity;
//  App app;

/*  public WeatherAPI(App app)
  {
    this.app = app;
  }*/

  public static String getURLString(String location)
  {
    return "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location + "&aqi=no";
  }

  /**
   * @param location the String of the city name, e.g. London, or Postcode, e.g. SO163FY
   */
  public static WeatherData query(String location)
  {
    String urlString = getURLString(location.replaceAll(" ", ""));

    try {
      URL url = new URL(urlString);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      int responseCode = conn.getResponseCode();
      if (responseCode != 200) {
        throw new RuntimeException("HttpResponseCode: " + responseCode); //TODO: error handling
      } else {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();

        // print response
        //System.out.println(response.toString());
        // analyse JSON response
        jsonResult = new JSONObject(response.toString());

        // print relevant weather data
        float temperature = jsonResult.getJSONObject("current").getFloat("temp_c");
        //float feels_like = jsonResult.getJSONObject("current").getFloat("feelslike_c");
        String condition = jsonResult.getJSONObject("current").getJSONObject("condition").getString("text");
        float uvIndex = jsonResult.getJSONObject("current").getFloat("uv");
        float windSpeed = jsonResult.getJSONObject("current").getFloat("wind_kph");
        float precipitation = jsonResult.getJSONObject("current").getFloat("precip_mm");
        float visibility = jsonResult.getJSONObject("current").getFloat("vis_km");
        int daynight = jsonResult.getJSONObject("current").getInt("is_day");
        int cloud = jsonResult.getJSONObject("current").getInt("cloud");
        int humidity = jsonResult.getJSONObject("current").getInt("humidity");
        float pressure = jsonResult.getJSONObject("current").getInt("pressure_in");

        return new WeatherData(temperature, humidity, pressure, uvIndex, condition, windSpeed, precipitation, visibility, daynight, cloud);

        //System.out.println("Current temperature in " + location + " is: " + temperature + "°C");
        //System.out.println("Current temperature feels like " + feels_like + "°C");
        //System.out.println("Current humidity is " + humidity);
        //System.out.println("Weather condition: " + condition);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    WeatherAPI.query("SO163FY");
  }
}

