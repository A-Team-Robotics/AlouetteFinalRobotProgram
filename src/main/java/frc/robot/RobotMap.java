/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 
    //CAN PINS
    public static final int BACK_LEFT_MOTOR = 2;
    public static final int BACK_RIGHT_MOTOR = 1;
    public static final int FRONT_LEFT_MOTOR = 4;
    public static final int FRONT_RIGHT_MOTOR = 3;
    public static final int ELEVATOR_MOTOR = 5;
    public static final int GRIPPER_MOTOR = 9;
    public static final int BALL_COLLECTOR_MOTOR_ONE = 6;
    public static final int BALL_COLLECTOR_MOTOR_TWO = 7;
    public static final int ROLLER_MOTOR_LEFT = 11;
    public static final int ROLLER_MOTOR_RIGHT = 12;
    public static final int TURRET_SLIDE_MOTOR = 8;
    public static final int TURRET_TURN_MOTOR = 10;
    public static final int COMPRESSOR = 0;

    //Digital Pins
    public static final int ELAVATOR_TOP_LIMIT = 0;
    public static final int ELAVATOR_BOTTOM_LIMIT = 1;
    public static final int TURRET_RIGHT_LIMIT = 4;
    public static final int TURRET_LEFT_LIMIT = 6;
    public static final int TURRET_SLIDE_FORWARD = 8;
    public static final int TURRET_SLIDE_BACKWARD = 9;
    public static final int ARM_BUTTON_STOP = 5;
    public static final int GRIPPER_BUTTON_STOP = 3;

    //Analog/Relay Pins
    public static final int COLLECTOR_POTENTIOMETER_ONE = 0;
    public static final int COLLECTOR_POTENTIOMETER_TWO = 1;
    public static final int TURRET_SLIDE_POTENTIOMETER = 2;

    //PCM Pins
    public static final int[] LOWER_GRIPPER_SOLENOID = {1,0};
    public static final int[] UPPER_GRIPPER_SOLENOID = {6,7};
    public static final int[] BALL_COLLECTOR_SOLENOID = {5,4};
    public static final int LED_RING_ONE = 2;

    //Motor Speeds
    public static double rollersSpeed = 0.4, slideSpeed = 0.8, ballGripperSpeed = 1.0;
    public static double driveSpeed = 1;

    //Encoder and Potentiometer Values System Positions
    public static int elevatorPos1 = 0, elevatorHumanLoad = 34711,
    elevatorPos2 = 41948, elevatorPos3 = 90000, elevatorHatchLevel = 2500, elevatorCargoLevel = 49000, 
    arm2Max = 532, arm2Min=208, arm1Max= 60000, arm1Min = 0;

    //Turret Encoder Limits
    public static  int turretMin = 0;

    public static  int turretMax = 7854;

    public static  int turret0 = turretMin + 475;

    public static  int turret180 = turretMax - 475;       

    public static  int turret45 = turretMin + (turret0-turret180)/4;

    public static  int turret90 = (turret0+turret180)/2;

    public static  int turret135 = turret90 + (turret0-turret180)/4;

    //---------------------------------------------------------------------------------------------------------------------------//

    public static final int elevatorClearGripper = 38000;

    public static final int arm2RetractPosFinal = 603;
    
    public static final int arm2CollectPosfinal = arm2RetractPosFinal-220;

    public static final int arm2RetractPos1 = arm2CollectPosfinal + 10;

    public static final int arm2LoadPos = arm2RetractPosFinal - 280;

    //BallCollector Deploy Positions 
    public static int arm2DS1 = (arm2Max-40), arm2SD2 = (arm2Max-220), arm1DS1 = 18000;

    //public static int deploy1PosFinal = 18100, deploy2Pos1 = arm2Max-40, deploy2PosFinal = deploy2Pos1-220;

    //Ball Collector Retract Positions
    public static int arm2CS1 = (arm2Max-40), arm2CS2 = (arm2Max-220), arm1CS1 = 18200, arm1CS2 = 0;

    //Ball Collector Transfer Positions
    public static int arm1TS1 = 17500, arm2TS1 = (arm2Max-329);

    //Other
    public static int CM_CONVERSION = 360;
    public static int elevatorError = 20;
    public static int arm1Error = 0;
    public static int arm2Error = 2;
    
    //Drive Controller
    public static int changeSpeed = 8, deliverPayload = 1, deployCollector = 2, retractCollector = 3, climb = 5, driveMode = 6;
    //Joystick Controller 
    public static int closeGripper = 2, recieveBall = 3, recieveHatch = 4, elevatorLevel1 = 11, elevatorLevel2 = 9, elevatorLevel3 = 7,
    elevatorHumanRecieve = 10, slideFront = 6, slideBack = 5, slideControl = 7;

    //Joystick Ports
    public static int driveController = 0, joystickController = 1;
    //Driver Selection Enumeration
    private static Driver _currentDriver = null;

    /**
   * Driver Name enum
   * Select which drivers controls to change
   */
    public enum Driver{
        STANDARD,
        ADAMT,
        JUSTIND,
    }

    /** 
   * Controller Enum
   * What controller to change
   */
    public enum Controller{
        DRIVE,
        FUNCTIONS
    }

    /**
   * Change the mapped button values for each controller
   *
   * <p>Changes the set values for what button on the controller controls which robot action
   *
   * @param Driver enum and the Controller enum
   */
    public static void selectDriver(Driver driver,Controller controller){
        if(controller == Controller.DRIVE){
            if(driver == Driver.ADAMT){
                _currentDriver = Driver.ADAMT;
                changeSpeed = 8; deliverPayload = 1; deployCollector = 2; retractCollector = 3; climb = 5; driveMode = 6;
                closeGripper = 2; recieveBall = 3; recieveHatch = 4; elevatorLevel1 = 11; elevatorLevel2 = 9; 
                elevatorLevel3 = 7;elevatorHumanRecieve = 10;
            }
            if(driver == Driver.JUSTIND){
                _currentDriver = Driver.JUSTIND;
                changeSpeed = 8; deliverPayload = 1; deployCollector = 2; retractCollector = 3; climb = 5; driveMode = 6;
                closeGripper = 2; recieveBall = 3; recieveHatch = 4; elevatorLevel1 = 11; elevatorLevel2 = 9; 
                elevatorLevel3 = 7;elevatorHumanRecieve = 10;
            }
        }else{
            if(driver == Driver.ADAMT){
                _currentDriver = Driver.ADAMT;
                changeSpeed = 8; deliverPayload = 1; deployCollector = 2; retractCollector = 3; climb = 5; driveMode = 6;
                closeGripper = 2; recieveBall = 3; recieveHatch = 4; elevatorLevel1 = 11; elevatorLevel2 = 9; 
                elevatorLevel3 = 7;elevatorHumanRecieve = 10;
            }
            if(driver == Driver.JUSTIND){
                _currentDriver = Driver.JUSTIND;
                changeSpeed = 8; deliverPayload = 1; deployCollector = 2; retractCollector = 3; climb = 5; driveMode = 6;
                closeGripper = 2; recieveBall = 3; recieveHatch = 4; elevatorLevel1 = 11; elevatorLevel2 = 9; 
                elevatorLevel3 = 7;elevatorHumanRecieve = 10;
            }
        }
    }

    public static Driver getCurrentDrive() {
        return _currentDriver;
    }

    //State Enumerations
    /**
   * Payload enum
   * Select which drivers controls to change
   */
    public enum Payload{
        HATCH,
        BALL,
        NULL,
    }

     /**
   * RollerSpeed enum
   * Select which drivers controls to change
   */
    public enum RollerSpeed{
        FORWARD,
        REVERSE,
        STOP,
    }
    /**
   * Pnuematics enum
   * Select which drivers controls to change
   */
  public enum PnuematicArm{
    OPEN,
    CLOSE,
}
}
/*
 * XBOX BUTTON MAPPING FOR DRIVER STATION AS FOLLOWS
 * Button 1 = A
 * Button 2 = B
 * Button 3 = X OR small left wheel button up
 * Button 4 = Y
 * Button 5 = Left Bumper
 * Button 6 = Right Bumper OR small right wheel down
 * Button 7 = Select / Menu Button
 * Button 8 = Start / Enter Button
 * Button 9 = Click in Left Analog Stick OR small left wheel down
 * Button 10 = Click in Right Analog Stick
 * 
 * Axis 0 = Left stick left + right
 * Axis 1 = Left stick up + down
 * Axis 2 = Left trigger
 * Axis 3 = Right trigger
 * Axis 4 = Right stick left + right
 * Axis 5 = Right stick up + down
 * 
 * POV = D-Pad
 * POV LEFT = small right wheel up
 */
