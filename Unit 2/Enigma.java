/**
* @author MonicaChan
* @version 1.0

General approach:
I started by practicing encrypting different messages with the enigma machine
on paper so I could develop the right method of how to approach programming it.
I realized rather quickly that programming it was fairly straightforward and
similar to how you would do it on paper. I then started with the initializeRotors.
the trickiest part was figuring out the math to rotate the rotors. I realized that
you would have to rotate the rotors to the left in order to initialize them, hence
forming the -(s1-32) equation. I tested this and it seemed to work well.
Then I wrote the advanceRotor. Unbeknownst to me, this function was going to be the
ultimate cause of my program not working. I had initially written it so that the
rotors would rotate counter-clockwise instead of clockwise, which was a huge mistake
and the reason why my program was not working initially.
Writing the encrypt was fairly straightforward and I just followed the steps
that a human would take to use enigma machine encryption. Then I tested, and found
that the program would encrypt the first character correctly, and each subsequent character
would be off by a consistent interval of 2 + the previous offset. So the first character
was correct, the second character was 2 ascii values off, the third was 4 ascii values off,
and this would continue until the ascii was 126 or above and wrap around back to 32.
At first I thought my encrypt was wrong, so I consulted my classmates who told me that
my encryption looked exactly like theirs. After a short break, I came back and realized
that I ahd been rotating the rotors the wrong way the whole time!! After I fixed this,
my encryption worked perfectly. I then proceeded to write my decrypt, first starting by
writing out the steps on paper for how I would execute it manually, and then translating
it into code, which worked.

I guess the main lesson for me was to take a break if I'm getting confused or lost, a
fresh mind helps with seeing a problem from a new perspective!! :)
*/

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;



public class Enigma{
  public static ArrayList<Integer> rotor1;
  public static ArrayList<Integer> rotor2;
  public static ArrayList<Integer> backplate;

  public static void main(String args[]){

    if(args.length < 5){
      System.out.println("Sorry, rerun this with 5 or 6 arguments:");
      System.out.println("1 - input file name");
      System.out.println("2 - output file name");
      System.out.println("3 - first rotor start");
      System.out.println("4 - second rotor start");
      System.out.println("5 - back rotor start");
      System.out.println("6 (optional - decrypted message file name)");
    }

    else{
      String inputFilename = args[0];
      String outputFilename = args[1];
      int s1 = Integer.parseInt(args[2]);
      int s2 = Integer.parseInt(args[3]);
      int s3 = Integer.parseInt(args[4]);

      ArrayList<Integer> message = new ArrayList<Integer>(100);
      ArrayList<Integer> encrypted = new ArrayList<Integer>(100);
      initializeRotors(s1,s2,s3);
      readFile(inputFilename, message);
      encryptMessage(message, encrypted);
      writeFile(outputFilename, encrypted);

      //the sixth argument is optional, thought it might be a nice functionality to have.
      if(args.length == 6){
        String verifyFileName = args[5];
        ArrayList<Integer> verify = new ArrayList<Integer>();

        initializeRotors(s1,s2,s3);
        readFile(outputFilename, encrypted);
        decryptMessage(encrypted, verify);
        writeFile(verifyFileName, verify);
      }
    }

  }


  /**
  Initializes the three rotors with the specified starting ASCII values and
  fill in with all the characters with ASCII values from 32 to 126 (clockwise)
  For example if s1 is 35, then rotor 1 will have ASCII values from
  35, 36, 37, …, 126, 32, 33, 34
  General strategy: first add elements into all the array lists so they're not empty.
  Then rotate all the rotors to the left using rotate whatever the initial terminal command amount was.

  Start at 32 end 126 inclusive

  * @param s1 first rotor start ASCII.
  * @param s2 second rotor start ASCII.
  * @param s3 backplate start ASCII.
  */
  public static void initializeRotors(int s1, int s2, int s3){
    rotor1 = new ArrayList<Integer>(95);
    rotor2 = new ArrayList<Integer>(95);
    backplate = new ArrayList<Integer>(95);

    for(int i = 32; i < 127; i++){
      rotor1.add(i);
      rotor2.add(i);
      backplate.add(i);
    }
    rotate(rotor1, s1-32);
    rotate(rotor2, s2-32);
    rotate(backplate, s3-32);
  }


  /**
  This function rotates the elements of an array list one index to the right.
  If it is the last element, that element will get wrapped around to the front of the array.

  General strategy: Run a for loop that iterates through the whole integer array.
  In another for loop, check that if the elmentis the last element in the array list,
  the new index will be 0. Otherwise, the new index is the current index plus one.
  After the if statements, assign the element to its new index of a new array. Then reassign
  all the values back to the original array.

  * @param rotor is the integer array list that is getting shifted.
  */
  public static void advanceRotor(ArrayList<Integer> rotor){
    int newIndex;
    ArrayList<Integer> newA = new ArrayList<Integer>(rotor.size());
    for(int i = 0; i<rotor.size(); i++){
      newA.add(0);
    }
    for(int k = 0; k< rotor.size(); k++){
      //checks to see if the element being checked is the last one of the array.
      if(k == rotor.size()-1)
        newIndex = 0;
      else
        newIndex = k+1;
      //assign the element a new index into the new array.
      newA.set(newIndex, rotor.get(k));
    }

    //copy the new array back into the old one.
    for(int j = 0; j< newA.size(); j++)
      rotor.set(j, newA.get(j));
  }


  /**
  This function encrypts an integer array list of ASCII values and outputs the encryption into another integer array list.

  general strategy: This function takes in an integer array list that contains the ASCII values for
  the message as well as an array list to store the result. The message is
  encrypted using the enigma machine algorithm. First, find the letter you
  want to encrypt on rotor1. Then, find the letter on rotor2
  that is the same as the letter on the backplate at the index of the rotor1 letter.

  * @param in is the array list with the message.
  * @param out is the array list that will contain the encrypted message.
  */
  public static void encryptMessage(ArrayList<Integer> in, ArrayList<Integer> out){
    //letter on the backplate
    int backplateItem;
    //index on the second rotor.
    int secondRotorIndex;
    //index on the first rotor.
    int rotor1Index;

    for(int i = 0; i<in.size(); i++){
        int messageElement = in.get(i);
        rotor1Index= rotor1.indexOf(messageElement);
        backplateItem = backplate.get(rotor1Index);
        secondRotorIndex = rotor2.indexOf(backplateItem);
        backplateItem = backplate.get(secondRotorIndex);
        out.add(backplateItem);
        advanceRotor(rotor1);
        if((i+1) % 95 == 0)
          advanceRotor(rotor2);

    }
  }

  /**
  This function takes in an integer array list that contains the encrypted message ASCII values, decrypts it,
  and stores the decrypted ASCII values in another integer array list.

  General strategy: This function is kind of like a "backwards" version of the encrypt message.
  First, find the index of the letter on the backplate, find the letter at that same
  index on the second rotor, find that letter on the backplate and store the index
  of that letter on the backplate, and then look at which letter is on the first rotor
  of rotor1.

  * @param out is the array list that is encrypted.
  * @param result is the decrypted array list.

  */
  public static void decryptMessage(ArrayList<Integer> out, ArrayList<Integer> result){
    //index of the letter on the backplate.
    int backplateIndex;
    //letter on the second rotor.
    int secondRotorItem;
    // letter on the first rotor.
    int rotorItem;

    for(int i = 0; i<out.size(); i++){
      backplateIndex = backplate.indexOf(out.get(i));
      secondRotorItem = rotor2.get(backplateIndex);
      backplateIndex = backplate.indexOf(secondRotorItem);
      rotorItem = rotor1.get(backplateIndex);
      result.add(rotorItem);
      advanceRotor(rotor1);
      if((i+1) % 95 == 0)
        advanceRotor(rotor2);

    }
  }


  /**
  This function rotates the elements of an array one index to the left.
  If it's the first element, that element will get wrapped around to the end.

  General strategy: run a for loop that iterates through the whole integer array,
  if it's the first element of the array, the new index will be the last index of the array.
  Otherwise, it is just the current index minus one.
  After these if statements, assign the element to its new index of a new array. Then reassign
  all the values back to the original array.

  * @param a the integer array that is getting shifted.
  */

  public static void rotateLeft(ArrayList<Integer> a){
    //newIndex will be the new index of the element.
    int newIndex;
    ArrayList<Integer> newA = new ArrayList<Integer>();
    for(int i = 0; i<a.size(); i++){
      newA.add(0);
    }
    for(int j = 0; j< a.size(); j++){
      //checks to see if the element being checked is the first one of the array.
      if(j == 0)
        newIndex = a.size()-1;
      else
        newIndex = j-1;
      //assign the element a new index into the new array.
      newA.set(newIndex, a.get(j));
    }

    //copy the new array back into the old one.
    for(int k = 0; k< newA.size(); k++)
      a.set(k, newA.get(k));
  }

  /**
  This function rotates the elements of integer array a by d places to the left.
  General strategy: Create a while loop and decrement d until it equals 0,
  and in that loop call the rotateLeft function.
  * @param a is an integer array that is to be shifted.
  * @param d is the integer number of places to shift the array.
  */
  public static void rotate(ArrayList<Integer> a, int d){
      while(d > 0){
        rotateLeft(a);
        d--;
      }
  }


  /**
   * Read a text file and convert the text to a list of ASCII codes
   * @param filename The name of the file to be read
   * @param list The list containing the read text in ASCII code
   */
  public static void readFile(String filename, ArrayList<Integer> list)
  {
    list.clear();
    File file = new File(filename);
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(" Cannot open " + filename );
      System.exit(1);
    }
    while(input.hasNextLine())
    {
      String s = input.nextLine();
      for(int i = 0; i < s.length(); i++)
        list.add((int)s.charAt(i));
    }
  }

  /**
   * Writes an Array List of Integer as a text file
   * @param filename The name of the file to be written out
   * @param list The list to be written into the file
   */
  public static void writeFile(String filename, ArrayList<Integer> list)
  {
    Writer writer = null;
    try
    {
      writer = new FileWriter(filename, false);
    }
    catch (IOException ex)
    {
      System.out.println(" Cannot create/open " + filename );
      System.exit(1);
    }
    PrintWriter output = new PrintWriter(writer);
    for(int i = 0; i < list.size(); i++)
      output.print((char)list.get(i).intValue());
    output.close();
  }


}
