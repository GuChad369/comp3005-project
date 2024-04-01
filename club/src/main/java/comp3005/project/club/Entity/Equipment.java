package comp3005.project.club.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Equipment {

    private Integer id;
    private String model;
    private Integer room_id;
    private Integer status;
    private String room_number;
}
