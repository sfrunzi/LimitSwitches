package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;;


public class Robot extends TimedRobot {
  // private Joystick leftStick;
  private TalonSRX motor;
  DigitalInput limitSwitchOne;
  DigitalInput limitSwitchTwo;
  DigitalInput limitSwitchThree;
  private Joystick controlPanel;


  @Override
  public void robotInit() {
    // leftStick = new Joystick(0);
    motor = new TalonSRX(0);

    limitSwitchOne = new DigitalInput(1);
    limitSwitchTwo = new DigitalInput(2);
    limitSwitchThree = new DigitalInput(3);
  }

  @Override
  public void teleopPeriodic() {
   // motor.set(ControlMode.PercentOutput, leftStick.getX());
   limitSwitches();

   ShuffleboardTab shuffleTab = Shuffleboard.getTab("Main");         // says what tab we're dealing with
   NetworkTableEntry buttonValue = shuffleTab.add("button", true).getEntry();    // makes a button exist. If button is pressed, true. If not pressed, false.
   boolean  value = buttonValue.getBoolean(false); // turns button into boolean, if above line doesn't give true/false, converts to false.
   System.out.println(value);
  }
  public void limitSwitches() {
    
      // level one
        if (limitSwitchOne.get() && limitSwitchTwo.get()==false && limitSwitchThree.get()==false){
          System.out.println("level one");
        }
      //level two
       else if (limitSwitchOne.get() && limitSwitchTwo.get() && limitSwitchThree.get()==false) {
          System.out.println("level two");
        }
      // level three
        else if (limitSwitchOne.get() && limitSwitchTwo.get() && limitSwitchThree.get()){
          System.out.println("level three");
        }
        else {
          System.out.println("error");
        }
        controlPanel = new Joystick(0);
       // This is for the elevator up button
        if (controlPanel.getRawButton(2)) {
          System.out.println("up button");
          motor.set(ControlMode.PercentOutput, 1);
        }
        // This is for the elevator down button
        else if (controlPanel.getRawButton(3)){
          System.out.println("down button");
          motor.set(ControlMode.PercentOutput, -1);
        }
        else {
          motor.set(ControlMode.PercentOutput, 0);
        }
    }   
  }
