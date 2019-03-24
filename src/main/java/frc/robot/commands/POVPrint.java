package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class POVPrint extends InstantCommand {

    String msg = "";
    String key = "";
    public POVPrint(String msg, String key) {
        this.msg=msg;
        this.key=key;
    }
    
    @Override
    protected void initialize() {
        SmartDashboard.putString(key, msg);
    }
}