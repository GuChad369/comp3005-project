package comp3005.project.club.Service;

import comp3005.project.club.Entity.Dashboard;
import comp3005.project.club.Entity.FitnessGoals;
import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.HealthMetrics;
import comp3005.project.club.Entity.HealthStatistics;
import comp3005.project.club.Entity.Member;
import comp3005.project.club.Entity.Training;
import comp3005.project.club.Util.ResultData;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    ResultData<Member> register(Member member);

    int deleteByEmail(String email);

    List<Member> getAllMembers();

    Member getByEmail(String email);

    ResultData<Member> update(Member member);


    FitnessGoals getFitnessByEmail(String email);

    HealthMetrics getHealthByEmail(String email);

    int updateFitness(FitnessGoals fitnessGoals);

    int updateHealth(HealthMetrics healthMetrics);

    int saveFitness(FitnessGoals fitnessGoals);

    int saveHealth(HealthMetrics healthMetrics);

    Dashboard getDashboardByEmail(String email);

    HealthStatistics getHealthStaticsByEmail(String email);

    List<Training> getTrainingByEmail(String email);

    List<Training> getAllTrainer();

    boolean deleteTraining(Training training);

    boolean addTraining(Training training);

    List<GroupClass> getGroupByEmail(String email);

    List<GroupClass> getAllClass();

    boolean deleteGroup(GroupClass groupClass);

    boolean addGroup(GroupClass groupClass);


}
