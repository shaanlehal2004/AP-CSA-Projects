/**
* Game (#9 on the PSet)
* @author MonicaChan
* @version 1.0
*/
public class Game{
  private Team host;
  private Team guest;
  private int hostScore;
  private int guestScore;

  private static int gamesPlayed;

  public Game(Team h, Team g, int hScore, int gScore){
    host = h;
    guest = g;
    hostScore = hScore;
    guestScore = gScore;
    gamesPlayed++;
  }

  public Team getHost(){return host;};
  public Team getGuest(){return guest;}

  /**
  * returns the total number of games that were played.
  * @return the games played.
  */
  public static int getNumGames(){return gamesPlayed;}

  /**
  *returns a positive number if the host team won and a negative number if the
  guest team won, and 0 if they tied.
  * @return the integer representation of the score outcome.
  */
  public int result(){
    if(hostScore > guestScore){
      return 1;
    }
    else if(hostScore < guestScore)
      return -1;
    else
      return 0;
  }

  /**
  *shows the host, the guest, and the scores
  * @return string representation of the game. 
  */
  public String toString(){
    String returnString = "Host: " + host.getName() + " scored: " + hostScore + "\n"
                          + "Guest: " + guest.getName() + " scored: " + guestScore;
    return returnString;
  }

}
