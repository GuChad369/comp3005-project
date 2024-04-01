package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.HealthMetricsDAO;
import comp3005.project.club.Entity.HealthMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HealthMetricsJdbc implements HealthMetricsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override public HealthMetrics findByEmail(String email) {
        try {
            HealthMetrics healthMetrics = jdbcTemplate.queryForObject("SELECT * FROM health_metrics WHERE member_email=?",
                BeanPropertyRowMapper.newInstance(HealthMetrics.class), email);

            return healthMetrics;
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override public int update(HealthMetrics healthMetrics) {
        return jdbcTemplate.update("UPDATE Health_Metrics SET weight=?, height=?, BMI=? WHERE member_email=?",
            new Object[] {  healthMetrics.getWeight(),healthMetrics.getHeight(), healthMetrics.getBmi(), healthMetrics.getMember_email() });
    }

    @Override public int save(HealthMetrics healthMetrics) {
        return jdbcTemplate.update("INSERT INTO Health_Metrics (member_email, weight, height, BMI) VALUES(?,?,?,?)",
            new Object[] { healthMetrics.getMember_email(),healthMetrics.getWeight(),healthMetrics.getHeight(),healthMetrics.getBmi() });
    }
}
