/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MutantFlatworldExplorers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Dineshkasu 
 * Controller module Responsibilities:
 * •This module is the main entry point for Mutant Flat world Explorers. 
 * •Creates the instance of new robot model. 
 * •Tells the view to print the output when the robot instructions are over.
 * •This module consists of the following class.
 * MFEController.java
 */
public class MFEController {

    public static void main(String[] arguments) throws FileNotFoundException {

           //Creating the instance for Robot Model
        RobotModel robotmodel = new RobotModel();


        //Singelton Instance for MFEview class is being called here
        MFEView mfeview = MFEView.getInstance();
        
         //It scans the input file data and sends the same information to Robot Model
        Scanner scanner = new Scanner(new FileReader("./inputfile"));

        if (scanner.hasNext()) {
            robotmodel.setmapXboundary(scanner.nextInt() + 1);
            robotmodel.setmapYboundary(scanner.nextInt() + 1);

            while (scanner.hasNext()) {
                robotmodel.setrobotXpostion(scanner.nextInt());
                robotmodel.setrobotYpostion(scanner.nextInt());
                robotmodel.setrobotOrientation(scanner.next());
                robotmodel.setRobotInstructions(scanner.next());
                robotmodel.setisLost(false);

                for (int i = 0; i < robotmodel.getRobotInstructions().length() && !robotmodel.getisLost(); i++)
                {
                    char Instr = robotmodel.getRobotInstructions().charAt(i);
                    //Robot forward movement scenario
                    if (Instr == 'F') 
                    {
                        robotmodel.moveRobotForward(robotmodel.getrobotOrientation());
                    } //Robot turn left or right scenario
                    else if (Instr == 'L' || 'R' == Instr) 
                    {
                        RobotCommand robotcommand = new RobotCommand();
                        RobotTurnCommand robotturn = new RobotTurnCommand(robotcommand, robotmodel, Instr);
                        RobotCommandInvoker robotinvoker = new RobotCommandInvoker();
                        robotinvoker.takeSteps(robotturn);
                        robotinvoker.processSteps();
                        /*COMMAND PATTERN :This pattern is used to pass the instructions to the robot in the model module. 
                         I have created an interface StartRobotCommand which is acting as a command. 
                         I have created a RobotCommand class which acts as a request. 
                         I have concrete command class  RobotTurnCommand implementing StartRobotCommand 
                         interface which will do actual command processing. A class RobotCommandInvoker is created which acts as a invoker object. 
                         It can take steps and process steps. RobotCommandInvoker object uses command pattern to identify which object will execute 
                         which command based on type of command. MFEController, our driver class will use RobotCommandInvoker class to demonstrate command pattern.
                         */
                    }
                }
                mfeview.drawMFEMap(robotmodel);
            }

        }
    }
}
