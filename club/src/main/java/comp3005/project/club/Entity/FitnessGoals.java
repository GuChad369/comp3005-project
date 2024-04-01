package comp3005.project.club.Entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FitnessGoals implements Serializable {

    @Id
    private String member_email;
    private Integer time_goal;
    private Integer weight_goal;
}
