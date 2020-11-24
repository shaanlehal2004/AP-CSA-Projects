public class SaladRunner{
  public static void main(String args[]){
    Food anchovy = new Food(50, 1, "Anchovy");
    Food lettuce = new Food(100, 1, "Lettuce");
    Food vinegar = new Food(20, 2, "vinegar");
    Food potato = new Food(70, 1, "potato");

    Salad newSalad = new Salad(anchovy, lettuce, vinegar, potato);
    String returnString = newSalad.toString();
    System.out.println(returnString);
  }

}
