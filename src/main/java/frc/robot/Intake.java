package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// This class controls the Intake mechanism, used for both intaking and placing
public class Intake {
    // Initialize motor controllers
    //      Initialized as a SparkMax with ID 5 connected to a Brushless motor (NEO550)
    private final CANSparkMax m_roller = new CANSparkMax(5, MotorType.kBrushless);

    // Set speed of arm, modify if too slow/fast (must be in between 0 and 1)
    private final double m_controlPower = 1.0;

    public void init() {
        // If intake rolls opposite to what is intended, simply invert the motor (change from false to true)
        m_roller.setInverted(false);
    }
            
    public void periodic() {

    }

    public void intake() {
        m_roller.set(m_controlPower);
    }

    public void outtake() {
        m_roller.set(m_controlPower * -1);
    }

    public void stop() {
        m_roller.set(0);
    }
}
