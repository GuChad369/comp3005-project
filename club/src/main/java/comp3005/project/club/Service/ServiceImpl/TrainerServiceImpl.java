package comp3005.project.club.Service.ServiceImpl;


import comp3005.project.club.DAO.Impl.TrainerJdbc;
import comp3005.project.club.Entity.Trainer;
import comp3005.project.club.Service.TrainerService;
import comp3005.project.club.Util.ResultData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerJdbc trainerJdbc;


    @Override public ResultData<Trainer> register(Trainer trainer) {
        ResultData<Trainer> result = new ResultData<>();
        Trainer getTrainer = trainerJdbc.findByEmail(trainer.getEmail());
        // check
        if (getTrainer != null) {
            result.fail(400, "Trainer already exists!");
            return result;
        }
        trainerJdbc.save(trainer);
        result.success(trainer);
        return result;
    }

    @Override public int deleteByEmail(String email) {
        return trainerJdbc.deleteByEmail(email);
    }

    @Override public List<Trainer> getAllTrainers() {
        return trainerJdbc.findAll();
    }

    @Override public Trainer getByEmail(String email) {
        return trainerJdbc.findByEmail(email);
    }

    @Override public ResultData<Trainer> update(Trainer trainer) {
        ResultData<Trainer> result = new ResultData<>();
        Trainer getTrainer = trainerJdbc.findByEmail(trainer.getEmail());
        // check
        if (getTrainer != null) {
            result.fail(400, "Trainer already exists!");
            return result;
        }
        trainerJdbc.update(trainer);
        result.success(trainer);
        return result;
    }
}
