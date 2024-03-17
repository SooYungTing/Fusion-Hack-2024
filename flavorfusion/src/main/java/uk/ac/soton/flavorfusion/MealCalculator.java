package uk.ac.soton.flavorfusion;

import java.util.ArrayList;

public class MealCalculator
{
/*  App app;
  public MealCalculator(App app)
  {
    this.app = app;
  }*/
  public static void main(String[] args){
    //App app = new App();
    //MealCalculator m = new MealCalculator();
    //WeatherAPI weather = new WeatherAPI();

    //weather.query("SO163FY");
    //weather.query("SO173AX");    //594186912
    //weather.query("Beijing");    //65193554
    MealCalculator.getMeal(WeatherAPI.query("Shanghai"));

    MealCalculator.getMeal(WeatherAPI.query("Beijing"));

    MealCalculator.getMeal(WeatherAPI.query("London"));

    MealCalculator.getMeal(WeatherAPI.query("SO163FY"));
    //weather.query("Paris");//1686825089
    //app.mealAPI.calMealCategory(weather);
  }

  /**
   * call app.mealAPI.query before calling this function
   * @return
   */
  public static Meal getMeal(WeatherData data)
  {
    if (data == null) return null;
    ArrayList<Category> categories = MealAPI.listCategories();

    int categoryIndex = 17;
    categoryIndex *= (data.temperature + 1);
    categoryIndex *= (data.weatherCondition.hashCode() % 10 + 1);
    categoryIndex *= (data.humidity + 1);
    categoryIndex *= (data.uvIndex + 1);
    if (data.daynight > 1) categoryIndex *= -1;
    categoryIndex *= (data.windSpeed + 1);
    categoryIndex *= (data.precipitation + 1);
    categoryIndex = categoryIndex >> 5;

    ArrayList<Meal> meals = MealAPI.searchByCategory(categories.get(categoryIndex % categories.size()).name);
    int mealIndex = (int) ((data.visibility + 1) * (data.cloud + 1));
    Meal meal = meals.get(mealIndex % meals.size());
    Meal result = MealAPI.searchByID(meal.id).get(0);
    //System.out.println("meals:" + meals);
    System.out.println("result:" + result);
    return result;
  }
}
