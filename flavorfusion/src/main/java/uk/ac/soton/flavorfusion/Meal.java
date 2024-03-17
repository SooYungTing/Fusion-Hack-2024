package uk.ac.soton.flavorfusion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

class Meal {

  String id;
  String name;
  String category;
  String instructions;
  ArrayList<Ingredient> ingredients;
  URL imageAddress;

  /**
   * data returned when searching by meal name or id
   */
  public Meal(String id, String name, String category, String instructions) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.instructions = instructions;
    ingredients = new ArrayList<>();
  }

  /**
   * data returned when searching by category type
   */
  public Meal(String id, String name, String category) {
    this.id = id;
    this.name = name;
    this.category = category;
    ingredients = new ArrayList<>();
  }

  public void setURL(String urlAddress) {
    try
    {

    }catch (MalformedURLException e)
    this.imageAddress = new URL(urlAddress);
  }

  public void addIngredient(Ingredient ig) {
    ingredients.add(ig);
  }

  public String toString() {
    return "meal[id=" + id + ",name=" + name + ",category=" + category + ",instructions="
        + instructions + ",ingredients=" + ingredients;
  }
}
