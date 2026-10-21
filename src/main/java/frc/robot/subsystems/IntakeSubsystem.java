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
            m_shooter.set(-0.7);
        } else if (DriverStation.isTeleop()) {
            m_shooter.set(0);
        }
    }

    public void indexIt(boolean indexIt) {
        if(indexIt) {
            m_shooterIndexer.set(0.65);
        } else if (DriverStation.isTeleop()) {
            m_shooterIndexer.set(0);
        }
    }

    public void shoot(double speed, Timer timer) {
        timer.reset();
        timer.start();
        m_shooter.set(-speed);

        if (timer.get() >= 3) {
            m_shooterIndexer.set(speed - 0.05);
        }
    }

    public void stopShooter(boolean stop) {
        if (stop) {
            m_shooter.set(0);
            m_shooterIndexer.set(0);
        }
    }

    public void intakeArmDown(double speed) {
        m_armExtenderOne.set(speed);
        m_armExtenderTwo.set(-speed);
    }

    public void intakeStop(boolean stop) {
       if (stop) {
        m_armExtenderOne.set(0);
        m_armExtenderTwo.set(0);
       }
    }

    public void zeroIt(boolean zero) {
        if (zero) {
            m_gyro.reset();
        }
    }

   /**  public void hoodAdjustmentCoverIt(boolean decreaseAngle) {
        if (decreaseAngle) {
            m_hood.set(0.1);
        } else {
            m_hood.set(0);
        }
    } 

    public void hoodAdjustmentOpenIt(boolean increaseAngle) {
        if (increaseAngle) {
            m_hood.set(-0.1);
        } else {
            m_hood.set(0);
        }
    }*/

    public void updateWithControls(boolean armKillSwitch) {
        m_armKillSwitch = armKillSwitch;
    }

}
