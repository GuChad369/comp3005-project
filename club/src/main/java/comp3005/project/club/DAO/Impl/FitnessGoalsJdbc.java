package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.FitnessGoalsDAO;
import comp3005.project.club.Entity.FitnessGoals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FitnessGoalsJdbc implements FitnessGoalsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override public FitnessGoals findByEmail(String email) {
        try {
            FitnessGoals fitnessGoals = jdbcTemplate.queryForObject("SELECT * FROM fitness_goals WHERE member_email=?",
                BeanPropertyRowMapper.newInstance(FitnessGoals.class), email);

            return fitnessGoals;
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override public int update(FitnessGoals fitnessGoals) {
        return jdbcTemplate.update("UPDATE Fitness_Goals SET time_goal=?, weight_goal=?  WHERE member_email=?",
            new Object[] {  fitnessGoals.getTime_goal(),fitnessGoals.getWeight_goal(), fitnessGoals.getMember_email()});
    }

    @Override public int save(FitnessGoals fitnessGoals) {
        return jdbcTemplate.update("INSERT INTO Fitness_Goals (member_email, time_goal, weight_goal) VALUES(?,?,?)",
            new Object[] { fitnessGoals.getMember_email(),fitnessGoals.getTime_goal(),fitnessGoals.getWeight_goal()});
    }


}
