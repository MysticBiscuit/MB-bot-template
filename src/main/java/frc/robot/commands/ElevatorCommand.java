package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.Constants;

public class ElevatorCommand extends Command {
    private final ElevatorSubsystem m_elevatorMotorOne;
    private final XboxController m_Controller;

    public IntakeCommand(IntakeSubsystem elevator,XboxController controller) {
        m_elevatorMotorOne = elevator;
        m_Controller = controller;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        m_elevatorMotorOne.updateWithControls(
            m_Controller.getPOV() == 180
        );
    
}}