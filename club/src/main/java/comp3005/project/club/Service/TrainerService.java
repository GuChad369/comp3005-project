package comp3005.project.club.Service;

import comp3005.project.club.Entity.Member;
import comp3005.project.club.Entity.Trainer;
import comp3005.project.club.Util.ResultData;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TrainerService {

    ResultData<Trainer> register(Trainer trainer);

    int deleteByEmail(String email);

    List<Trainer> getAllTrainers();

    Trainer getByEmail(String email);

    ResultData<Trainer> update(Trainer trainer);
}
