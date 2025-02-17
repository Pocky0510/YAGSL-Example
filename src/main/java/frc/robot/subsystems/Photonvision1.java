package frc.robot.subsystems;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.List;

import org.photonvision.*;

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Photonvision1 extends SubsystemBase {

    public PhotonCamera camera = new PhotonCamera("photonvision1");
    // public PhotonCamera camera2 = new PhotonCamera("Photonvision2");
    
    private PhotonPipelineResult result1 = camera.getLatestResult();
    // private PhotonPipelineResult result2 = camera1.getLatestResult();
    PhotonTrackedTarget target = result1.getBestTarget();
    public Photonvision1() {
        updateTarget();
    }

    public double Area = 0;
    public double Yaw = 0;

    public void setPipeline1() {
        camera.setPipelineIndex(0);
    }
    public void setPipeline2() {
        camera.setPipelineIndex(1);
    }

    private void updateTarget() {
        result1 = camera.getLatestResult();
        if (result1.hasTargets()) {
            target = result1.getBestTarget();
            if (target != null) {
                Area = target.getArea();
                Yaw = target.getYaw();
            }
        } else {
            target = null;
            Area = 0;
            Yaw = 0;
        }
    }
    public boolean hasTarget1() {

        PhotonPipelineResult Result1 = camera.getLatestResult();
        return Result1.hasTargets();
        }

    boolean hastarget1 = result1.hasTargets();

    @Override
    public void periodic() {
        updateTarget();
        
}


}