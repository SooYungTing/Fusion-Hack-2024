package uk.ac.soton.flavorfusion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherAPI {

  public static void main(String[] args) {
    // 替换 YOUR_API_KEY 为你的API密钥
    String apiKey = "73af00dfcb1d4c3f9ca123723241603";
    // 指定查询的城市
    String location = "SO163FY";
    // 构建请求URL
    String urlString = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location + "&aqi=no";

    try {
      URL url = new URL(urlString);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      int responseCode = conn.getResponseCode();
      if (responseCode != 200) {
        throw new RuntimeException("HttpResponseCode: " + responseCode);
      } else {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();

        // 打印整个响应内容
        System.out.println(response.toString());

        // 解析JSON响应
        JSONObject jsonObject = new JSONObject(response.toString());

        // 获取并打印特定的天气信息
        Float temperature = jsonObject.getJSONObject("current").getFloat("temp_c");
        String conditionText = jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");

        System.out.println("Current temperature in " + location + " is: " + temperature + "°C");
        System.out.println("Weather condition: " + conditionText);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

