public class Food{
  private int caloriesPerS, serving;
  private String name;
  public Food(int c, int s, String n){
    this.caloriesPerS = c;
    this.serving = s;
    this.name = n;
  }

  public Food(){
    this.caloriesPerS = 200;
    this.name = "Lettuce";
    this.serving = 1;
  }
  public int getCalories(){return caloriesPerS;}
  public String getName(){return name;}
  public int getServing(){return serving;}
}
