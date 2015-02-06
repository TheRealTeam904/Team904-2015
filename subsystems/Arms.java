package org.usfirst.frc.team904.robot.subsystems;

import org.usfirst.frc.team904.robot.RobotMap;
import org.usfirst.frc.team904.robot.commands.ArmOpen;
import org.usfirst.frc.team904.robot.commands.clawDoNothing;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static Relay ArmRelay;								// Relay which drives the forklift

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new clawDoNothing());
    }
    public Arms(int relayChannel, 
			int encoder_aSource, 
			int encoder_bSource
			) {
		// Set up our class variables
		//m_shaftEncoder = new Encoder(encoder_aSource, encoder_bSource);
		ArmRelay = new Relay(RobotMap.spikeChannel);
		System.out.println("Arms Initialization complete");
		
		//m_shaftEncoder.reset();
		ArmRelay.set(Relay.Value.kOff);
    }
    public static void grip() {
		System.out.println("\nArm gripping!");
    	ArmRelay.set(Relay.Value.kForward);    
    	//TODO: Have some way to stop this when it hits the top
    }
    public static boolean release() {
		System.out.println("\nArm releasing!");
		ArmRelay.set(Relay.Value.kReverse); // TODO: Have some way of stopping this when it hits bottom
		return true;
	}
    public static void stop() {
		ArmRelay.set(Relay.Value.kOff);
		Timer.delay(0.005);
	}
}

