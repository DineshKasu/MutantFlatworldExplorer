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
public class IsLostResultFactory 
{
     public static IsLostResult getResult(boolean isLost)
   {
       
       if(isLost)
       {
           return new IsLostTrue();
       }
       else
       {
           return new IsLostFalse();
       }
         
   }
}
