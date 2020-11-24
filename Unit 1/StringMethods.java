public class StringMethods{
  /**
 * Finds the first instance of s in line,
 * starting at the position start.
 * @param o The original string.
 * @param s The string to find.
 * @param start The position to start searching, guaranteed to be in
 * the string line (precondition).
 * @return The index of the first single instance of s if the string
 * is found or -1 if the string is not found.
 */
public static int findString(String o, String s, int start)
{
  //take the substring when it starts, then finds the index of the target string.
  int occurrence = (o.substring(start)).indexOf(s);

  if(occurrence == -1)
    return occurrence;
  else{
    return (occurrence + start);
  }
}

/**
 * Count the number of times instances of s appear in the line.
 * @param o The original string.
 * @param s The string to find.
 * @return The number of times the string appears in the line.
 */
public static int countString(String o, String s)
{
  //can't have the substring if the target string is shorter than the original.
  if(o.length()<s.length()){
    return 0;
  }

  //call the countString function again to see if there are more instances of the target string in the substring.
  else if (o.indexOf(s) != - 1){
    //call it on the substring after the substring.
    return 1 + countString(o.substring(o.indexOf(s) + s.length()-1), s);
  }
  else{
    return 0;
  }
}

/**
 * Replace all instances of underscores in the line by italic tags.
 * There must be an even number of underscores in the line, and they
 * will be replaced by alternating <I> </I>.
 * @param line A string with 0 or more underscores.
 * @return The line where the underscores were replaced with <I> </I>
 * tags or the original line if there are not an even number of
 * underscores.
 * Examples:
 * line: “This is _very_ good.”
 * return: “This is <I>very</I> good.”
 * line: “_This_ is _very_ _good_.”
 * return: “<I>This</I> is <I>very</I> <I>good</I>.”
 * line: “This is _very good.”
 * return: “This is _very good.”
 * line: “This is __very good.”
 * return: “This is <I></I>very good.”
 */
public static String convertItalics(String line)
{

  //counter to see if the underscore is an even or odd one. Start at one because the first italics should be <I>
  int counter = 1;
  //counts the number of italics in the string
  int italCounter = 0;

  //increments the italCounter
  for(int i = 0; i < line.length(); i++){
    if(line.charAt(i) == '_')
      italCounter++;
  }

  //puts in the italics into the string.
  for(int i = 0; i < line.length(); i++){
    //only put italics if the number of underscores is even.
    if(line.charAt(i) == '_'){
      if(italCounter % 2 == 0 && italCounter != 0){
        String lineBegin = line.substring(0, i);
        String lineEnd = line.substring(i+1);
        //if the italic number is even.
        if(counter % 2 == 0){
          String endItal = "</I>";
          line = lineBegin + endItal + lineEnd;

          counter++;
        }
        //if the italic number is odd.
        else{
          String beginItal = "<I>";
          line = lineBegin + beginItal + lineEnd;
          counter++;
      }
    }
    }
  }

  return line;
}


public static void main(String args[]){
System.out.println("findString tests:");
System.out.println(findString("asdasdasdasd", "asd", 1));
System.out.println(findString("submarine", "z", 3));
System.out.println(findString("controlololol", "lol", 7));
System.out.println();

System.out.println("countString tests:");
System.out.println(countString("eggseggs", "eggs"));
System.out.println(countString("hellohowareyoutoday", " hi"));
System.out.println(countString("baconbaconbaconbaco", "on"));
System.out.println();

System.out.println("convertItalics tests:");
System.out.println(convertItalics("Hello ___"));
System.out.println(convertItalics("I _am_happy today"));
System.out.println(convertItalics("I __am tired today"));
System.out.println();

}

}
