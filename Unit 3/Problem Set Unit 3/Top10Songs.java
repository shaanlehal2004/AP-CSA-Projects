/**
TopTenSongs (#5 on Pset)
* @author MonicaChan
* @version 1.0
*/
import java.util.ArrayList;
public class Top10Songs{
  private Song[] songs;
  public Top10Songs(){
    songs = new Song[10];
  }

  /**
  * returns song at a particular index
  * @param i is the index
  * @return song at that index i
  */
  public Song getSong(int i){return songs[i-1];}

  /**
  *This method places the song in the first available slot and returns true.
  If all slots are taken, it does not place the song and returns false.
  * @param s is the song to add to the list.
  * @return true if the song was added successfully, false otherwise.
  */
  public boolean add(Song s){
    for(int i = 0; i < songs.length; i++){
      if(songs[i] == null){
        songs[i] = s;
        return true;
      }
    }
    return false;
  }


/**
*This method should place the Song parameter at the given index and then bump
all other songs down accordingly. The last song which gets bumped from the list
should be returned.
* @param s is the song to add to the list
* @param index is the index to add to.
* @param song that gets bumped off the list, null if no song was bumped.
*/
public Song add(Song s, int index){
  index--;
  Song temp = songs[index];
  Song returnSong = null;

  if(songs[index] == null){
    songs[index] = s;
    return null;
  }
  int spaceIndex = index;
  boolean emptySpace = false;
  while(emptySpace == false && spaceIndex < 10){
    if(songs[spaceIndex] == null)
      emptySpace = true;
    else
      spaceIndex++;
  }
  if(spaceIndex == 10){
    returnSong = songs[9];
    songs[9] = null;
    spaceIndex = 9;
  }
  Song temp2;
  for(int i = index+1; i <= spaceIndex; i++){
    //System.out.println("Song: " + temp);
    temp2 = songs[i];
    songs[i] = temp;
    temp = temp2;
  }
  songs[index] = s;
  return returnSong;

}

/**
* Returns the string representation of the playlist.
* @return string form of list.
*/
  public String toString(){
    int count = 1;
    String returnString = "";
    for(int i = 0 ; i<songs.length; i++){
      if(songs[i] == null){
        returnString += count + " Empty song \n";
        count++;
      }
      else{
      returnString += count + " " + songs[i].getTitle() + ", " + songs[i].getArtist()+ " \n";
      count++;
      }
    }
    return returnString;
  }

}
