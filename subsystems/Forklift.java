package org.usfirst.frc.team904.robot.subsystems;

import org.usfirst.frc.team904.robot.RobotMap;
import org.usfirst.frc.team904.robot.commands.clawDoNothing;
import org.usfirst.frc.team904.robot.commands.forkliftDoNothing;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//private static Relay ArmRelay;								// Relay which drives the forklift
	private Encoder m_shaftEncoder;							// Shaft encoder attached to the shaft driving the forklift
	private static Talon m_Talon;								// Talon which drives the forklift
	private static final double forkliftSpeed = 1;		// Forklift Speed Magnitude. Change this to make the forklift go slower. NO NEGATIVES
	//private static final double baseHeight = 0; 			// Forklift base height above ground (cm)
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new forkliftDoNothing());
    }
    
    public Forklift(int relayChannel, 
			int encoder_aSource, 
			int encoder_bSource
			) {
		//System.out.println("Forklift Initialization");
		// Set up our class variables
		//m_shaftEncoder = new Encoder(encoder_aSource, encoder_bSource);
		m_Talon = new Talon(RobotMap.forkliftChannel);
		System.out.println("Forklift Initialization complete");
		
		// Place the forklift in its initial state
		//m_shaftEncoder.reset();
		//m_Talon.set(0);
		
	}
	
    public static void goUp() {
		System.out.println("\nForklift going up!");
    	m_Talon.set(forkliftSpeed);    
    	//TODO: Have some way to stop this when it hits the top
    }
    
    public static void goDown() {
		System.out.println("\nForklift going down!");
		m_Talon.set(-forkliftSpeed); // TODO: Have some way of stopping this when it hits bottom
	}
    public static void stop() {
		m_Talon.set(0);
		Timer.delay(0.005);
	}
}

