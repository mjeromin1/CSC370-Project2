
import java.util.ArrayList;

/*
 * Wil Luca CSC 370 Operating Systems 1/29/18

Description: The Process class is the class of jobs that will be read into the program
from a TextArea. It has three paramtere name, time, and state which all have getter and 
setter methods. There is a toString method to display the information of each proces. 
The class also contains a method, called testState, to check and make sure that the state 
parameter is properly formatted by the user. It it is not a false value will be returned 
which causes the process to be tagged as an error.
 */


/**
 *
 * @author Luca
 */
public class Process {
    private String name;
    private int time; 
    private String state;
    private ArrayList<ProcessList[]> pList;
    
    public Process(int t, String n, String s){
        name = n;
        time = t;
        state = s;

        
}
    
    public String toString(){
        String result = time + " : " + name + " : " + state;
        return result;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setTime(int t){
        time = t;
    }
    
    public void setState(String s){
        state = s;
    }
    
    public String getName(){
        return name;
    }
    

    public int getTime(){
        return time;

    }

    public String getState(){
        return state;
    }
    public boolean testState(){
        String[] test = state.split(" ");
        for (int i = 0; i < test.length; i+=4) {
            if(!test[i].equals("C")){
                return false;
            }
        }
        for (int i = 2;  i < test.length; i+= 4) {
            if(!test[i].equals("I")){
                return false;
            }    
            
        }
        for (int i = 1; i < test.length; i+=2) {
            try {Integer.parseInt(test[i]);}
            catch (Exception e) {return false;}
        }
        return true;
    }//end testState
}
