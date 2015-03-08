package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.clawElevator.IncrementClawOne;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.TurnToDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ContainerToAutoZoneByOptical extends CommandGroup {
	
    public  ContainerToAutoZoneByOptical() {
    	addSequential(new IncrementClawOne());
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveByOpticalToAuto());
    	addSequential(new DriveStraightToEncoderDistance(AutoConstants.CONTAINER_TO_AUTOZONE_DISTANCE));   
    	
    	addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, -AutoConstants.NINETY_DEGREE_TURN));
    }
}