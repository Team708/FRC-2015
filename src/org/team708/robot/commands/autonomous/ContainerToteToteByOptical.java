package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.clawElevator.IncrementClawOne;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.DriveToIRDistance;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.indexer.IndexerUp;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class ContainerToteToteByOptical extends CommandGroup {
		
//	private double irTolerance = 5;  //inches (was .0625)?
        	
    public  ContainerToteToteByOptical() {
    	
	    // Pick up a container
    	addSequential(new IncrementClawOne());
	    addSequential(new WaitCommand(0.2));
	    
	    // Drive to and pick up a tote
    	addSequential(new DriveStraightToEncoderDistance(AutoConstants.CONTAINER_TOTE_TOTE_FIRST, AutoConstants.ENCODER_SPEED));
//    	addSequential(new WaitCommand(0.1));
//    	addSequential(new DriveToIRDistance(Constants.IR_HAS_TOTE_DISTANCE, irTolerance));
//    	addSequential(new WaitCommand(0.1));
    	addSequential(new IndexerUp(false));

    	// Drive to and pick up another tote
    	addSequential(new DriveStraightToEncoderDistance(AutoConstants.CONTAINER_TOTE_TOTE_SECOND, AutoConstants.ENCODER_SPEED));  
//    	addSequential(new DriveToIRDistance(Constants.IR_HAS_TOTE_DISTANCE, irTolerance));
//    	addSequential(new WaitCommand(0.1));
    	addSequential(new IndexerUp(false));
    	
    	// Turn and drives to the auto zone
    	addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, AutoConstants.NINETY_DEGREE_TURN));
    	addSequential(new DriveByOpticalToAuto());
    	addSequential(new DriveStraightToEncoderDistance(AutoConstants.CLAW_LENGTH, AutoConstants.ENCODER_SPEED));
    	
    	// Turn 90 degrees counterclockwise
    	addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, -AutoConstants.NINETY_DEGREE_TURN));
//    	
////need to drop the tote for it to count
//    	addSequential(new TurnToDegrees(TURN_SPEED, TURN_ANGLE));
//    	addSequential(new IndexerDown());
    }
}
