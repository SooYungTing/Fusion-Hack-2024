package uk.ac.soton.flavorfusion;

public class MealAPI {

  private final String categoryAPI = "www.themealdb.com/api/json/v1/1/filter.php?c=";
  private final String mealAPI = "www.themealdb.com/api/json/v1/1/lookup.php?i=";

  String getMealURL(String id){
    return categoryAPI + id;
  }

  String getCategoryURL(String category){
    return mealAPI + category;
  }





}
