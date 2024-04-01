package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.EquipmentDAO;
import comp3005.project.club.Entity.Equipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentJdbc implements EquipmentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override public List<Equipment> getAll() {
        String sql = "SELECT e.id, e.model, e.room_id, e.status, r.room_number " +
            "FROM Equipment e " +
            "LEFT JOIN Room r ON e.room_id = r.id";

        return jdbcTemplate.query(sql, new RowMapper<Equipment>() {
            @Override
            public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
                Equipment equipment = new Equipment();
                equipment.setId(rs.getInt("id"));
                equipment.setModel(rs.getString("model"));
                equipment.setRoom_id(rs.getInt("room_id"));
                equipment.setStatus(rs.getInt("status"));
                equipment.setRoom_number(rs.getString("room_number"));
                return equipment;
            }
        });
    }

    @Override public boolean update(Equipment equipment) {
        return jdbcTemplate.update("UPDATE Equipment SET model=?, room_id=?, status=? WHERE id=?",
            new Object[] {  equipment.getModel(),equipment.getRoom_id(),equipment.getStatus(),equipment.getId() })!=0;
    }

    @Override public boolean save(Equipment equipment) {
        return jdbcTemplate.update("INSERT INTO Equipment (model, room_id, status) VALUES(?,?,?)",
            new Object[] { equipment.getModel(),equipment.getRoom_id(),equipment.getStatus() }) != 0;
    }

    @Override public boolean delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM Equipment WHERE id=?", id)!=0;
    }

}
