import java.util.Scanner;
class ChatbotV2{
  public static void main(String[] args){
    //Create a scanner object to get input from the user
    Scanner keyboard = new Scanner(System.in);
    //Asks user for name
    System.out.print("What is your name? ");
    String name = keyboard.nextLine();

    //Asks user how they are
    System.out.println("Hi " + name + "! How are you doing? ");
    String input = keyboard.nextLine();
    System.out.println("I'm glad that you are " + input);

    //Ask for users age
    System.out.print("How old are you? ");
    int age = keyboard.nextInt();
    keyboard.nextLine();
    String youth = "";
    if(age <= 5){
      youth = "Hi baby, have you eaten yet?";
    }
    else if(age < 25){
      youth = "What school do you go to?";
    }
    else{
      youth = "What college did you go to?";
    }

    System.out.println(youth);
    String response = keyboard.nextLine();
    System.out.println(response + "! Nice!");
    //prompts for topics
    System.out.println("What do you want to talk about?");
    String topic = keyboard.nextLine();

    while (!topic.equals("bye")){ // bye will be command to leave the chat

      //Asks user about weather, upper and lower case accounted.
      if(topic.equals("weather") || topic.equals("Weather")){
        System.out.println("It looks like it might rain today! What's weather like where you are?");
        String theirWeather = keyboard.nextLine();
        System.out.println("Oh I see, it's " + theirWeather + ". That's my favorite kind of weather!");
      }
      // Asks user about music, upper and lower case accounted.
      if(topic.equals("music") || topic.equals("Music")){
        System.out.println("What is your favorite song?");
        String song = keyboard.nextLine();
        System.out.println("Oh " + song + "! I love that song! I also like Imagine Dragons.");
      }
      //Asks user about school, upper and lower case accounted.
      if(topic.equals("school") || topic.equals("School")){
        System.out.println("What is your favorite subject?");
        String subject = keyboard.nextLine();
        System.out.println("Wow " + subject + ", that is very interesting! I like Computer Science");
      }
      // Asks user about food, upper and lower case accounted.
      if(topic.equals("food") || topic.equals("Food")){
        System.out.println("What's your favorite restaurant?");
        String restaurant = keyboard.nextLine();
        System.out.println("I've never been to " + restaurant + " I have to try it! My favorite restaurant is McDonalds. What was your most recent meal?");
        String food = keyboard.nextLine();
        System.out.println("Sounds tasty! I'm kind of hungry.");

      }
      //Rerun chat
      System.out.println("What else do you want to talk about?");
      topic = keyboard.nextLine();
    }

  }
}
