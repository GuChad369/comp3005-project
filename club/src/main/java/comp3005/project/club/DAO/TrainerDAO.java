package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Trainer;
import java.util.List;

public interface TrainerDAO {
    Trainer findByEmail(String email);

    int deleteByEmail(String email);

    List<Trainer> findAll();

    int save(Trainer member);

    int update(Trainer member);
}
