package comp3005.project.club.Service;

import comp3005.project.club.Entity.Bill;
import comp3005.project.club.Entity.Equipment;
import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.Room;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AdmService {

    List<Room> getAllRoom();

    boolean addNewRoom(Room room);

    boolean deleteRoom(Integer id);

    List<Equipment> getAllEquipment();

    boolean addNewEquipment(Equipment equipment);

    boolean deleteEquipment(Integer id);

    boolean updateEquipment(Equipment equipment);

    List<GroupClass> getAllClass();

    boolean addNewClass(GroupClass groupClass);

    boolean deleteClass(Integer id);

    boolean updateClass(GroupClass groupClass);


    List<Bill> getBills();

    boolean addNewBill(Bill bill);



}
