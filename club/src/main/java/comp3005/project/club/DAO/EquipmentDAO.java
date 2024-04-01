package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Equipment;
import java.util.List;

public interface EquipmentDAO {

    List<Equipment> getAll();

    boolean update(Equipment equipment);


    boolean save(Equipment equipment);

    boolean delete(Integer id);



}
