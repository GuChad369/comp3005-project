package comp3005.project.club.Service;

import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.Schedule;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {

    List<Schedule> getByEmail(String email);

    boolean deleteByAvailable(Available available);

    boolean save(Schedule schedule);
}
