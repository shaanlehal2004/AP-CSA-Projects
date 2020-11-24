/**
Operations (#8 on Pset)
* @author MonicaChan
* @version 1.0
*/
import java.util.ArrayList;


public class Operations{
  private ArrayList<Safety> transportOperations;

  public Operations(ArrayList<Safety> t){
    transportOperations = t;
  }

  /**
  * calculates the total revenue of all safe operations.
  * @return the total revenue.
  */
  public double totalRevenue(){
    ArrayList<Safety> safeTransport = this.getSafeOperations();
    double r = 0;
    for(int i = 0; i < safeTransport.size(); i++){
      r += ((Transport)safeTransport.get(i)).revenue();
    }
    return r;
  }
  /**
  * calculates the total revenue of all safe land operations.
  * @return the total land revenue.
  */
  public double totalLandRevenue(){
    ArrayList<Safety> safeTransport = this.getSafeOperations();
    double r = 0;
    for(int i = 0; i < safeTransport.size(); i++){
      if(safeTransport.get(i) instanceof Land){
        r+= ((Transport)safeTransport.get(i)).revenue();
      }
    }
    return r;
  }

  /**
  * calculates the total revenue of all safe air operations.
  * @return the total air revenue.
  */
  public double totalAirRevenue(){
    ArrayList<Safety> safeTransport = this.getSafeOperations();
    double r = 0;
    for(int i = 0; i < safeTransport.size(); i++){
      if(safeTransport.get(i) instanceof Air){
        r += ((Transport)safeTransport.get(i)).revenue();
      }
    }
    return r;
  }

  /**
  * calculates the total revenue of all safe sea operations.
  * @return the total sea revenue. 
  */
  public double totalSeaRevenue(){
    ArrayList<Safety> safeTransport = this.getSafeOperations();
    double r = 0;
    for(int i = 0; i < safeTransport.size(); i++){
      if(safeTransport.get(i) instanceof Sea){
        r += ((Transport)safeTransport.get(i)).revenue();
      }
    }
    return r;
  }

  /**
  *returns an ArrayList<Safety> that only contains the safe operations from
  transportOperations.
  *@return an array list that contains safe operations.
  */
  public ArrayList<Safety> getSafeOperations(){
    ArrayList<Safety> safeTransport = new ArrayList<Safety>();
    for(int i = 0; i < transportOperations.size(); i++){
      if(transportOperations.get(i).checkSafety() == true){
        safeTransport.add(transportOperations.get(i));
      }
    }
    return safeTransport;
  }
}
