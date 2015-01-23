package org.usfirst.frc.team904.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

//import org.usfirst.frc.team904.robot.*;
import org.usfirst.frc.team904.robot.commands.ForkliftUp;

/**
 *
 */
public class Forklift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Encoder m_shaftEncoder;							// Shaft encoder attached to the shaft driving the forklift
	private static Talon m_Talon;								// Talon which drives the forklift
	//private DigitalInput m_toplimitswitch_input;			// Digital Input for the max height limit switch
	private DigitalInput m_bottomlimitswitch_input;			// Digital Input for the min height limit switch
	
	private static final double forkliftSpeed = 1.0;		// Forklift Speed Magnitude. Change this to make the forklift go slower. NO NEGATIVES
	//private static final double baseHeight = 0; 			// Forklift base height above ground (cm)
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ForkliftUp());
    }
    public Forklift(int talonChannel, 
			int encoder_aSource, 
			int encoder_bSource, 
			int toplimitSwitch_channel,
			int bottomlimitSwitch_channel
			) {
		System.out.println("Forklift Initialization");
		// Set up our class variables
		m_shaftEncoder = new Encoder(encoder_aSource, encoder_bSource);
		m_Talon = new Talon(talonChannel);
		//m_toplimitswitch_input = new DigitalInput(toplimitSwitch_channel);
		m_bottomlimitswitch_input = new DigitalInput(bottomlimitSwitch_channel);
		System.out.println("Forklift Initialization complete");
		
		// Place the forklift in its initial state
		m_shaftEncoder.reset();
		m_Talon.set(0);
    }
    public static void goUp() {
		System.out.println("\nForklift going up!");
    	m_Talon.set(forkliftSpeed);    
    	//TODO: Have some way to stop this when it hits the top
    }
    public boolean goDown() {
		if (m_bottomlimitswitch_input.get()) {
		System.out.println("\nForklift going down!");
		m_Talon.set(-forkliftSpeed); // TODO: Have some way of stopping this when it hits bottom
		return true;
		} else {
			System.out.println("\nBottom Limit Switch!");
			return false;
		}
	}
    public static void stop() {
		m_Talon.set(0);
		System.out.println("\nForklift stopped!");

	}
}

