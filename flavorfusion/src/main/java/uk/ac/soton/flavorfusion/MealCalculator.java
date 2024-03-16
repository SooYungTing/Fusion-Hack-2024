package uk.ac.soton.flavorfusion;

public class MealCalculator {

  public static void main(String[] args){
    MealCalculator m = new MealCalculator();
    WeatherAPI weather = new WeatherAPI();
    //weather.query("SO163FY");
    //weather.query("SO173AX");    //594186912
    //weather.query("Beijing");    //65193554
    weather.query("Shanghai");
    //weather.query("Paris");//1686825089
    m.calMealCategory(weather);
  }


  public int calMealCategory(WeatherAPI now){
    int result = 17;
    result += now.temperature;
    result += result + now.condition.hashCode();
    result += now.humidity;
    result = result >> 5;
    result = result % 14;

    result = result == 0 ? 1 : result;
    System.out.println(result);
    return result;
  }

  public int calMealIndex(){
    return 1;
  }
}
