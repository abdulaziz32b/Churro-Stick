package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp

public class Churro extends LinearOpMode {
    //create variables and hardware

    DcMotorEx fl, fr, bl, br, lShoot, rShoot, intake;
    Servo blocker;

    double closedPos = 0.8;

    double shootPower = -1;
    int targetVelocity = 2000;
    double openPos = 0.2;

    public void runOpMode() {
        //hardware mapping and initialization code
        // fl = hardwareMap.get(DcMotorEx.class, "frontLeft");
        // fr = hardwareMap.get(DcMotorEx.class, "frontRight");
        // bl = hardwareMap.get(DcMotorEx.class, "backLeft");
        // br = hardwareMap.get(DcMotorEx.class, "backRight");
        lShoot = hardwareMap.get(DcMotorEx.class, "Left shooter");
        rShoot = hardwareMap.get(DcMotorEx.class, "Right shooter");
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        // blocker = hardwareMap.get(Servo.class, "blocker");

        // //reverse motors

        // blocker.setPosition(closedPos);

        waitForStart();

        while(opModeIsActive()) {

            if(gamepad1.right_trigger > 0.05) {
                intake.setPower(1.0);
            } else if(gamepad1.left_trigger > 0.05) {
                intake.setPower(-1.0);
            } else {
                intake.setPower(0.0);
            }

            if(gamepad1.a) {
                lShoot.setPower(shootPower);
                rShoot.setPower(shootPower);
            } else {
                lShoot.setPower(0.0);
                rShoot.setPower(0.0);
            }

            // if(lShoot.getVelocity() > targetVelocity) {
            //     blocker.setPosition(openPos);
            // } else {
            //     blocker.setPosition(closedPos);
            // }

            // double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            // double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            // double rx = gamepad1.right_stick_x;

            // // Denominator is the largest motor power (absolute value) or 1
            // // This ensures all the powers maintain the same ratio,
            // // but only if at least one is out of the range [-1, 1]
            // double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            // double frontLeftPower = (y + x + rx) / denominator;
            // double backLeftPower = (y - x + rx) / denominator;
            // double frontRightPower = (y - x - rx) / denominator;
            // double backRightPower = (y + x - rx) / denominator;

            // fl.setPower(frontLeftPower);
            // bl.setPower(backLeftPower);
            // fr.setPower(frontRightPower);
            // br.setPower(backRightPower);
        }
    }
}
