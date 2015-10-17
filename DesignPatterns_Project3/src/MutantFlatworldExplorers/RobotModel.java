/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MutantFlatworldExplorers;

import java.util.*;

/**
 *
 * @author Dineshkasu * 
 * Model module Responsibilities: 
 * •	Model module contains the information about the robot grid positions and its orientation being processed.
 * •	It takes the scanned input file data from MFEController and loads the information into variables. 
 * •	It modifies the grid positions of the robot and its orientation based on the instructions.
 * •	It also set the scent for the grid positions when the robot fall of from the boundaries.
 * •	This module consists of the following classes.
 *
 * RobotModel.java	   RobotCommand.java 
 * StartRobotCommand.java  RobotTurnCommand.java 
 * RobotCommandInvoker.java
 *
 */
public class RobotModel {

    //The below are Accessor methods fields.

    private int flatworld_xbound, flatworld_ybound, robot_xpos, robot_ypos;
    private String robot_orientation, instructions_string;
    private Vector<String> scent = new Vector<String>();
    private boolean isLost;


    /*Accessors(getters) and Mutators(setters) are declared in below.
     An accessor method is used to return the value of a private field. 
     These methods always return the same data type as their corresponding private field 
     and then simply return the value of that private field
     */
    public RobotModel() {
        flatworld_xbound = 50;
        flatworld_ybound = 50;
        robot_xpos = 0;
        robot_ypos = 0;
        robot_orientation = " ";
        instructions_string = " ";
        isLost = false;
    }

    //Mutator for grid Xboundary
    public void setmapXboundary(int flatworld_xbound) {
        this.flatworld_xbound = flatworld_xbound;
    }
     //Mutator for grid Yboundary
    public void setmapYboundary(int flatworld_ybound) {
        this.flatworld_ybound = flatworld_ybound;
    }
    //Mutator for robot Xposition
    public void setrobotXpostion(int robot_xpos) {
        this.robot_xpos = robot_xpos;
    }
    //Mutator for robot Yposition
    public void setrobotYpostion(int robot_ypos) {
        this.robot_ypos = robot_ypos;
    }
    //Mutator for robot Orientation
    public void setrobotOrientation(String robot_orientation) {
        this.robot_orientation = robot_orientation;
    }
    //Mutator for robot Instructions
    public void setRobotInstructions(String instructions_string) {
        this.instructions_string = instructions_string;
    }
   //Mutator for robot IsLost
    public void setisLost(boolean isLost) {
        this.isLost = isLost;
    }
   //Accessor for grid xboundary
    public int getmapXboundary() {
        return flatworld_xbound;
    }
//Accessor for grid Yboundary
    public int getmapYboundary() {
        return flatworld_ybound;
    }
//Accessor for robot x position 
    public int getrobotXpostion() {
        return robot_xpos;
    }
//Accessor for robot Y position 
    public int getrobotYpostion() {
        return robot_ypos;
    }
//Accessor for robot orientation
    public String getrobotOrientation() {
        return robot_orientation;
    }
//Accessor for robot Instructions
    public String getRobotInstructions() {
        return instructions_string;
    }
//Accessor for robot islost
    public boolean getisLost() {
        return isLost;
    }

//Method to move the robot forward based on the orientation,robot positions and grid positions  
    
    public void moveRobotForward(String orientation) {

        String s = "";
        s = s + robot_xpos;
        s = s + "-";
        s = s + robot_ypos;

        if (orientation.equals("N") || orientation.equals("S")) {

            //   System.out.println("inside");
            if (!scent.contains(s)) {
                if (orientation.equals("N")) {
                    robot_ypos = robot_ypos + 1;
                } else {
                    robot_ypos = robot_ypos - 1;
                }
            } else if (orientation.equals("S") && robot_ypos > 0) {
                robot_ypos = robot_ypos - 1;
            } else if (orientation.equals("N") && robot_ypos < flatworld_ybound - 1) {
                robot_ypos = robot_ypos + 1;
            }
            if (robot_ypos < 0 || robot_ypos == flatworld_ybound) {
                //System.out.println("lost");   
                if (robot_ypos < 0) {
                    robot_ypos = 0;
                } else {
                    robot_ypos = flatworld_ybound - 1;
                }
                if (!scent.contains(s)) {
                    scent.addElement(s);
                }
                isLost = true;
            }
        } else if (orientation.equals("E") || orientation.equals("W")) {
            if (!scent.contains(s)) {
                if (orientation.equals("E")) {
                    robot_xpos = robot_xpos + 1;
                } else {
                    robot_xpos = robot_xpos - 1;
                }
            } else if (orientation.equals("W") && robot_xpos > 0) {
                robot_xpos = robot_xpos - 1;
            } else if (orientation.equals("E") && robot_xpos < flatworld_xbound - 1) {
                robot_xpos = robot_xpos + 1;
            }

            if (robot_xpos < 0 || robot_xpos == flatworld_xbound) {
                //System.out.println("lost");   
                if (robot_xpos < 0) {
                    robot_xpos = 0;
                } else {
                    robot_xpos = flatworld_xbound - 1;
                }
                if (!scent.contains(s)) {
                    scent.addElement(s);
                }
                isLost = true;
            }
        }
    }
}
