package org.usfirst.frc.team904.robot.commands;

import org.usfirst.frc.team904.robot.Robot;
import org.usfirst.frc.team904.robot.subsystems.Arms;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmOpen extends Command {

    public ArmOpen() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Arms.grip();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Arms.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
