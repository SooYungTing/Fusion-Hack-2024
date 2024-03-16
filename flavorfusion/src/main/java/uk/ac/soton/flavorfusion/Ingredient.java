package uk.ac.soton.flavorfusion;

class Ingredient {

  String name;
  String measure;

  public Ingredient(String name, String measure) {
    this.name = name;
    this.measure = measure;
  }

  public String toString() {
    return "Ingredient[name=" + name + ",measure" + measure;
  }
}
