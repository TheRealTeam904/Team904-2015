package org.usfirst.frc.team904.robot;

import org.usfirst.frc.team904.robot.commands.ArmMotion;
import org.usfirst.frc.team904.robot.commands.ArmRelease;
import org.usfirst.frc.team904.robot.commands.ForkliftDown;
import org.usfirst.frc.team904.robot.commands.ForkliftUp;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import org.usfirst.frc.team904.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS

	public static Joystick stick = new Joystick(RobotMap.joystickChannel);
	public static Joystick stickOperation = new Joystick(RobotMap.joystickChannel);
    public static Button forkliftUpButton = new JoystickButton(stickOperation, 1);
	public static Button forkliftDownButton = new JoystickButton(stickOperation, 2);
	public static Button armsGripButton = new JoystickButton(stickOperation, 3);
	public static Button armsReleaseButton = new JoystickButton(stickOperation, 4);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    public OI() {
    	  //// TRIGGERING COMMANDS WITH BUTTONS
        // Once you have a button, it's trivial to bind it to a button in one of
        // three ways:
        
        // Start the command when the button is pressed and let it run the command
        // until it is finished as determined by it's isFinished method.
    	forkliftUpButton.whenPressed(new ForkliftUp());
        forkliftDownButton.whenPressed(new ForkliftDown()); 
        armsGripButton.whenPressed(new ArmMotion());
        armsReleaseButton.whenPressed(new ArmRelease());
        
    }
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    //forkliftUpButton.whileHeld(new ForkliftUp());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
}