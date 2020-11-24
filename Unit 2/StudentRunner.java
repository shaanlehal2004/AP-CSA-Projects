public class StudentRunner{
  public static void main(String args[]){
    Student Student1 = new Student("Joey", 1234556, 2019);
    Student Student2 = new Student("Aneesh", 678910, 2021);
    System.out.println(Student1.getName());
    System.out.println(Student1.getID());
    System.out.println(Student1.getYear());

    System.out.println(Student2.getName());
    System.out.println(Student2.getID());
    System.out.println(Student2.getYear());
    System.out.println(Student1.willGraduateTogether(Student2));
  }



}
