/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MutantFlatworldExplorers;

/**
 *
 * @author Dineshkasu 
 * View module Responsibilities: 
 * •View module displays the final grid position and orientation of robot.
 * •If a robot falls off the edge of the grid, then it also displays 'LOST' after grid position and orientation of robot. 
 * •This module consists of the following classes.
 * * 
MFEView.java IsLostResultResult.java IsLostFalse.java IsLostTrue.java
 * IsLostResultFactory.java
 */
public class MFEView {
    /**
	Singleton :-
     In order to make a class Singleton,  we have to follow the below rules:
     •	It should have only single instance
     •	This instance should be available through a global access
     Steps to make class as a singleton.
     1.	Create a class which you want to make singleton.
     2.	Create a private default constructor of the class.
     3.	Create a private static variable of the class created in step1 and this variable should be private and static and
     it should refer to the instance of class created in step1.
     4.	Create a accessor method which could always return us back with a instance of class created in step3.
     5.	There should not be any method or constructor which can create instance of this class.
     Singleton Design pattern is applied to MFEView.java class, as it can have only 1 single instance in the MFE.*/

    //Default constructor for singleton class   
    private MFEView() {

    }

    //create an instance for singleton class
    private static MFEView MFEViewSingleton = new MFEView();

    //Singleton Instance accessor method
    public static MFEView getInstance() {
        return MFEViewSingleton;
    }

    //This method is called to display the final grid position and orientation of robot.
    public void drawMFEMap(RobotModel robotmodel) {
        /*Factory method   :This pattern is used to find the isLost result : True or False.
         I  have created a IsLostResult interface and concrete classes-isLostTrue & IsLostFalse implementing the IsLostResult interface.
         A factory class IsLostResultFactory is defined as a next step. MFEView, our driver class will use IsLostResultFactory 
         to get a IsLostResult object. The MFEView will send the IsLost variable information to IsLostResultFactory to get the 
         type of object it needs.
         Thus it prints the output of the MFE
         */
        IsLostResult islostresult = IsLostResultFactory.getResult(robotmodel.getisLost());

        //Used the Factory to get object of concrete class by passing an information such as type 
        islostresult.DisplayIsLostResult(robotmodel);
    }
}
