package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Room;
import java.util.List;

public interface RoomDAO {

    List<Room> getAllRoom();

    boolean deleteOne(Integer id);

    boolean addOne(Room room);

    String getRoomNumber(Integer id);
}
