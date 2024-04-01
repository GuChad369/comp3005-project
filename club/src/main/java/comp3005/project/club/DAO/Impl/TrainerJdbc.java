package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.TrainerDAO;
import comp3005.project.club.Entity.Trainer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerJdbc implements TrainerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override public Trainer findByEmail(String email) {
        try {
            Trainer trainer = jdbcTemplate.queryForObject("SELECT * FROM trainer WHERE email=?",
                BeanPropertyRowMapper.newInstance(Trainer.class), email);

            return trainer;
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override public int deleteByEmail(String email) {
        return jdbcTemplate.update("DELETE FROM trainer WHERE email=?", email);
    }

    @Override public List<Trainer> findAll() {
        return jdbcTemplate.query("SELECT * from trainer", BeanPropertyRowMapper.newInstance(Trainer.class));
    }

    @Override public int save(Trainer trainer) {
        return jdbcTemplate.update("INSERT INTO trainer (email, first_name, last_name, phone) VALUES(?,?,?,?)",
            new Object[] { trainer.getEmail(),trainer.getFirst_name(),trainer.getLast_name(),trainer.getPhone() });
    }

    @Override public int update(Trainer trainer) {
        return jdbcTemplate.update("UPDATE trainer SET  first_name=?, last_name=?, phone=? WHERE email=?",
            new Object[] {  trainer.getFirst_name(),trainer.getLast_name(), trainer.getPhone(), trainer.getEmail() });
    }
}
