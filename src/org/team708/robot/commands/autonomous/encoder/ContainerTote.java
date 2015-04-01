
package org.team708.robot.commands.autonomous.encoder;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.claw.CloseClaw;
//import org.team708.robot.commands.claw.ToggleClawOpen;
import org.team708.robot.commands.clawElevator.IncrementClawOne;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.indexer.IndexerDown;
import org.team708.robot.commands.indexer.IndexerUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ContainerTote extends CommandGroup {
        
    public  ContainerTote() {
    		addSequential(new CloseClaw());
    	    addSequential(new IncrementClawOne());
        	addSequential(new DriveStraightToEncoderDistance(AutoConstants.CONTAINER_TOTE_DISTANCE));  

        	addSequential(new IndexerUp());
        	
        	addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, AutoConstants.NINETY_DEGREE_TURN));
        	addSequential(new DriveStraightToEncoderDistance(AutoConstants.TOTE_TO_AUTOZONE_DISTANCE));
        	
        	//need to drop the tote for it to count
        	addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, -AutoConstants.NINETY_DEGREE_TURN));
        	addSequential(new IndexerDown());
    }
}
