package pipeline_monitor.dto;

import pipeline_monitor.entity.BuildStatus;

public class UpdateBuildStatusRequest {

    private BuildStatus status;

    public BuildStatus getStatus() {
        return status;
    }

    public void setStatus(BuildStatus status) {
        this.status = status;
    }
}