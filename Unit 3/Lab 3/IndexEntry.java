/**
* Index Entry
* @author MonicaChan
* @version 1.0
*/

import java.util.ArrayList;

public class IndexEntry{
  private String word;
  private ArrayList<Integer> wordOccur;

  public IndexEntry(String w){
    word = w.toUpperCase();
    wordOccur = new ArrayList<Integer>();
  }

  /**
  *adds a given number to the line number list if the line number is not already there.
  I use a foreach loop to test if the number of the entry already exists, and if
  it does, the code won't add in the number into the entry again.
  * @param num is the number to add into the entry.
  */
  public void add(int num){
    boolean notThere = true;
    //this condition helps so that if there is a repeat in the same line, the number won't be added into the entry again
    for(int i : wordOccur){
      if(i == num){
        notThere = false;
        break;
      }
    }
    if(notThere == true){
      wordOccur.add(num);
    }
  }

  //accessors
  public String getWord(){return word;}
  public ArrayList<Integer> getLineNumbers(){return wordOccur;}

  /**
  *returns a string representation of the entry.
  * @return the string representation.
  */
  public String toString(){
    String returnString = word + " ";
    for(int i = 0; i < getLineNumbers().size()-1; i++){
      returnString += getLineNumbers().get(i) + ", ";
    }
    returnString += getLineNumbers().get(wordOccur.size()-1);
    return returnString;
  }

}
