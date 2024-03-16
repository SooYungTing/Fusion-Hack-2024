package uk.ac.soton.flavorfusion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class IngredientAPI {
  String searchByName= "https://www.themealdb.com/api/json/v1/1/search.php?s=";
  String filterByIngredient= "https://www.themealdb.com/api/json/v1/1/filter.php?i=";
  String filterByCategory="https://www.themealdb.com/api/json/v1/1/filter.php?c=";
  StringBuffer response;
  JSONObject jsonResult;

  public void searchByName(String name)
  {
    try {
      URL url = new URL(searchByName + name);
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
        System.out.println(response.toString());
        // analyse JSON response
        jsonResult = new JSONObject(response.toString());

        JSONArray meals = jsonResult.getJSONArray("meals");

        for (int i = 0; i < meals.length(); i++) {
          JSONObject meal = meals.getJSONObject(i);
          String idMeal = meal.getString("idMeal");
          String strMeal = meal.getString("strMeal");
          String strCategory = meal.getString("strCategory");
          String strInstructions = meal.getString("strInstructions");

          System.out.println("Meal ID: " + idMeal);
          System.out.println("Meal Name: " + strMeal);
          System.out.println("Category: " + strCategory);
          System.out.println("Cooking Steps: " + strInstructions);

          System.out.println("Ingredients and Amounts:");
          for (int j = 1; j <= 20; j++) {
            String ingredientKey = "strIngredient" + j;
            String measureKey = "strMeasure" + j;
            if (meal.has(ingredientKey) && !meal.isNull(ingredientKey) && !meal.getString(ingredientKey).isEmpty()) {
              String ingredient = meal.getString(ingredientKey);
              String measure = meal.getString(measureKey);
              System.out.println(ingredient + ": " + measure);
            }
          }
          System.out.println("--------------------");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new IngredientAPI().searchByName("Teriyaki Chicken Casserole".replaceAll(" ", "%20"));
  }
}

