package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.DashboardDAO;
import comp3005.project.club.Entity.Dashboard;
import comp3005.project.club.Entity.FitnessGoals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardJdbc implements DashboardDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override public Dashboard getByEmail(String email) {
        Dashboard dashboard = jdbcTemplate.queryForObject("SELECT * FROM dashboard WHERE member_email=?",
            BeanPropertyRowMapper.newInstance(Dashboard.class), email);

        return dashboard;
    }
}
