/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MutantFlatworldExplorers;

/**
 *
 * @author Dineshkasu
 */
//Request Class for commands execution
public class RobotCommand
{
    //call the mutators to set the robot model orientation
    public void setSouth(RobotModel robotmodel)
    {
        robotmodel.setrobotOrientation("S");
    }
    
     public void setNorth(RobotModel robotmodel)
    {
         robotmodel.setrobotOrientation("N");
    }
     
    public void setWest(RobotModel robotmodel)
    {
         robotmodel.setrobotOrientation("W");
    }
    
    public void setEast(RobotModel robotmodel)
    {
         robotmodel.setrobotOrientation("E");
    }
}
