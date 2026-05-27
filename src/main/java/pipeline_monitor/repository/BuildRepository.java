package pipeline_monitor.repository;

import pipeline_monitor.entity.Build;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildRepository
        extends JpaRepository<Build, Long> {
}