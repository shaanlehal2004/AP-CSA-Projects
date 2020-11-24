/**
Song (#5 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Song{
  private String artist;
  private String title;

  public Song(String a, String t){
    artist = a;
    title = t;
  }

  public String getArtist(){return artist;}
  public String getTitle(){return title;}

  /**
  * returns the string representation of the song
  * @return the song in string form
  */
  public String toString(){
    return title + " by: " + artist;
  }

}
