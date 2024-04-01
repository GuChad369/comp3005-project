package comp3005.project.club.Controller;


import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.HealthMetrics;
import comp3005.project.club.Entity.Member;
import comp3005.project.club.Entity.Schedule;
import comp3005.project.club.Service.ScheduleService;
import comp3005.project.club.Util.ResultData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/delete")
    public ResultData<String> delete(@RequestBody  Available available) {
        boolean delete = scheduleService.deleteByAvailable(available);
        if(delete){
            return ResultData.success("Deleted!");
        }
        return ResultData.fail(400, "Deleted failed!");
    }

    @PostMapping("/add")
    public ResultData<String> add(@RequestBody  Schedule schedule) {
        boolean add =scheduleService.save(schedule);
        if(add){
            return ResultData.success("Add!");
        }
        return ResultData.fail(400, "Add failed!");
    }
    
    @GetMapping("/schedule/{email}")
    public ResultData<List<Schedule>> getScheduleByEmail(@PathVariable("email") String email) {
        List<Schedule> schedules = scheduleService.getByEmail(email);
        // delete any duplicate one
        Set<String> uniqueSchedules = new HashSet<>();
        Set<Integer> remove = new HashSet<>();
        // Iterate over the schedules and delete duplicates
        for (int i = 0; i < schedules.size(); i++) {
            String scheduleKey = schedules.get(i).getDate().toString() + schedules.get(i).getStart_time().toString() + schedules.get(i).getEnd_time().toString();
            boolean flag = uniqueSchedules.add(scheduleKey);
            if (!flag) {
                remove.add(i);
            }
        }
        // remove
        Iterator<Schedule> iterator = schedules.iterator();
        int currentIndex = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (remove.contains(currentIndex)) {
                iterator.remove();
            }
            currentIndex++;
        }


        if (schedules == null || schedules.size() == 0) {
            return ResultData.fail(400, "Not have any schedule!");
        } else {
            return ResultData.success(schedules);
        }
    }

}
