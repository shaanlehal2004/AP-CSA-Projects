/**
League (#9 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class League{
  private Team[] teams;
  public League(String[] names){
    teams = new Team[names.length];
    for(int i = 0; i < names.length; i++){
      Team a = new Team(names[i]);
      teams[i] = a;
    }
  }
  /**
  * indicates that a game was played in the league. The method should add the
  game to the list of games for both teams involved in the game.
  * @param g is the game being added to the teams' lists.
  */
  public void playGame(Game g){
    Team a = g.getGuest();
    Team b = g.getHost();
    a.addGame(g);
    b.addGame(g);
  }

  /**
  *returns the number of teams in the league.
  * @return the number of teams.
  */
  public int getNumTeams(){
    return teams.length;
  }

  /**
  * returns the Team at a certain index.
  * @param i is the index
  * @return team at index i
  */
  public Team getTeam(int i){
    return teams[i];
  }

  /**
  *Tallies all the games that have been played for all the teams, determines
  which team has the highest number of wins, and returns the Team.
  * @return the champion team
  */
  public Team getChampion(){
    Team mostWins = teams[0];
    for(int i = 1; i < teams.length; i++){
      if(mostWins.getNumWins() < teams[i].getNumWins()){
        mostWins = teams[i];
      }
    }
    return mostWins;
  }

}
