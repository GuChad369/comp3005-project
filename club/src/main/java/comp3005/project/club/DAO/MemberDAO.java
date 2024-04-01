package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Member;
import java.util.List;

// provide manipulate member table way
public interface MemberDAO {

    Member findByEmail(String email);

    int deleteByEmail(String email);

    List<Member> findAll();

    int save(Member member);

    int update(Member member);
}
