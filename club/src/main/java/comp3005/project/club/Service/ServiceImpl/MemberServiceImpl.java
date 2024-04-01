package comp3005.project.club.Service.ServiceImpl;

import comp3005.project.club.DAO.Impl.DashboardJdbc;
import comp3005.project.club.DAO.Impl.FitnessGoalsJdbc;
import comp3005.project.club.DAO.Impl.GroupClassJdbc;
import comp3005.project.club.DAO.Impl.HealthMetricsJdbc;
import comp3005.project.club.DAO.Impl.HealthStatisticsJdbc;
import comp3005.project.club.DAO.Impl.MemberJdbc;
import comp3005.project.club.DAO.Impl.TrainingJdbc;
import comp3005.project.club.Entity.Dashboard;
import comp3005.project.club.Entity.FitnessGoals;
import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.HealthMetrics;
import comp3005.project.club.Entity.HealthStatistics;
import comp3005.project.club.Entity.Member;
import comp3005.project.club.Entity.Training;
import comp3005.project.club.Service.MemberService;
import comp3005.project.club.Util.ResultData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberJdbc memberJdbc;
    @Autowired
    private FitnessGoalsJdbc fitnessGoalsJdbc;
    @Autowired
    private HealthMetricsJdbc healthMetricsJdbc;
    @Autowired
    private DashboardJdbc dashboardJdbc;
    @Autowired
    private HealthStatisticsJdbc healthStatisticsJdbc;
    @Autowired
    private TrainingJdbc trainingJdbc;
    @Autowired
    private GroupClassJdbc groupClassJdbc;


    @Override public ResultData<Member> register(Member member) {
        ResultData<Member> result = new ResultData<>();
        Member getMember = memberJdbc.findByEmail(member.getEmail());
        // check
        if (getMember != null) {
            result.fail(400, "Member already exists!");
            return result;
        }
        int row = memberJdbc.save(member);
        if(row == 0){
            result.fail(400, "Register failed!");
            return result;
        }
        result.success(member);
        return result;
    }

    @Override public int deleteByEmail(String email) {
        return memberJdbc.deleteByEmail(email);
    }

    @Override public List<Member> getAllMembers() {
        return memberJdbc.findAll();
    }

    @Override public Member getByEmail(String email) {
        return memberJdbc.findByEmail(email);
    }

    @Override public ResultData<Member> update(Member member) {
        ResultData<Member> result = new ResultData<>();
        Member getMember = memberJdbc.findByEmail(member.getEmail());
        // check
        if (getMember == null) {
            result.fail(400, "Member does not exist!");
            return result;
        }
        int row = memberJdbc.update(member);
        if(row == 0){
            result.fail(400, "Member update failed!");
            return result;
        }
        result.success(member);
        return result;
    }

    @Override public FitnessGoals getFitnessByEmail(String email) {
        return fitnessGoalsJdbc.findByEmail(email);
    }

    @Override public HealthMetrics getHealthByEmail(String email) {
        return healthMetricsJdbc.findByEmail(email);
    }

    @Override public int updateFitness(FitnessGoals fitnessGoals) {
        return fitnessGoalsJdbc.update(fitnessGoals);
    }

    @Override public int updateHealth(HealthMetrics healthMetrics) {
        return healthMetricsJdbc.update(healthMetrics);
    }

    @Override public int saveFitness(FitnessGoals fitnessGoals) {
        return fitnessGoalsJdbc.save(fitnessGoals);
    }

    @Override public int saveHealth(HealthMetrics healthMetrics) {
        return healthMetricsJdbc.save(healthMetrics);
    }

    @Override public Dashboard getDashboardByEmail(String email) {
        return dashboardJdbc.getByEmail(email);
    }

    @Override public HealthStatistics getHealthStaticsByEmail(String email) {
        return healthStatisticsJdbc.getByEmail(email);
    }

    @Override public List<Training> getTrainingByEmail(String email) {
        return trainingJdbc.getByMemberEmail(email);
    }

    @Override public List<Training> getAllTrainer() {
        return trainingJdbc.getAllTrainer();
    }

    @Override public boolean deleteTraining(Training training) {
        return trainingJdbc.deleteOne(training);
    }

    @Override public boolean addTraining(Training training) {
        return trainingJdbc.addOne(training);
    }

    @Override public List<GroupClass> getGroupByEmail(String email) {
        return groupClassJdbc.getByMemberEmail(email);
    }

    @Override public List<GroupClass> getAllClass() {
        return groupClassJdbc.getAllClass();
    }

    @Override public boolean deleteGroup(GroupClass groupClass) {
        return groupClassJdbc.deleteOne(groupClass);
    }

    @Override public boolean addGroup(GroupClass groupClass) {
        return groupClassJdbc.addOne(groupClass);
    }

}
