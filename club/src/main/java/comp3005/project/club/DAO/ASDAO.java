package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.Schedule;
import java.util.List;

public interface ASDAO {

    List<Schedule> getSchedulesByEmail(String email);

    boolean deleteScheduleByAvailable(Available available);

    boolean saveSchedule(Schedule schedule);
}
