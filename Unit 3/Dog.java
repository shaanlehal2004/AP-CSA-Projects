/*
Write the class skeletons. In other words, define the fields, the constructors,
the accessors and modifiers, as needed, and some other methods. There is no need
to write the content of the other methods as this is not the goal of the exercise.
*/

public class Dog{
  private int age;
  private String color, species;

  public Dog(String s, int a, String c){
    species = s;
    age = a;
    color = c;
  }

  public int getAge(){return age;}
  public String getColor(){return color;}
  public String getSpecies(){return species;}

  public void setAge(int newAge){age = newAge;}
  public void setColor(String newColor){color = newColor;}
  public void setSpecies(String newSpecies){species = newSpecies;}

  public boolean isOld(Dog a){
    if(age < 3){
      return true;
    }
    return false;
  }

  public String toString(){
    return "Dog of type " + species + " is " + age + " years old and is colored " + color + ".";
  }



}
