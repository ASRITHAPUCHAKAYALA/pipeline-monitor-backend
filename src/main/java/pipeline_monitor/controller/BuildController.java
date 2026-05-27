package pipeline_monitor.controller;

import pipeline_monitor.entity.Build;
import pipeline_monitor.entity.BuildStatus;
import pipeline_monitor.entity.Pipeline;

import pipeline_monitor.repository.BuildRepository;
import pipeline_monitor.repository.PipelineRepository;

import pipeline_monitor.dto.UpdateBuildStatusRequest;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/builds")
public class BuildController {

    private final BuildRepository buildRepository;
    private final PipelineRepository pipelineRepository;

    public BuildController(
            BuildRepository buildRepository,
            PipelineRepository pipelineRepository
    ) {
        this.buildRepository = buildRepository;
        this.pipelineRepository = pipelineRepository;
    }

    @PostMapping("/{pipelineId}")
    public Build createBuild(
            @PathVariable Long pipelineId,
            @RequestBody Build build
    ) {

        Pipeline pipeline = pipelineRepository.findById(pipelineId)
                .orElseThrow(() -> new RuntimeException("Pipeline Not Found"));

        build.setPipeline(pipeline);

        build.setStartedAt(LocalDateTime.now());

        build.setStatus(BuildStatus.RUNNING);

        return buildRepository.save(build);
    }

    @PutMapping("/{buildId}/status")
    public Build updateBuildStatus(
            @PathVariable Long buildId,
            @RequestBody UpdateBuildStatusRequest request
    ) {

        Build build = buildRepository.findById(buildId)
                .orElseThrow(() -> new RuntimeException("Build Not Found"));

        build.setStatus(request.getStatus());

        if (request.getStatus() == BuildStatus.SUCCESS ||
                request.getStatus() == BuildStatus.FAILED) {

            build.setEndedAt(LocalDateTime.now());
        }

        return buildRepository.save(build);
    }
}