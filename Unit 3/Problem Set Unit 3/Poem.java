/**
Poem (#6 on Pset)
* @author MonicaChan
* @version 1.0
*/

public abstract class Poem{
  /**
  *returns the number of lines in the poem
  * @return number of liens.
  */
  public abstract int numLines();

  /**
  *returns the number of syllables on the k-th line.
  * @return int syllables on line k;
  */
  public abstract int getSyllables(int k);

  /**
  * shows the rhythm of the poem.
  * @return the rhythm diagram
  */
  public String printRhythm(){
    int lines = this.numLines();
    String returnString = "";
    for(int i = 1; i <= lines; i++){
      int syllable = this.getSyllables(i);
      for(int o = 1; o < syllable; o++){
        returnString += "ta-";
      }
      returnString += "ta\n";
    }
    return returnString;
  }
}
