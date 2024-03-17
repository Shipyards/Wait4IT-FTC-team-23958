package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class Automode extends OpMode {

    //define motors
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor armmotor;
    
    private void _stop()
    {
        leftmotor.setPower(0);
        rightmotor.setPower(0);
    }
    
    @Override
    public void init() 
    {
        leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        leftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightmotor = hardwareMap.get(DcMotor.class, "rightmotor");
        rightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotor = hardwareMap.get(DcMotor.class, "armmotor");
        armmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //armmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addData("Hello","World");
        telemetry.addData("Left motor pos", leftmotor.getCurrentPosition());
        telemetry.addData("Right motor pos", rightmotor.getCurrentPosition());
    }
    
    boolean started = false;
    
    @Override
    public void loop()
    {
        if(!started)
        {
            rightmotor.setPower(.4);
            leftmotor.setPower(.4);
            rightmotor.setTargetPosition(rightmotor.getCurrentPosition()+10);
            leftmotor.setTargetPosition(leftmotor.getCurrentPosition()+10);
            leftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            started = true;
        }
        telemetry.addData("Left motor power", leftmotor.getPower());
        telemetry.addData("Right motor power", rightmotor.getPower());
        telemetry.addData("Left motor pos", leftmotor.getCurrentPosition());
        telemetry.addData("Right motor pos", rightmotor.getCurrentPosition());
        telemetry.addData("target Left motor pos", leftmotor.getTargetPosition());
        telemetry.addData("target Right motor pos", rightmotor.getTargetPosition());
    }
}