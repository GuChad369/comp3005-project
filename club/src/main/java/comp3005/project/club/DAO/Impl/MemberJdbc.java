package comp3005.project.club.DAO.Impl;

import comp3005.project.club.DAO.MemberDAO;
import comp3005.project.club.Entity.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberJdbc implements MemberDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override public Member findByEmail(String email) {
        try {
            Member member = jdbcTemplate.queryForObject("SELECT * FROM member WHERE email=?",
                BeanPropertyRowMapper.newInstance(Member.class), email);

            return member;
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    @Override public int deleteByEmail(String email) {
        return jdbcTemplate.update("DELETE FROM member WHERE email=?", email);
    }

    @Override public List<Member> findAll() {
        return jdbcTemplate.query("SELECT * from member", BeanPropertyRowMapper.newInstance(Member.class));
    }

    @Override public int save(Member member) {
        return jdbcTemplate.update("INSERT INTO member (email, first_name, last_name, phone) VALUES(?,?,?,?)",
            new Object[] { member.getEmail(),member.getFirst_name(),member.getLast_name(),member.getPhone() });
    }

    @Override public int update(Member member) {
        return jdbcTemplate.update("UPDATE member SET first_name=?, last_name=?, phone=? WHERE email=?",
            new Object[] {  member.getFirst_name(),member.getLast_name(), member.getPhone(), member.getEmail() });
    }

}
