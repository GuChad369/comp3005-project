package comp3005.project.club.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule implements Serializable {
    @Id
    private Integer id;
    private Date date;
    private Time start_time;
    private Time end_time;
    private String email;
}
