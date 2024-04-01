package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Bill;
import java.util.List;

public interface BillDAO {


    List<Bill> getAllBill();

    boolean addNewBill(Bill bill);
}
