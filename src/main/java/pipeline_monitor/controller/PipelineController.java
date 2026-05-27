package pipeline_monitor.controller;

import pipeline_monitor.entity.Pipeline;
import pipeline_monitor.repository.PipelineRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/pipelines")
public class PipelineController {

    private final PipelineRepository pipelineRepository;

    public PipelineController(PipelineRepository pipelineRepository) {
        this.pipelineRepository = pipelineRepository;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Pipeline createPipeline(
            @RequestBody Pipeline pipeline
    ) {

        return pipelineRepository.save(pipeline);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','DEVELOPER')")
    public List<Pipeline> getAllPipelines() {

        return pipelineRepository.findAll();
    }
}