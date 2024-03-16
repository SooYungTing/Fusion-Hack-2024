package uk.ac.soton.flavorfusion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MealAPI {
  App app;
  String searchByName= "https://www.themealdb.com/api/json/v1/1/search.php?s=";
  String searchByID= "https://www.themealdb.com/api/json/v1/1/lookup.php?i=";
  String filterByIngredient= "https://www.themealdb.com/api/json/v1/1/filter.php?i=";
  String searchByCategory="https://www.themealdb.com/api/json/v1/1/filter.php?c=";
  StringBuffer response;
  JSONObject jsonResult;

  public MealAPI(App app)
  {
    this.app = app;
  }

  public ArrayList<Category> listCategories()
  {
    ArrayList<Category> categoriesFound = new ArrayList<>();
    try {
      URL url = new URL("https://www.themealdb.com/api/json/v1/1/categories.php");
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
        //System.out.println(response.toString());
        // analyse JSON response
        jsonResult = new JSONObject(response.toString());

        JSONArray categories = jsonResult.getJSONArray("categories");
        for (int i = 0; i < categories.length(); i++) {
          JSONObject category = categories.getJSONObject(i);
          String idCategory = category.getString("idCategory");
          String strCategory = category.getString("strCategory");
          categoriesFound.add(new Category(idCategory, strCategory));
          //System.out.println("ID: " + idCategory + ", Name: " + strCategory);
        }
        //System.out.println("--------------------");

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    //System.out.println(categoriesFound);
    return categoriesFound;
  }

  public ArrayList<Meal> searchByID(String ID) {
    return searchByIDOrName(searchByID + ID);
  }

  public ArrayList<Meal> searchByName(String name) {
    return searchByIDOrName(searchByName + name);
  }

  public ArrayList<Meal> searchByCategory(String category)
  {
    ArrayList<Meal> mealsFound = new ArrayList<>();
    try {
      URL url = new URL(searchByCategory + category);
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
        //System.out.println(response.toString());
        // analyse JSON response
        jsonResult = new JSONObject(response.toString());

        JSONArray meals = jsonResult.getJSONArray("meals");

        for (int i = 0; i < meals.length(); i++) {
          JSONObject meal = meals.getJSONObject(i);
          String idMeal = meal.getString("idMeal");
          String strMeal = meal.getString("strMeal");

          mealsFound.add(new Meal(idMeal, strMeal, category));
          //System.out.println("Meal ID: " + idMeal + ", Meal Name: " + strMeal);
        }
        //System.out.println("--------------------");
        }
      } catch (Exception e) {
      e.printStackTrace();
    }
    //System.out.println(mealsFound);
    return mealsFound;
  }

  public ArrayList<Meal> searchByIDOrName(String urlString)
  {
    ArrayList<Meal> mealsFound = new ArrayList<>();
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
        //System.out.println(response.toString());
        // analyse JSON response
        jsonResult = new JSONObject(response.toString());

        JSONArray meals = jsonResult.getJSONArray("meals");

        for (int i = 0; i < meals.length(); i++) {
          JSONObject meal = meals.getJSONObject(i);
          String idMeal = meal.getString("idMeal");
          String strMeal = meal.getString("strMeal");
          String strCategory = meal.getString("strCategory");
          String strInstructions = meal.getString("strInstructions");

          Meal mealObj = new Meal(idMeal, strMeal, strCategory, strInstructions);

          //System.out.println("Meal ID: " + idMeal);
          //System.out.println("Meal Name: " + strMeal);
          //System.out.println("Category: " + strCategory);
          //System.out.println("Cooking Steps: " + strInstructions);

          //System.out.println("Ingredients and Amounts:");
          for (int j = 1; j <= 20; j++) {
            String ingredientKey = "strIngredient" + j;
            String measureKey = "strMeasure" + j;
            if (meal.has(ingredientKey) && !meal.isNull(ingredientKey) && !meal.getString(ingredientKey).isEmpty()) {
              String ingredient = meal.getString(ingredientKey);
              String measure = meal.getString(measureKey);
              mealObj.addIngredient(new Ingredient(ingredient, measure));
              //System.out.println(ingredient + ": " + measure);
            }
          }
          mealsFound.add(mealObj);
          //System.out.println("--------------------");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    //System.out.println(mealsFound);
    return mealsFound;
  }

/*  Meal getMeal(WeatherData weatherData)
  {
    int index = new MealCalculator().calMealCategory(new WeatherAPI());
    Category category = listCategories().get(index);
    ArrayList<Meal> meals = searchByCategory(category.name);
  }*/

  public static void main(String[] args) {
    App app = new App();
    app.mealAPI.searchByName("Teriyaki Chicken Casserole");
    app.mealAPI.searchByID("52772");
    app.mealAPI.listCategories();
    app.mealAPI.searchByCategory("Beef");
  }
}

