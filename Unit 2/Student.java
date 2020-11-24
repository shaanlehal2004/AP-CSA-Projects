//name, ID, Year,
//methods constructors accessors modifiers willGraduateTogether

public class Student{
  private int id, year;
  private String name;


  public Student(String n, int id, int year){
    this.name = n;
    this.id = id;
    this.year = year;
  }

  public String getName() {return name;}
  public int getID() {return id;}
  public int getYear() {return year;}

  public boolean willGraduateTogether(Student b){
    if(this.getYear() == b.getYear())
      return true;
    return false;
  }
}
