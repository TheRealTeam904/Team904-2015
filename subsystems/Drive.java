package org.usfirst.frc.team904.robot.subsystems;

import org.usfirst.frc.team904.robot.OI;
import org.usfirst.frc.team904.robot.RobotMap;
import org.usfirst.frc.team904.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    
    static RobotDrive myRobot;
    RobotDrive myClaw;

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    public Drive(){
    	myRobot = new RobotDrive(RobotMap.leftFrontMotor, RobotMap.leftBackMotor, RobotMap.rightFrontMotor, RobotMap.rightBackMotor);
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);
    	myRobot.setInvertedMotor(MotorType.kRearLeft, true);
    	myRobot.setExpiration(0.1);
    	System.out.println("Drive Initilization Finished");
    }
    
    public static void Robot(){

    }

    public static void operatorControl(){
    	if (myRobot != null) myRobot.mecanumDrive_Cartesian(-OI.stickOperation.getX(), -OI.stickOperation.getY(), -OI.stickOperation.getZ(), 0);
    	Timer.delay(0.005);
    }
    
    public static void end(){
    	if (myRobot != null) myRobot.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
}

