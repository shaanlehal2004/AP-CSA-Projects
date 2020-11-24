/**
* Team (#9 on the PSet)
* @author MonicaChan
* @version 1.0
*/
import java.util.ArrayList;


public class Team{
  private String name;
  private ArrayList<Game> games;

  public Team(String name){
    games = new ArrayList<Game>();
    this.name = name;
  }

  public String getName(){return name;}

  /**
  * adds a Game to the list of games.
  * @param g is the game to add
  */
  public void addGame(Game g){
    games.add(g);
  }

  /**
  *returns the number of wins that the team has. This can be calculated using
  the list of games and comparing the scores of the host and guest team.
  * @return the wins a team has.
  */
  public int getNumWins(){
    int numWins = 0;
    for(int i = 0; i < games.size(); i++){
      Game g = games.get(i);
      if(g.getHost().getName().equals(this.getName())){
        if(g.result() == 1)
          numWins++;
      }
      else if(g.getGuest().getName().equals(this.getName())){
        if(g.result() == -1)
          numWins++;
      }
    }
    return numWins;
  }

  /**
  * shows the name of the team and all the games that were played.
  @return the string representation of a team and its stats.
  */
  public String toString(){
    String returnString = name;
    for(int i = 0; i < games.size(); i++){
      returnString += "\n " + games.get(i).toString() + "\n";
    }
    return returnString;
  }


}
