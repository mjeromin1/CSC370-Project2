
import java.util.ArrayList;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luca
 */
public class Simulator {
    
    private ArrayList<ProcessList> nL;
    private ArrayList<ProcessList> rL;
    private ArrayList<ProcessList> tL;
    private ArrayList<ProcessList> wL;
    private SimpleClock clock;
    private Process[] data;
    

    
    public Simulator(String s, SimpleClock c){
     nL = new ArrayList<>();
     rL = new ArrayList<>();  
     tL = new ArrayList<>();
     wL = new ArrayList<>();
     clock = c;
     
     
    }
 
    
    
    public void showSystemStatus(JTextArea outputArea){


    outputArea.append("clock -- "+ clock.getCurrentTime() +"\n" +
        "timeQuantum --"+ quantum+ "\n" +
        "processList.size() -- "+ states.size() +"\n");
        for (int i = 0; i < states.size(); i++) {
            outputArea.append("\t process "+ i + " ---     " + states.get(i).toString() +"\n");
        }
        for (int i = 0; i < states.size(); i++) {
            if(clock.getCurrentTime()== states.get(i).getTime()){
                 nL.add(states.get(i));
                         }
            if(clock.getCurrentTime()> states.get(i).getTime()){
                rL.add(states.get(i));
            }
        }
        

    outputArea.append("newList.size() -- "+ nL.size()+ "\n");
        for (int i = 0; i < nL.size(); i++) {
        outputArea.append(i + " ---      " + nL.get(i).toString() + "\n");
        }
    outputArea.append("readyList.size() -- "+ rL.size()+ " \n");
        for (int i = 0; i < rL.size(); i++) {
        outputArea.append(i + " ---      " + rL.get(i).toString() + "\n");
        }
    outputArea.append("\n");
    }
    
    public void readData(){

    
        counterField.setText(clock.getCurrentTime()+ "");
        String[] input = inputArea.getText().trim().split("\n");
        
        try {quantum = Integer.parseInt(input[0]);} catch (Exception e){ outputArea.setText("Error: Time Quantum is an incorrect value \n"); return;} //Error Check for Time Quantum
            
        outputArea.append("  OS simulator is now initialized\n" +"\n");
        outputArea.append("clock -- "+ clock.getCurrentTime() +"\n" +
            "Time Quantum --"+ quantum+ "\n");
        for (int i = 0; i < input.length/3; i++) {
            try { states.add(CPU = new Process(Integer.parseInt(input[1+ i*3]), input[2+ i*3], input[3+ i*3])); } //Error checck to make sure the necessary items for a Process are present
            catch (Exception e) { outputArea.append("Error: The process that was originally " + states.lastIndexOf(CPU) + " was not created due to incorrect data or lack of data\n");}
        }
        outputArea.append("processList.size() -- "+ states.size() +"\n");
        for (int i = 0; i < states.size(); i++) {
            if(states.get(i).testState()){
                outputArea.append("\t process "+ i + " ---     " + states.get(i).toString() + "\n");
            }else{
                outputArea.append("\t process "+ i + " ---     " + states.get(i).toString() + "; Error: is improperly formatted \n");//If the data is present, but not peoperly formatted
            }
            
        }
        for (int i = 0; i < states.size(); i++) {
            if(clock.getCurrentTime()== states.get(i).getTime()){
                 nL.add(states.get(i));
                         }
            if(clock.getCurrentTime()> states.get(i).getTime()){
                rL.add(states.get(i));
            }
        }
        

         outputArea.append("newList.size() -- "+ nL.size()+ "\n");
            for (int i = 0; i < nL.size(); i++) {
                outputArea.append(i + " ---      " + nL.get(i).toString() + "\n");
            }
        outputArea.append("readyList.size() -- "+ rL.size()+ " \n");
            for (int i = 0; i < rL.size(); i++) {
                outputArea.append(i + " ---      " + rL.get(i).toString() + "\n");
            }
        outputArea.append("\n");
    
 
    }

    
}
