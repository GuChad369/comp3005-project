package comp3005.project.club.Entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Available implements Serializable {

    @Id
    private String trainer_email;
    @Id
    private Integer time_id;
}
