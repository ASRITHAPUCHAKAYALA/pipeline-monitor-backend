package pipeline_monitor.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pipeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private String environment;

    private String status;

   @OneToMany(mappedBy = "pipeline",
        cascade = CascadeType.ALL)
@JsonManagedReference
private List<Build> builds;
}