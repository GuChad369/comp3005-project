package comp3005.project.club.Entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HealthStatistics implements Serializable {

    @Id
    private String member_email;
    private Integer heartbeat ;
    private Integer systolic ;
    private Integer diastolic ;
    private Integer cholesterol_levels ;
}
