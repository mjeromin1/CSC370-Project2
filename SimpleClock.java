/* This class is based upon a starter code that was provided by Dr. James Klayder
 * The starter code for this class was found at http://raider.mountunion.edu/csc/CSC370/Spring2018/projects/project01/ClockStarter.java
 * It was provided by professor James Klayder for CSC 370 to begin out first project on 1/17/18

Wil Luca CSC 370 Operating System 1/29/18

Description: This Simple Clock class is based off the starter clock class. It is controlled by 
the setIsRunning method which when a button is clocked in MainFrame causes the clock to stat running.
It takes one JTextField parameter so that the current time of the clock can be continually displayed.
It contains one getter method for the current time.

 */

import javax.swing.JTextField;

public class SimpleClock implements Runnable{
    
    private Thread thread;
    private int currentTime;
    private boolean isRunning;
    private static JTextField counter; 
    
    public SimpleClock(JTextField c) {
        counter = c;
        currentTime = -1;
        
        thread = new Thread(this);
        thread.start();
        isRunning = false;
    }
    
    public void run() {

        while (true){
           if(isRunning){ 
            incrementTime();
            counter.setText(currentTime + "");
           } 
            
            try{ Thread.sleep(1000); } catch (Exception e) {}
        }
    }
    
    public void incrementTime(){
        currentTime++;
    }
    
    public int getCurrentTime(){
        return currentTime;
    }

    public void setIsRunning(){
        if(isRunning==false){
           isRunning = true; 
        }else{
            isRunning = false;
        }
       
    }

    }
