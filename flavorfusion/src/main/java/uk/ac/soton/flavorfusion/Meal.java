package uk.ac.soton.flavorfusion;

import java.util.ArrayList;

class Meal {

  String id;
  String name;
  String category;
  String instructions;
  ArrayList<Ingredient> ingredients;

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

  public void addIngredient(Ingredient ig) {
    ingredients.add(ig);
  }

  public String toString() {
    return "meal[id=" + id + ",name=" + name + ",category=" + category + ",instructions="
        + instructions + ",ingredients=" + ingredients;
  }
}
