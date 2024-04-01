package comp3005.project.club.Entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

// map to table member
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member implements Serializable {

    @Id
    private String email;
    private String first_name;
    private String last_name;
    private String phone;

}
