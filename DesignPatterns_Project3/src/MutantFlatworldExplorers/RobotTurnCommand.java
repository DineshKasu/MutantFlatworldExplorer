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
//Class implementing the StartRobotCommand Interface
public class RobotTurnCommand implements StartRobotCommand
{
 
    
    private RobotCommand Robotcommand;
    private RobotModel robotmodel;
    private String Orientation;
    private char Instruction;

    public RobotTurnCommand(RobotCommand Robotcommand, RobotModel robotmodel,char Instruction) 
    {
        this.Robotcommand= Robotcommand;
        this.robotmodel = robotmodel;
        this.Instruction = Instruction;
    }

    public void execute()
    {

           if((("N".equals(robotmodel.getrobotOrientation()))&&(Instruction == 'L'))
                                           ||
               (("S".equals(robotmodel.getrobotOrientation()))&&(Instruction == 'R')))
           {
                Robotcommand.setWest(robotmodel);
           }          
           else if((("W".equals(robotmodel.getrobotOrientation()))&&(Instruction == 'L'))
                                           ||
               (("E".equals(robotmodel.getrobotOrientation()))&&(Instruction == 'R')))
           {
                  Robotcommand.setSouth(robotmodel);
           }
            else if((("S".equals(robotmodel.getrobotOrientation()))&&(Instruction == 'L'))
                                           ||
               (("N".equals(robotmodel.getrobotOrientation()))&&(Instruction == 'R')))
           {
                Robotcommand.setEast(robotmodel);
           }
           else
           {
                Robotcommand.setNorth(robotmodel);
           }
       }      
}

