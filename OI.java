package org.usfirst.frc.team904.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team904.robot.commands.ArmOpen;
import org.usfirst.frc.team904.robot.commands.ArmRelease;
import org.usfirst.frc.team904.robot.commands.ForkliftDown;
import org.usfirst.frc.team904.robot.commands.ForkliftUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
	public static Joystick stick = new Joystick(RobotMap.joystickChannel);
	public static Joystick stickOperation = new Joystick(RobotMap.joystickOperationChannel);
    public static Button forkliftUpButton = new JoystickButton(stickOperation, 1);
	public static Button forkliftDownButton = new JoystickButton(stickOperation, 2);
	public static Button armsGripButton = new JoystickButton(stickOperation, 3);
	public static Button armsReleaseButton = new JoystickButton(stickOperation, 4);
    
	public OI(){
    //// TRIGGERING COMMANDS WITH BUTTONS
	forkliftUpButton.whileHeld(new ForkliftUp());
    forkliftDownButton.whileHeld(new ForkliftDown()); 
    armsGripButton.whileHeld(new ArmOpen());
    armsReleaseButton.whileHeld(new ArmRelease());
    }
}

