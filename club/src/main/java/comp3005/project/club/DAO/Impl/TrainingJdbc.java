package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.TrainingDAO;
import comp3005.project.club.Entity.Training;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TrainingJdbc implements TrainingDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Training> getByMemberEmail(String email) {
        String sql = "SELECT t.member_email, t.trainer_email, t.time_id, s.date, s.start_time, s.end_time " +
            "FROM Training t " +
            "JOIN Schedule s ON t.time_id = s.id " +
            "WHERE t.member_email = ?";

        return jdbcTemplate.query(sql, new Object[]{email}, new TrainingRowMapper());
    }

    private static final class TrainingRowMapper implements RowMapper<Training> {
        @Override
        public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
            Training training = new Training();
            training.setMember_email(rs.getString("member_email"));
            training.setTrainer_email(rs.getString("trainer_email"));
            training.setTime_id(rs.getInt("time_id"));
            training.setDate(rs.getDate("date"));
            training.setStart_time(rs.getTime("start_time"));
            training.setEnd_time(rs.getTime("end_time"));
            return training;
        }
    }

    @Override
    public List<Training> getAllTrainer() {
        String sql = "SELECT '' AS member_email, a.trainer_email, a.time_id, s.date, s.start_time, s.end_time " +
            "FROM Available a " +
            "JOIN Schedule s ON a.time_id = s.id";

        return jdbcTemplate.query(sql, new TrainingRowMapper2());
    }

    private static final class TrainingRowMapper2 implements RowMapper<Training> {
        @Override
        public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
            Training training = new Training();
            training.setMember_email(rs.getString("member_email"));
            training.setTrainer_email(rs.getString("trainer_email"));
            training.setTime_id(rs.getInt("time_id"));
            training.setDate(rs.getDate("date"));
            training.setStart_time(rs.getTime("start_time"));
            training.setEnd_time(rs.getTime("end_time"));
            return training;
        }
    }


    @Override public boolean deleteOne(Training training) {
        return jdbcTemplate.update("DELETE FROM Training WHERE member_email=? AND trainer_email=? AND time_id=?", training.getMember_email(), training.getTrainer_email(), training.getTime_id()) != 0;
    }

    @Override public boolean addOne(Training training) {
        return jdbcTemplate.update("INSERT INTO Training (member_email, trainer_email, time_id) VALUES(?,?,?)",
            new Object[] { training.getMember_email(),training.getTrainer_email(),training.getTime_id() }) != 0;
    }
}
