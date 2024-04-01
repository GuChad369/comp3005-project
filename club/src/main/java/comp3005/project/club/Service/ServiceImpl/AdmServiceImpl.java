package comp3005.project.club.Service.ServiceImpl;

import comp3005.project.club.DAO.Impl.BillJdbc;
import comp3005.project.club.DAO.Impl.EquipmentJdbc;
import comp3005.project.club.DAO.Impl.GroupClassJdbc;
import comp3005.project.club.DAO.Impl.RoomJdbc;
import comp3005.project.club.Entity.Bill;
import comp3005.project.club.Entity.Equipment;
import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.Room;
import comp3005.project.club.Service.AdmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdmServiceImpl implements AdmService {

    @Autowired
    private RoomJdbc roomJdbc;
    @Autowired
    private EquipmentJdbc equipmentJdbc;
    @Autowired
    private GroupClassJdbc groupClassJdbc;
    @Autowired
    private BillJdbc billJdbc;

    @Override public List<Room> getAllRoom() {
        return roomJdbc.getAllRoom();
    }

    @Override public boolean addNewRoom(Room room) {
        return roomJdbc.addOne(room);
    }

    @Override public boolean deleteRoom(Integer id) {
        return roomJdbc.deleteOne(id);
    }

    @Override public List<Equipment> getAllEquipment() {
        return equipmentJdbc.getAll();
    }

    @Override public boolean addNewEquipment(Equipment equipment) {
        return equipmentJdbc.save(equipment);
    }

    @Override public boolean deleteEquipment(Integer id) {
        return equipmentJdbc.delete(id);
    }

    @Override public boolean updateEquipment(Equipment equipment) {
        return equipmentJdbc.update(equipment);
    }

    @Override public List<GroupClass> getAllClass() {
        return groupClassJdbc.getAllClass();
    }

    @Override public boolean addNewClass(GroupClass groupClass) {
        String room = roomJdbc.getRoomNumber(groupClass.getRoom_id());
        groupClass.setRoom_number(room);
        return groupClassJdbc.addNewClass(groupClass);
    }

    @Override public boolean deleteClass(Integer id) {
        return groupClassJdbc.deleteClass(id);
    }

    @Override public boolean updateClass(GroupClass groupClass) {
        String room = roomJdbc.getRoomNumber(groupClass.getRoom_id());
        groupClass.setRoom_number(room);
        return groupClassJdbc.updateClass(groupClass);
    }

    @Override public List<Bill> getBills() {
        return billJdbc.getAllBill();
    }

    @Override public boolean addNewBill(Bill bill) {
        return billJdbc.addNewBill(bill);
    }
}
