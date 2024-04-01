package comp3005.project.club.Controller;

import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.Dashboard;
import comp3005.project.club.Entity.FitnessGoals;
import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.HealthMetrics;
import comp3005.project.club.Entity.HealthStatistics;
import comp3005.project.club.Entity.Member;
import comp3005.project.club.Entity.Schedule;
import comp3005.project.club.Entity.Training;
import comp3005.project.club.Service.MemberService;
import comp3005.project.club.Util.ResultData;
import java.util.ArrayList;
import java.util.HashSet;
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
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;



    @PostMapping("/register")
    public ResultData<Member> register(@RequestBody  Member member) {
        return memberService.register(member);
    }

    @GetMapping("/{email}")
    public ResultData<Member> getMemberByEmail(@PathVariable("email") String email) {
        Member member = memberService.getByEmail(email);
        if (member == null) {
            return ResultData.fail(400, "Not find the member!");
        } else {
            return ResultData.success(member);
        }
    }

    @GetMapping("/fitness/{email}")
    public ResultData<FitnessGoals> getFitness(@PathVariable("email") String email) {
        FitnessGoals fitnessGoals = memberService.getFitnessByEmail(email);
        if (fitnessGoals == null) {
            return ResultData.fail(400, "Not find the fitness!");
        } else {
            return ResultData.success(fitnessGoals);
        }
    }

    @GetMapping("/health/{email}")
    public ResultData<HealthMetrics> getHealth(@PathVariable("email") String email) {
        HealthMetrics healthMetrics = memberService.getHealthByEmail(email);

        if (healthMetrics == null) {
            return ResultData.fail(400, "Not find the health!");
        } else {
            return ResultData.success(healthMetrics);
        }
    }

    @PostMapping("/update")
    public ResultData<Member> updateMember(@RequestBody  Member member) {
        return memberService.update(member);
    }

    @PostMapping("/fitness")
    public ResultData<String> updateFitness(@RequestBody  FitnessGoals fitnessGoals) {
        // check
        FitnessGoals fitness = memberService.getFitnessByEmail(fitnessGoals.getMember_email());

        if(fitness == null){
            int row = memberService.saveFitness(fitnessGoals);

            if(row == 0){
                return ResultData.fail(400, "Fitness updated failed!");
            }
            return ResultData.success("Fitness updated success!");
        }

        int row = memberService.updateFitness(fitnessGoals);

        if(row == 0){
            return ResultData.fail(400, "Fitness updated failed!");
        }
        return ResultData.success("Fitness updated success!");
    }

    @PostMapping("/health")
    public ResultData<String> updateHealth(@RequestBody  HealthMetrics healthMetrics) {

        // check
        HealthMetrics health = memberService.getHealthByEmail(healthMetrics.getMember_email());

        if(health == null){
            int row = memberService.saveHealth(healthMetrics);

            if(row == 0){
                return ResultData.fail(400, "Health updated failed!");
            }
            return ResultData.success("Health updated success!");
        }
        int row = memberService.updateHealth(healthMetrics);

        if(row == 0){
            return ResultData.fail(400, "Health updated failed!");
        }
        return ResultData.success("Health updated success!");
    }

    @GetMapping("/dashboard/{email}")
    public ResultData<Dashboard> getDashboard(@PathVariable("email") String email) {
        Dashboard dashboard = memberService.getDashboardByEmail(email);
        if (dashboard == null) {
            return ResultData.fail(400, "Not find the dashboard!");
        } else {
            return ResultData.success(dashboard);
        }
    }

    @GetMapping("/statistics/{email}")
    public ResultData<HealthStatistics> getStatistics(@PathVariable("email") String email) {
        HealthStatistics healthStatistics = memberService.getHealthStaticsByEmail(email);
        if (healthStatistics == null) {
            return ResultData.fail(400, "Not find the statistics!");
        } else {
            return ResultData.success(healthStatistics);
        }
    }


    @GetMapping("/training/{email}")
    public ResultData<List<Training>> getTraining(@PathVariable("email") String email) {
        List<Training> trainings = memberService.getTrainingByEmail(email);

        if (trainings == null) {
            return ResultData.fail(400, "Not find training sessions!");
        } else {
            return ResultData.success(trainings);
        }
    }

    @GetMapping("/trainer/{email}")
    public ResultData<List<Training>> getAllTrainer(@PathVariable("email") String email) {
        // get all
        List<Training> trainings = memberService.getAllTrainer();
        // get current
        List<Training> curr = memberService.getTrainingByEmail(email);

        for(Training t:trainings){
            t.setMember_email(email);
        }
        trainings.removeAll(curr);


        if (trainings == null) {
            return ResultData.fail(400, "Not find available trainer!");
        } else {
            return ResultData.success(trainings);
        }
    }

    @PostMapping("/training/delete")
    public ResultData<String> deleteTraining(@RequestBody Training training) {
        boolean delete = memberService.deleteTraining(training);
        if(delete){
            return ResultData.success("Deleted!");
        }
        return ResultData.fail(400, "Deleted failed!");
    }

    @PostMapping("/training/add")
    public ResultData<String> addTraining(@RequestBody Training training) {
        boolean add = memberService.addTraining(training);
        if(add){
            return ResultData.success("Added!");
        }
        return ResultData.fail(400, "Add failed!");
    }


    @GetMapping("/group/{email}")
    public ResultData<List<GroupClass>> getGroup(@PathVariable("email") String email) {
        List<GroupClass> groupClasses = memberService.getGroupByEmail(email);

        if (groupClasses == null) {
            return ResultData.fail(400, "Not find group class!");
        } else {
            return ResultData.success(groupClasses);
        }
    }

    @GetMapping("/class/{email}")
    public ResultData<List<GroupClass>> getAllClass(@PathVariable("email") String email) {
        // get all
        List<GroupClass> all = memberService.getAllClass();
        // get current
        List<GroupClass> curr = memberService.getGroupByEmail(email);

        for(GroupClass t:all){
            t.setMember_email(email);
        }
        all.removeAll(curr);


        if (all == null) {
            return ResultData.fail(400, "Not find class!");
        } else {
            return ResultData.success(all);
        }
    }

    @PostMapping("/group/delete")
    public ResultData<String> deleteGroup(@RequestBody GroupClass groupClass) {
        boolean delete = memberService.deleteGroup(groupClass);
        if(delete){
            return ResultData.success("Deleted!");
        }
        return ResultData.fail(400, "Deleted failed!");
    }

    @PostMapping("/group/add")
    public ResultData<String> addTraining(@RequestBody GroupClass groupClass) {
        boolean add = memberService.addGroup(groupClass);
        if(add){
            return ResultData.success("Added!");
        }
        return ResultData.fail(400, "Add failed!");
    }


}