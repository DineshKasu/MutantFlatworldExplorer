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
public class IsLostTrue implements IsLostResult
{
 
    
 public void DisplayIsLostResult(RobotModel robotmodel)
 {
     String resultado =" ";
     resultado = resultado + robotmodel.getrobotXpostion() + " " + robotmodel.getrobotYpostion() + " " + robotmodel.getrobotOrientation()+" LOST";
     System.out.println(resultado);                
 }
    
}
