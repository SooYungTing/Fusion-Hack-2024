package uk.ac.soton.flavorfusion;

public class WeatherData
{
  float temperature;
  int humidity;
  String weatherCondition;

  public WeatherData(float temperature, int humidity, String weatherCondition)
  {
    this.temperature = temperature;
    this.humidity = humidity;
    this.weatherCondition = weatherCondition;
  }
}
