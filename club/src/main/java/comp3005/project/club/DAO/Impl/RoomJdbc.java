package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.RoomDAO;
import comp3005.project.club.Entity.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RoomJdbc implements RoomDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final class RoomMapper implements RowMapper<Room> {
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Room(
                rs.getInt("id"),
                rs.getString("room_number"),
                rs.getInt("time_id"),
                rs.getDate("date"),
                rs.getTime("start_time"),
                rs.getTime("end_time")
            );
        }
    }

    @Override
    public List<Room> getAllRoom() {
        String sql = "SELECT Room.id, room_number, time_id, date, start_time, end_time " +
            "FROM Room " +
            "JOIN Schedule ON Room.time_id = Schedule.id";
        return jdbcTemplate.query(sql, new RoomMapper());
    }

    @Override public boolean deleteOne(Integer id) {
        return jdbcTemplate.update("DELETE FROM room WHERE id=?", id)!=0;
    }


    @Override public boolean addOne(Room room) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Schedule (date, start_time, end_time) VALUES (?, ?, ?)",
                new String[]{"id"}); // Specify the column name for the generated key
            ps.setDate(1, room.getDate());
            ps.setTime(2, room.getStart_time());
            ps.setTime(3, room.getEnd_time());
            return ps;
        }, keyHolder);

        // Get the generated schedule ID
        int scheduleId = keyHolder.getKey().intValue();

        // Link the schedule with the trainer in the Available table
        return jdbcTemplate.update("INSERT INTO room (room_number, time_id) VALUES (?, ?)",
            room.getRoom_number(), scheduleId) != 0;
    }

    @Override public String getRoomNumber(Integer id) {
        return jdbcTemplate.queryForObject(
            "SELECT room_number FROM Room WHERE id = ?",
            new Object[]{id},
            String.class
        );
    }

}
