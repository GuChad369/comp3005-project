package comp3005.project.club.Entity;

import java.sql.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {

    private String member_email;
    private Date date;
    private Time time;
    private String project_name;
    private String card_number;
    private Double subtotal;
    private Double hst;
    private Double total;
}
