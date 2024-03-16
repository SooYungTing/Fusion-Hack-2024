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
    app.weatherAPI.query("Shanghai");
    app.mealCalculator.getMeal();

    app.weatherAPI.query("Beijing");
    app.mealCalculator.getMeal();

    app.weatherAPI.query("London");
    app.mealCalculator.getMeal();

    app.weatherAPI.query("SO163FY");
    app.mealCalculator.getMeal();
    //weather.query("Paris");//1686825089
    //app.mealAPI.calMealCategory(weather);
  }

  Meal getMeal()
  {
    ArrayList<Category> categories = app.mealAPI.listCategories();

    int categoryIndex = 17;
    categoryIndex += app.weatherAPI.temperature;
    categoryIndex += categoryIndex + app.weatherAPI.condition.hashCode();
    categoryIndex += app.weatherAPI.humidity;
    categoryIndex = categoryIndex >> 5;
    categoryIndex = categoryIndex % categories.size();

    ArrayList<Meal> meals = app.mealAPI.searchByCategory(categories.get(categoryIndex).name);
    int mealIndex = (int) (app.weatherAPI.feels_like * app.weatherAPI.humidity);
    Meal meal = meals.get(mealIndex % meals.size());
    Meal result = app.mealAPI.searchByID(meal.id).get(0);
    //System.out.println("meals:" + meals);
    System.out.println("result:" + result);
    return result;
  }
}
