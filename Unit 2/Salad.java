public class Salad{
  private Food ingredient1, ingredient2, ingredient3, ingredient4;

  public Salad(){
    this.ingredient1 = new Food();
    this.ingredient2 = new Food(50, 2, "Tomatoes");
    this.ingredient3 = new Food(40, 1, "Olives");
    this.ingredient4 = new Food(60, 1, "Onion");
  }

  public Salad(Food i1, Food i2, Food i3, Food i4){
    this.ingredient1 = i1;
    this.ingredient2 = i2;
    this.ingredient3 = i3;
    this.ingredient4 = i4;
  }

  public Food geti1(){return ingredient1;}
  public Food geti2(){return ingredient2;}
  public Food geti3(){return ingredient3;}
  public Food geti4(){return ingredient4;}

  public void seti1(Food x){this.ingredient1 = x;}
  public void seti2(Food x){this.ingredient2 = x;}
  public void seti3(Food x){this.ingredient3 = x;}
  public void seti4(Food x){this.ingredient4 = x;}

  public static void getCalories(){}

  public String toString(){
    return ingredient1.getName() + " " + ingredient2.getName()+ " " +ingredient3.getName() + " " +ingredient4.getName()
    + "  Total calories: " + (ingredient1.getCalories()*ingredient1.getServing() + ingredient2.getCalories()*
    ingredient2.getServing() + ingredient3.getCalories()* ingredient3.getServing() +
    ingredient4.getCalories()*ingredient4.getServing());
  }
}
