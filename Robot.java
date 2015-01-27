
package org.usfirst.frc.team904.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team904.robot.RobotMap;
import org.usfirst.frc.team904.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team904.robot.commands.ExampleCommand;
import org.usfirst.frc.team904.robot.commands.ForkliftUp;
import org.usfirst.frc.team904.robot.subsystems.Drive;
import org.usfirst.frc.team904.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team904.robot.subsystems.Forklift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//When the robot first starts, a new subsystem and drive are made
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final Drive drive = new Drive();
	public static final Forklift forklift = new Forklift(RobotMap.talonChannel, 0, 0, 0, 0);
	public static OI oi;

    Command autonomousCommand;
    Command drivingCommand;
    Command forkliftUp;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		//When the robot launches, it will create a new OI
    	oi = new OI();
        // instantiate the command used for the autonomous period
    	//Okay so here it is making whatever commands you want to use
        autonomousCommand = new ExampleCommand();
        drivingCommand = new DriveWithJoystick();
        forkliftUp = new ForkliftUp();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
   
	//This is automatically configured to run whenever the driver tells it to
    public void autonomousInit() {
        // schedule the autonomous command (example)
    	//If autonomous command is equal to something, start it here
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
   
    //This is automatically configured to run whenever the driver tells it to
    public void teleopInit() {
    	//Making sure that autonomous is canceled
        if (autonomousCommand != null) autonomousCommand.cancel();
        //Starting DriveWithJoystick
        if (drivingCommand != null) drivingCommand.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	drivingCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
