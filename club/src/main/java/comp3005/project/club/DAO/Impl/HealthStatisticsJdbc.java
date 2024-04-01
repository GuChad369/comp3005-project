package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.HealthStatisticsDAO;
import comp3005.project.club.Entity.HealthStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HealthStatisticsJdbc implements HealthStatisticsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override public HealthStatistics getByEmail(String email) {
        HealthStatistics healthStatistics = jdbcTemplate.queryForObject("SELECT * FROM Health_Statistics WHERE member_email=?",
            BeanPropertyRowMapper.newInstance(HealthStatistics.class), email);

        return healthStatistics;
    }

}
