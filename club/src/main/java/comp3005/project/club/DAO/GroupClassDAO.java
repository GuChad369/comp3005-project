package comp3005.project.club.DAO;

import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.Training;
import java.util.List;

public interface GroupClassDAO {

    List<GroupClass> getByMemberEmail(String email);

    List<GroupClass> getAllClass();

    boolean deleteOne(GroupClass groupClass);

    boolean addOne(GroupClass groupClass);

    boolean addNewClass(GroupClass groupClass);

    boolean deleteClass(Integer integer);

    boolean updateClass(GroupClass groupClass);
}
