package comp3005.project.club.Entity;

import java.sql.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {

    private Integer id;
    private String room_number;
    private Integer time_id;
    private Date date;
    private Time start_time;
    private Time end_time;
}
