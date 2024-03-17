package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp()
public class Drivermode extends OpMode {
    
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor armmotor;
    
    @Override
    public void init() 
    {
        leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor = hardwareMap.get(DcMotor.class, "rightmotor");
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armmotor = hardwareMap.get(DcMotor.class, "armmotor");
        armmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addData("Hello","World");
    }
    
    boolean reverse = false;
    double speedmult = 1.0;
    double leftmotorpval = 0;
    double rightmotorpval = 0;
    
    //hang vars
    boolean hanglock = false;
    boolean hanging = false;
    int hanglockcounter = 0;
    
    //hang function
    private void hang()
    {
        armmotor.setPower(.5);
    }
    
    @Override
    public void loop() 
    {
        //left stick left motor
        //right stick is right motor
        
        //slow
        if(gamepad1.y) { speedmult = .05; }
        else { speedmult = 1; }
        
        leftmotor.setPower(gamepad1.left_stick_y*speedmult);
        rightmotor.setPower(gamepad1.right_stick_y*speedmult);
        
        //hang control
        /*
        if(hanglock)
        {
            hang();
            if (gamepad1.b)
            {
                hanglock=false;
                hanglockcounter = 0;
            }
            telemetry.addData("hanging",1);
        }
        else 
        {
            telemetry.addData("hang counter", hanglockcounter);
            if(gamepad1.x)
            {
                hang();
                hanglockcounter++;
            }
            if(hanglockcounter > 1000)
            {
                telemetry.addData("Hang Ready",1);
            }
            else if(hanglockcounter > 1000 && gamepad1.b) { hanglockcounter = 0; }
            if(hanglockcounter > 1000 && !gamepad1.x) { hanglock = true; }
        }
        */
        
        if(gamepad1.left_bumper)
        {
            armmotor.setPower(.5);
        } else if (gamepad1.left_trigger > 0)
        {
            armmotor.setPower(-.5);
        }
        else
        {
            armmotor.setPower(0);
        }
        
        //controller data
        telemetry.addData("Backwards", reverse);
        telemetry.addData("Left motor pos", leftmotor.getCurrentPosition());
        telemetry.addData("Right motor pos", rightmotor.getCurrentPosition());
        telemetry.addData("Y:", gamepad1.y);
        telemetry.addData("X:", gamepad1.x);
        telemetry.addData("B:", gamepad1.b);
        telemetry.addData("A:", gamepad1.a);
        telemetry.addData("left stick x:", -gamepad1.left_stick_x);
        telemetry.addData("left stick y:", -gamepad1.left_stick_y);
        telemetry.addData("right stick x:", -gamepad1.right_stick_x);
        telemetry.addData("right stick y:", -gamepad1.right_stick_y);
        
        
    }
}









