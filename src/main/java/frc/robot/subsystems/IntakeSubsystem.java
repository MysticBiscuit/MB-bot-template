package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
// import com.revrobotics.AbsoluteEncoder;
// import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    private SparkMax m_exampleMotorOne;
    private SparkMax m_exampleMotorTwo;

    private final Pigeon2 m_gyro = new Pigeon2(Constants.DriveConstants.kGyroID);

    public IntakeSubsystem(){
        m_exampleMotorOne = new SparkMax(Constants.DriveConstants.kShooterIndexerCanId, MotorType.kBrushless);
        m_exampleMotorTwo = new SparkMax(Constants.DriveConstants.kShooterCanId, MotorType.kBrushless);
    }

    @Override
    public void periodic(){
        if (!DriverStation.isAutonomous()){

        }
    }

    public void exampleFunction(boolean test) {
        if(test) {
            m_exampleMotorTwo.set(-0.7);
        } else if (DriverStation.isTeleop()) {
            m_exampleMotorTwo.set(0);
        }
    }
    public void zeroIt(boolean zero) {
        if (zero) {
            m_gyro.reset();
        }
    }

    public void updateWithControls(boolean armKillSwitch) {
    
    }

}
