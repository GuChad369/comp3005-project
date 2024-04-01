package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.BillDAO;
import comp3005.project.club.Entity.Bill;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BillJdbc implements BillDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override public List<Bill> getAllBill() {
        return jdbcTemplate.query(
            "SELECT member_email, date, time, project_name, card_number, subtotal, hst, (subtotal + subtotal * hst) AS total FROM bill",
            BeanPropertyRowMapper.newInstance(Bill.class)
        );
    }

    @Override public boolean addNewBill(Bill bill) {
        return jdbcTemplate.update("INSERT INTO bill (member_email, date, time, project_name, card_number, subtotal, hst) VALUES (?, ?, ?, ?, ?, ?, ?)",
            new Object[] { bill.getMember_email(),bill.getDate(),bill.getTime(),bill.getProject_name(),bill.getCard_number(),bill.getSubtotal(),bill.getHst()})!=0;
    }
}
