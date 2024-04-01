package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.ASDAO;
import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.Schedule;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ASJdbc implements ASDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override public List<Schedule> getSchedulesByEmail(String email) {
        String sql = "SELECT s.* FROM Schedule s " +
            "JOIN Available a ON s.id = a.time_id " +
            "WHERE a.trainer_email = ?";

        return jdbcTemplate.query(sql, new Object[]{email}, (rs, rowNum) -> {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getInt("id"));
            schedule.setDate(rs.getDate("date"));
            schedule.setStart_time(rs.getTime("start_time"));
            schedule.setEnd_time(rs.getTime("end_time"));
            return schedule;
        });
    }

    @Override public boolean deleteScheduleByAvailable(Available available) {
        int rows = jdbcTemplate.update("DELETE FROM Available WHERE trainer_email = ? AND time_id = ?",
            available.getTrainer_email(), available.getTime_id());

        if (rows > 0) {
            return jdbcTemplate.update("DELETE FROM Schedule WHERE id = ?", available.getTime_id())!=0;
        }

        return false;
    }

    @Override public boolean saveSchedule(Schedule schedule) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Schedule (date, start_time, end_time) VALUES (?, ?, ?)",
                new String[]{"id"}); // Specify the column name for the generated key
            ps.setDate(1, schedule.getDate());
            ps.setTime(2, schedule.getStart_time());
            ps.setTime(3, schedule.getEnd_time());
            return ps;
        }, keyHolder);

        // Get the generated schedule ID
        int scheduleId = keyHolder.getKey().intValue();

        // Link the schedule with the trainer in the Available table
        return jdbcTemplate.update("INSERT INTO Available (trainer_email, time_id) VALUES (?, ?)",
            schedule.getEmail(), scheduleId) != 0;
    }
}
