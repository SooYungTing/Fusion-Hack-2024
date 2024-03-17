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
    //MealCalculator m = new MealCalculator();
    //WeatherAPI weather = new WeatherAPI();

    //weather.query("SO163FY");
    //weather.query("SO173AX");    //594186912
    //weather.query("Beijing");    //65193554
    app.mealCalculator.getMeal(app.weatherAPI.query("Shanghai"));

    app.mealCalculator.getMeal(app.weatherAPI.query("Beijing"));

    app.mealCalculator.getMeal(app.weatherAPI.query("London"));

    app.mealCalculator.getMeal(app.weatherAPI.query("SO163FY"));
    //weather.query("Paris");//1686825089
    //app.mealAPI.calMealCategory(weather);
  }

  /**
   * call app.mealAPI.query before calling this function
   * @return
   */
  Meal getMeal(WeatherData data)
  {
    if (data == null) return null;
    ArrayList<Category> categories = app.mealAPI.listCategories();

    int categoryIndex = 17;
    categoryIndex += data.temperature;
    categoryIndex += categoryIndex + data.weatherCondition.hashCode();
    categoryIndex += data.humidity;
    categoryIndex = categoryIndex >> 5;
    categoryIndex = categoryIndex % categories.size();
    categoryIndex *= data.uvIndex;
    if (data.daynight > 1) categoryIndex *= -1;
    categoryIndex *= (Math.pow(data.windSpeed, 2) + 1);
    categoryIndex /= (data.precipitation + 1);

    ArrayList<Meal> meals = app.mealAPI.searchByCategory(categories.get(categoryIndex % categories.size()).name);
    int mealIndex = (int) (data.visibility * (data.cloud + 1));
    Meal meal = meals.get(mealIndex % meals.size());
    Meal result = app.mealAPI.searchByID(meal.id).get(0);
    //System.out.println("meals:" + meals);
    System.out.println("result:" + result);
    return result;
  }
}
