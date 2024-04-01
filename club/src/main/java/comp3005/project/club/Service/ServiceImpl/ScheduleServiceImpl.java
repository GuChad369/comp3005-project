package comp3005.project.club.Service.ServiceImpl;

import comp3005.project.club.DAO.Impl.ASJdbc;
import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.Schedule;
import comp3005.project.club.Service.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ASJdbc asJdbc;

    @Override public List<Schedule> getByEmail(String email) {
        return asJdbc.getSchedulesByEmail(email);
    }

    @Override public boolean deleteByAvailable(Available available) {
        return asJdbc.deleteScheduleByAvailable(available);
    }

    @Override public boolean save( Schedule schedule) {
        return asJdbc.saveSchedule(schedule);
    }
}
