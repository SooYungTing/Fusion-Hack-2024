package uk.ac.soton.flavorfusion;

class Category {

  String id;
  String name;

  public Category(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String toString() {
    return "Category[id=" + id + ",name=" + name + "]";
  }
}
