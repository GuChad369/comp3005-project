package comp3005.project.club.DAO;

import comp3005.project.club.Entity.FitnessGoals;

public interface FitnessGoalsDAO {

    FitnessGoals findByEmail(String email);

    int update(FitnessGoals fitnessGoals);

    int save(FitnessGoals fitnessGoals);
}
