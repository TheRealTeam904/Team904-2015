package org.usfirst.frc.team904.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;




import org.usfirst.frc.team904.robot.RobotMap;
//import org.usfirst.frc.team904.robot.*;
import org.usfirst.frc.team904.robot.commands.ForkliftUp;

/**
 *
 */
@SuppressWarnings("unused")
public class Arms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//private Encoder m_shaftEncoder;							// Shaft encoder attached to the shaft driving the forklift
	private static Relay ArmRelay;								// Relay which drives the forklift
	
	//private static final double baseHeight = 0; 			// Forklift base height above ground (cm)
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ForkliftUp());
    }
    public Arms(int relayChannel, 
			int encoder_aSource, 
			int encoder_bSource
			) {
		//System.out.println("Forklift Initialization");
		// Set up our class variables
		//m_shaftEncoder = new Encoder(encoder_aSource, encoder_bSource);
		ArmRelay = new Relay(RobotMap.spikeChannel);
		System.out.println("Arms Initialization complete");
		
		// Place the forklift in its initial state
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
		System.out.println("\nArm stopped!");
	}
}

