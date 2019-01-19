/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private Joystick leftStick;
  private TalonSRX motor;
  DigitalInput limitSwitchZero;
  DigitalInput limitSwitchOne;
  DigitalInput limitSwitchTwo;
  DigitalInput limitSwitchThree;

  @Override
  public void robotInit() {
    leftStick = new Joystick(0);
    motor = new TalonSRX(0);

    limitSwitchZero = new DigitalInput(0);
    limitSwitchOne = new DigitalInput(1);
    limitSwitchTwo = new DigitalInput(2);
    limitSwitchThree = new DigitalInput(3);
  }

  @Override
  public void teleopPeriodic() {
   motor.set(ControlMode.PercentOutput, leftStick.getX());
  }
  public void limitSwitches() {
      // level zero
        if (limitSwitchZero.get() && limitSwitchOne.get()==false && limitSwitchTwo.get()==false && limitSwitchThree.get()==false){
         System.out.println("level zero");
      }
      // level one
        else if (limitSwitchZero.get()==false && limitSwitchOne.get() && limitSwitchTwo.get()==false && limitSwitchThree.get()==false){
          System.out.println("level one");
        }
      //level two
       else if (limitSwitchZero.get()==false && limitSwitchOne.get() && limitSwitchTwo.get() && limitSwitchThree.get()==false) {
          System.out.println("level two");
        }
      // level three
        else if (limitSwitchZero.get()==false && limitSwitchOne.get() && limitSwitchTwo.get() && limitSwitchThree.get()){
          System.out.println("level three");
        }
        else {
          System.out.println("error");
        }
    }
  }
