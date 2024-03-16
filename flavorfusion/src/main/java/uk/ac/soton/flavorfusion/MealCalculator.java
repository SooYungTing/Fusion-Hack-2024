package uk.ac.soton.flavorfusion;

import java.util.ArrayList;

public class MealCalculator
{
  App app;
  public MealCalculator(App app)
  {
    this.app = app;
  }
  public static void main(String[] args){
    App app = new App();
    app.weatherAPI.query("Shanghai");
    app.mealCalculator.calMealCategory();
    //MealCalculator m = new MealCalculator();
    //WeatherAPI weather = new WeatherAPI();

    //weather.query("SO163FY");
    //weather.query("SO173AX");    //594186912
    //weather.query("Beijing");    //65193554
    app.weatherAPI.query("Shanghai");
    app.mealCalculator.getMeal();
    //weather.query("Paris");//1686825089
    //app.mealAPI.calMealCategory(weather);
  }

  public int calMealCategory()
  {
    int result = 17;
    result += app.weatherAPI.temperature;
    result += result + app.weatherAPI.condition.hashCode();
    result += app.weatherAPI.humidity;
    result = result >> 5;
    result = result % 14;

    result = result == 0 ? 1 : result;
    System.out.println(result);
    return result;
  }

  Meal getMeal()
  {
    int index = calMealCategory();
    Category category = app.mealAPI.listCategories().get(index);
    ArrayList<Meal> meals = app.mealAPI.searchByCategory(category.name);
    //meals.get()
    int index2 = (int) (app.weatherAPI.feels_like * app.weatherAPI.humidity);
    Meal result = meals.get(index2 % meals.size());
    System.out.println("meals:" + meals);
    System.out.println("result:" + result);
    return result;
  }

  public int calMealIndex()
  {
    return 1;
  }
}
