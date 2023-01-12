package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// This class controls motion of the Chassis
public class Chassis {
    // Initialize motor controllers
    //      Spark and VictorSPX on each side of the chassis
    //      Initialized with IDs 0-3 and SparkMAx's must be set to Brushed mode (CIMs)
    private final CANSparkMax m_leftMotor1 = new CANSparkMax(0, MotorType.kBrushed);
    private final WPI_VictorSPX m_leftMotor2 = new WPI_VictorSPX(1);
    private final CANSparkMax m_rightMotor1 = new CANSparkMax(2, MotorType.kBrushed);
    private final WPI_VictorSPX m_rightMotor2 = new WPI_VictorSPX(3);

    // Combine the left motors into one group, and the right motors into another
    private final MotorControllerGroup m_left = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
    private final MotorControllerGroup m_right = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);

    // Initialize DifferentialDrive object to utilize methods in the class
    //      Check WPILib for more info on the DifferentialDrive class:
    //      https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html
    //      https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html
    private final DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    
    // Set max speed, modify if too slow/fast
    private final double m_driveMaxSpeed = 0.8;

    public void init() {
        // Invert right side, as is standard
        //      Common cause of driving problems when first running an assembled chassis
        //      Modify inversions if chassis does not drive as expected, individual motor controllers can be inverted as well
        m_left.setInverted(false);
        m_right.setInverted(true);

        // Apply max speed
        m_drive.setMaxOutput(m_driveMaxSpeed);
    }

    public void periodic() {

    }

    // Control forward and rotation speeds of chassis
    public void arcadeDrive(double forward, double rot) {
        m_drive.arcadeDrive(forward, rot);
    }

    // Control left and right sides independently
    public void tankDrive(double left, double right) {
        m_drive.tankDrive(left, right);
    }
}
