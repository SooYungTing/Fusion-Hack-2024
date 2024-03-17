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

  public String getIngredientsHTML()
  {
    StringBuilder sb = new StringBuilder("<ol>");
    for (Ingredient in : ingredients)
    {
      sb.append("<li>");
      sb.append(in.name + " <i>" + in.measure + "</i>");
      sb.append("</li>");
    }
    sb.append("</ol>");
    return sb.toString();
  }

  public String generateHtmlTable()
  {
    StringBuilder tableHtml = new StringBuilder();
    tableHtml.append("<table border='1'><tr><th>Name</th><th>Measure</th></tr>");
    for (Ingredient ingredient : ingredients) {
      tableHtml.append(String.format("<tr><td>%s</td><td>%s</td></tr>", ingredient.name, ingredient.measure));
    }
    tableHtml.append("</table>");
    return tableHtml.toString();
  }
}
