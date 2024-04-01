package comp3005.project.club.Controller;

import comp3005.project.club.DAO.Impl.RoomJdbc;
import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.Bill;
import comp3005.project.club.Entity.Equipment;
import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.Room;
import comp3005.project.club.Entity.Schedule;
import comp3005.project.club.Service.AdmService;
import comp3005.project.club.Util.ResultData;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmService admService;

    @PostMapping("/room/delete")
    public ResultData<String> deleteRoom(@RequestBody Room room) {
        boolean delete =admService.deleteRoom(room.getId());
        if(delete){
            return ResultData.success("Deleted!");
        }
        return ResultData.fail(400, "Deleted failed!");
    }

    @PostMapping("/room/add")
    public ResultData<String> addRoom(@RequestBody Room room) {
        boolean add =admService.addNewRoom(room);
        if(add){
            return ResultData.success("Add!");
        }
        return ResultData.fail(400, "Add failed!");
    }

    @GetMapping("/room")
    public ResultData<List<Room>> getRooms() {
        List<Room> rooms = admService.getAllRoom();

        if (rooms == null || rooms.size() == 0) {
            return ResultData.fail(400, "Not have any rooms!");
        } else {
            return ResultData.success(rooms);
        }
    }

    @PostMapping("/equipment/delete")
    public ResultData<String> deleteEquipment(@RequestBody Equipment equipment) {
        boolean delete =admService.deleteEquipment(equipment.getId());
        if(delete){
            return ResultData.success("Deleted!");
        }
        return ResultData.fail(400, "Deleted failed!");
    }

    @PostMapping("/equipment/add")
    public ResultData<String> addEquipment(@RequestBody Equipment equipment) {
        boolean add =admService.addNewEquipment(equipment);
        if(add){
            return ResultData.success("Add!");
        }
        return ResultData.fail(400, "Add failed!");
    }

    @PostMapping("/equipment/update")
    public ResultData<String> updateEquipment(@RequestBody Equipment equipment) {
        boolean add =admService.updateEquipment(equipment);
        if(add){
            return ResultData.success("Updated!");
        }
        return ResultData.fail(400, "Updated failed!");
    }

    @GetMapping("/equipment")
    public ResultData<List<Equipment>> getEquipments() {
        List<Equipment> equipment = admService.getAllEquipment();

        if (equipment == null || equipment.size() == 0) {
            return ResultData.fail(400, "Not have any Equipment!");
        } else {
            return ResultData.success(equipment);
        }
    }

    @GetMapping("/class")
    public ResultData<List<GroupClass>> getAllClass() {
        List<GroupClass> classes = admService.getAllClass();

        if (classes == null || classes.size() == 0) {
            return ResultData.fail(400, "Not have any Class!");
        } else {
            return ResultData.success(classes);
        }
    }

    @PostMapping("/class/delete")
    public ResultData<String> deleteClass(@RequestBody GroupClass groupClass) {
        boolean delete =admService.deleteClass(groupClass.getClass_id());
        if(delete){
            return ResultData.success("Deleted!");
        }
        return ResultData.fail(400, "Deleted failed!");
    }

    @PostMapping("/class/add")
    public ResultData<String> addClass(@RequestBody GroupClass groupClass) {
        boolean add =admService.addNewClass(groupClass);


        if(add){
            return ResultData.success("Add!");
        }
        return ResultData.fail(400, "Add failed!");
    }

    @PostMapping("/class/update")
    public ResultData<String> updateClass(@RequestBody  GroupClass groupClass) {
        boolean add =admService.updateClass(groupClass);
        if(add){
            return ResultData.success("Updated!");
        }
        return ResultData.fail(400, "Updated failed!");
    }

    @GetMapping("/bill")
    public ResultData<List<Bill>> getAllBill() {

        List<Bill> bills = admService.getBills();

        if (bills == null || bills.size() == 0) {
            return ResultData.fail(400, "Not have any Bills!");
        } else {
            return ResultData.success(bills);
        }
    }

    @PostMapping("/bill/add")
    public ResultData<String> addBill(@RequestBody Bill bill) {

        boolean add = admService.addNewBill(bill);
        if(add){
            return ResultData.success("Add!");
        }
        return ResultData.fail(400, "Add failed!");
    }


}
