package org.usfirst.frc.team904.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team904.robot.OI;
import org.usfirst.frc.team904.robot.RobotMap;
import org.usfirst.frc.team904.robot.commands.DriveWithJoystick;

public class Drive extends Subsystem {

	static RobotDrive myRobot;
	RobotDrive myClaw;
	
	public void Robot() {
		//Setting up the Robot drive basic functions
    	myRobot.setExpiration(0.1);
        myRobot = new RobotDrive(RobotMap.leftFrontMotor, RobotMap.leftBackMotor, RobotMap.rightFrontMotor, RobotMap.rightBackMotor);
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);	// invert the left side motors
    	myRobot.setInvertedMotor(MotorType.kRearLeft, true);		// you may need to change or remove this to match your robot

	}

    /**
     * Runs the motors with Mecanum drive.
     */
    public static void operatorControl() {
        myRobot.setSafetyEnabled(true);
        while (myRobot.isAlive() && myRobot.isSafetyEnabled()) {
        	
        	// Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
        	// This sample does not use field-oriented drive, so the gyro input is set to zero.
            myRobot.mecanumDrive_Cartesian(OI.stick.getX(), OI.stick.getY(), OI.stick.getZ(), 0);
            
            Timer.delay(0.005);	// wait 5ms to avoid hogging CPU cycles
        }
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DriveWithJoystick());
    }

    //Do I actually have to have this here? Test with and without
	public static void end() {
		// TODO Auto-generated method stub
		myRobot.mecanumDrive_Cartesian(0, 0, 0, 0);
	}
}
