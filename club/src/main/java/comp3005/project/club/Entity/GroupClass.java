package comp3005.project.club.Entity;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupClass {
    private String member_email;
    private Integer class_id;
    private String class_name;
    private Integer room_id;
    private String room_number;
    private Integer time_id;
    private Date date;
    private Time start_time;
    private Time end_time;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupClass groupClass = (GroupClass) o;

        String str1 = member_email +class_id;
        String str2 = groupClass.member_email + groupClass.class_id;
        return str1.equals(str2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member_email, class_id);
    }
}
