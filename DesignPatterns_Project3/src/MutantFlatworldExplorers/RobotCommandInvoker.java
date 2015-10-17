/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MutantFlatworldExplorers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dineshkasu
 */
//Command Invoker Class
public class RobotCommandInvoker
{
    
    private List<StartRobotCommand> Startrobotcommand = new ArrayList<StartRobotCommand>();
  
  public void takeSteps(StartRobotCommand startcommand)
  {
      Startrobotcommand.add(startcommand);
  }
  
  public void processSteps()
  {
      for(StartRobotCommand startcommands : Startrobotcommand)
      {
          startcommands.execute();
      }
  }
}
