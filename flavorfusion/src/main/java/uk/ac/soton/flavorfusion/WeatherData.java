package uk.ac.soton.flavorfusion;

import java.beans.Visibility;

public class WeatherData
{
  public float temperature;
  public int humidity;
  public float pressure;
  //紫外线等级 国际上从0开始 到11+后无上限了
  public float uvIndex;
  public String weatherCondition;

  //风速: 单位km/h
  public float windSpeed;
  //降水: 单位mm
  public float precipitation;
  //能见度: 单位km
  public float visibility;
  //白天或者黑夜:白天为1 黑夜为0 (api是这么给的)
  public int daynight;
  //白云占天空占百分比 int %
  public int cloud;

  public WeatherData(float temperature, int humidity, float pressure, float uvIndex,
      String weatherCondition, float windSpeed, float precipitation, float visibility, int daynight,
      int cloud) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    this.uvIndex = uvIndex;
    this.weatherCondition = weatherCondition;
    this.windSpeed = windSpeed;
    this.precipitation = precipitation;
    this.visibility = visibility;
    this.daynight = daynight;
    this.cloud = cloud;
  }

/*  public WeatherData(float temperature, int humidity, String weatherCondition)
  {
    this.temperature = temperature;
    this.humidity = humidity;
    this.weatherCondition = weatherCondition;
  }*/
}
