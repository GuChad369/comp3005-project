package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.GroupClassDAO;
import comp3005.project.club.Entity.GroupClass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class GroupClassJdbc implements GroupClassDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final class GroupClassMapper implements RowMapper<GroupClass> {
        public GroupClass mapRow(ResultSet rs, int rowNum) throws SQLException {
            GroupClass groupClass = new GroupClass();
            groupClass.setMember_email(rs.getString("member_email"));
            groupClass.setClass_id(rs.getInt("class_id"));
            groupClass.setClass_name(rs.getString("class_name"));
            groupClass.setRoom_id(rs.getInt("room_id"));
            groupClass.setRoom_number(rs.getString("room_number"));
            groupClass.setTime_id(rs.getInt("time_id"));
            groupClass.setDate(rs.getDate("date"));
            groupClass.setStart_time(rs.getTime("start_time"));
            groupClass.setEnd_time(rs.getTime("end_time"));
            return groupClass;
        }
    }

    @Override
    public List<GroupClass> getByMemberEmail(String email) {
        String sql = "SELECT gc.member_email, c.class_id, c.class_name, c.room_id, r.room_number, r.time_id, s.date, s.start_time, s.end_time " +
            "FROM Group_class gc " +
            "JOIN Class c ON gc.class_id = c.class_id " +
            "JOIN Room r ON c.room_id = r.id " +
            "JOIN Schedule s ON r.time_id = s.id " +
            "WHERE gc.member_email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, new GroupClassMapper());
    }

    @Override
    public List<GroupClass> getAllClass() {
        String sql = "SELECT '' AS member_email, c.class_id, c.class_name, c.room_id, r.room_number, r.time_id, s.date, s.start_time, s.end_time " +
            "FROM Class c " +
            "JOIN Room r ON c.room_id = r.id " +
            "JOIN Schedule s ON r.time_id = s.id";


        return jdbcTemplate.query(sql, new GroupClassMapper());
    }

    @Override public boolean deleteOne(GroupClass groupClass) {
        return jdbcTemplate.update("DELETE FROM Group_class WHERE member_email=? AND class_id=?", groupClass.getMember_email(),groupClass.getClass_id()) != 0;
    }

    @Override public boolean addOne(GroupClass groupClass) {
        return jdbcTemplate.update("INSERT INTO Group_class (member_email, class_id) VALUES(?,?)",
            new Object[] { groupClass.getMember_email(),groupClass.getClass_id() }) != 0;
    }

    @Override public boolean addNewClass(GroupClass groupClass) {
        try {
            // Add schedule
            String insertScheduleSQL = "INSERT INTO Schedule (date, start_time, end_time) VALUES (?, ?, ?)";
            KeyHolder scheduleKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                connection -> {
                    PreparedStatement pstmt = connection.prepareStatement(insertScheduleSQL, new String[]{"id"});
                    pstmt.setDate(1, groupClass.getDate());
                    pstmt.setTime(2, groupClass.getStart_time());
                    pstmt.setTime(3, groupClass.getEnd_time());
                    return pstmt;
                },
                scheduleKeyHolder
            );
            groupClass.setTime_id(scheduleKeyHolder.getKey().intValue());

            // Add room
            String insertRoomSQL = "INSERT INTO Room (room_number, time_id) VALUES (?, ?)";
            KeyHolder roomKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                connection -> {
                    PreparedStatement pstmt = connection.prepareStatement(insertRoomSQL, new String[]{"id"}); // Specify the primary key column name
                    pstmt.setString(1, groupClass.getRoom_number());
                    pstmt.setInt(2, groupClass.getTime_id());
                    return pstmt;
                },
                roomKeyHolder
            );
            groupClass.setRoom_id(roomKeyHolder.getKey().intValue());

            // Add class
            String insertClassSQL = "INSERT INTO Class (class_name, room_id) VALUES (?, ?)";
            KeyHolder classKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                connection -> {
                    PreparedStatement pstmt = connection.prepareStatement(insertClassSQL, Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, groupClass.getClass_name());
                    pstmt.setInt(2, groupClass.getRoom_id());
                    return pstmt;
                },
                classKeyHolder
            );

            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override public boolean deleteClass(Integer integer) {
        try {
            // Delete all group class members
            String deleteGroupClassSQL = "DELETE FROM Group_class WHERE class_id = ?";
            jdbcTemplate.update(deleteGroupClassSQL, integer);

            // Delete the class
            String deleteClassSQL = "DELETE FROM Class WHERE class_id = ?";
            jdbcTemplate.update(deleteClassSQL, integer);

            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override public boolean updateClass(GroupClass groupClass) {
        try {
            // Add schedule
            String insertScheduleSQL = "INSERT INTO Schedule (date, start_time, end_time) VALUES (?, ?, ?)";
            KeyHolder scheduleKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                connection -> {
                    PreparedStatement pstmt = connection.prepareStatement(insertScheduleSQL, new String[]{"id"});
                    pstmt.setDate(1, groupClass.getDate());
                    pstmt.setTime(2, groupClass.getStart_time());
                    pstmt.setTime(3, groupClass.getEnd_time());
                    return pstmt;
                },
                scheduleKeyHolder
            );
            groupClass.setTime_id(scheduleKeyHolder.getKey().intValue());

            // Add room
            String insertRoomSQL = "INSERT INTO Room (room_number, time_id) VALUES (?, ?)";
            KeyHolder roomKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                connection -> {
                    PreparedStatement pstmt = connection.prepareStatement(insertRoomSQL, new String[]{"id"}); // Specify the primary key column name
                    pstmt.setString(1, groupClass.getRoom_number());
                    pstmt.setInt(2, groupClass.getTime_id());
                    return pstmt;
                },
                roomKeyHolder
            );
            groupClass.setRoom_id(roomKeyHolder.getKey().intValue());

            // Update class with new room_id
            String updateClassSQL = "UPDATE Class SET class_name = ?, room_id = ? WHERE class_id = ?";
            jdbcTemplate.update(updateClassSQL,
                groupClass.getClass_name(),
                groupClass.getRoom_id(),
                groupClass.getClass_id());

            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
