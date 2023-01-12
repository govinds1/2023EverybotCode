package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;

// This class controls motion of the Arm
public class Arm {
    // Initialize motor controllers
    //      Initialized as a SparkMax with ID 4 connected to a Brushless motor (NEO)
    private final CANSparkMax m_arm = new CANSparkMax(4, MotorType.kBrushless);

    // Set speed of arm, modify if too slow/fast (must be in between 0 and 1)
    private final double m_controlPower = 0.6;

    public void init() {
        // If arm moves opposite to what is intended, simply invert the motor (change from false to true)
        m_arm.setInverted(false);
    }

    public void periodic() {

    }

    public void manualDrive(double speed) {
        // Apply a deadband to avoid issues due to joystick drift
        //      default deadband is 0.05, modify as needed
        speed = MathUtil.applyDeadband(speed, 0.05);
        m_arm.set(speed);
    }

    public void extend() {
        m_arm.set(m_controlPower);
    }
    
    public void retract() {
        m_arm.set(m_controlPower * -1);
    }

    public void stop() {
        m_arm.set(0);
    }
}
