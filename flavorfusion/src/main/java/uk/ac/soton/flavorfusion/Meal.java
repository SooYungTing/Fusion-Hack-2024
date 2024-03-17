package uk.ac.soton.flavorfusion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Meal {

  public String id;
  public String name;
  public String category;
  public String instructions;
  public ArrayList<Ingredient> ingredients;
  public URL imageAddress;

  /**
   * data returned when searching by meal name or id
   */
  public Meal(String id, String name, String category, String instructions, String imageURL) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.instructions = instructions;
    try {
      imageAddress = new URL(imageURL);
      System.out.println("imageAddress success! URL: " + imageAddress);
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
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
      this.imageAddress = new URL(urlAddress);
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
      return;
    }
  }

  public void addIngredient(Ingredient ig) {
    ingredients.add(ig);
  }

  public String toString() {
    return "meal[id=" + id + ",name=" + name + ",category=" + category + ",instructions="
        + instructions + ",ingredients=" + ingredients;
  }
}
