package pipeline_monitor.repository;

import pipeline_monitor.entity.Pipeline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PipelineRepository
        extends JpaRepository<Pipeline, Long> {
}