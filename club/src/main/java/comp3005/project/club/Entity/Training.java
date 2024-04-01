package comp3005.project.club.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Training implements Serializable {

    private String member_email;
    private String trainer_email;
    private Integer time_id ;
    private Date date;
    private Time start_time;
    private Time end_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;

        String str1 = member_email + trainer_email + time_id;
        String str2 = training.member_email + training.trainer_email + training.time_id;
        return str1.equals(str2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member_email, trainer_email, time_id);
    }
}
