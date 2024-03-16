package uk.ac.soton.flavorfusion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherAPI {
  String apiKey = "73af00dfcb1d4c3f9ca123723241603";
  StringBuffer response;
  JSONObject jsonResult;
  float temperature;
  String condition;
  int humidity;

  String getURLString(String location)
  {
    return "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location + "&aqi=no";
  }

  /**
   * @param location the String of the city name, e.g. London, or Postcode, e.g. SO163FY
   */
  public void query(String location)
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
        System.out.println(response.toString());
        // analyse JSON response
        jsonResult = new JSONObject(response.toString());

        // print relevant weather data
        temperature = jsonResult.getJSONObject("current").getFloat("temp_c");
        condition = jsonResult.getJSONObject("current").getJSONObject("condition").getString("text");
        humidity = jsonResult.getJSONObject("current").getInt("humidity");

        System.out.println("Current temperature in " + location + " is: " + temperature + "°C");
        System.out.println("Current humidity is " + humidity);
        System.out.println("Weather condition: " + condition);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new WeatherAPI().query("SO163FY");
  }
}

