package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Training;
import java.util.List;

public interface TrainingDAO {

    List<Training> getByMemberEmail(String email);

    List<Training> getAllTrainer();

    boolean deleteOne(Training training);

    boolean addOne(Training training);

}
