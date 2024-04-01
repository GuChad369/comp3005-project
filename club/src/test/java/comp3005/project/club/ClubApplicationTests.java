package comp3005.project.club;

import comp3005.project.club.DAO.BillDAO;
import comp3005.project.club.DAO.Impl.ASJdbc;
import comp3005.project.club.DAO.Impl.BillJdbc;
import comp3005.project.club.DAO.Impl.EquipmentJdbc;
import comp3005.project.club.DAO.Impl.GroupClassJdbc;
import comp3005.project.club.DAO.Impl.HealthMetricsJdbc;
import comp3005.project.club.DAO.Impl.MemberJdbc;
import comp3005.project.club.DAO.Impl.RoomJdbc;
import comp3005.project.club.DAO.Impl.TrainingJdbc;
import comp3005.project.club.Entity.Available;
import comp3005.project.club.Entity.Bill;
import comp3005.project.club.Entity.Equipment;
import comp3005.project.club.Entity.GroupClass;
import comp3005.project.club.Entity.HealthMetrics;
import comp3005.project.club.Entity.Member;
import comp3005.project.club.Entity.Room;
import comp3005.project.club.Entity.Schedule;
import comp3005.project.club.Entity.Training;
import comp3005.project.club.Service.MemberService;
import java.sql.Date;
import java.sql.Time;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ClubApplicationTests {

	@Autowired
	private HealthMetricsJdbc healthMetricsJdbc;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberJdbc memberJdbc;

	@Autowired
	private ASJdbc asJdbc;

	@Test
	void contextLoads() {
		Member member = new Member("john.doe@example.com", "John", "Doe", "123-456-7891");
		memberJdbc.update(member);
	}

	@Test
	void testSchedule(){
		// Set up a new schedule for a trainer
		String trainerEmail = "tom.jones@example.com";
		Schedule schedule = new Schedule();
		schedule.setDate(Date.valueOf("2024-03-21"));
		schedule.setStart_time(Time.valueOf("09:00:00"));
		schedule.setEnd_time(Time.valueOf("10:00:00"));
		schedule.setEmail(trainerEmail);

		// Save the new schedule for the trainer
		asJdbc.saveSchedule(schedule);

		// Get all schedules for the trainer and verify the new schedule is included
		List<Schedule> schedules = asJdbc.getSchedulesByEmail(trainerEmail);

		for(Schedule s:schedules){
			System.out.println(s);
		}

		asJdbc.saveSchedule(schedule);
	}

	@Autowired
	private TrainingJdbc trainingJdbc;

	@Test
	void testTraining(){
		List<Training> training = trainingJdbc.getByMemberEmail("john.doe@example.com");
		for(Training t:training){
			System.out.println(t);
		}

		String email = "john.doe@example.com";
		Training training1 = new Training();
		training1.setMember_email(email);
		training1.setTrainer_email("steve.martin@example.com");
		training1.setTime_id(4);

		boolean b = trainingJdbc.addOne(training1);
		System.out.println(b);

		b = trainingJdbc.deleteOne(training1);
		System.out.println(b);

		List<Training> trainer = trainingJdbc.getAllTrainer();

		for(Training t:trainer){
			System.out.println(t);
		}
	}

	@Test
	void testDeleteDuplicate(){
		String email = "john.doe@example.com";
		List<Training> curr = trainingJdbc.getByMemberEmail("john.doe@example.com");
		List<Training> all = trainingJdbc.getAllTrainer();

		for(Training t:all){
			t.setMember_email(email);
		}

		System.out.println(all.size());
		System.out.println(curr.size());
		all.removeAll(curr);
		System.out.println(all.size());

	}

	@Autowired
	private GroupClassJdbc groupClassJdbc;

	@Test
	void testGroup(){
		List<GroupClass> groupClasses = groupClassJdbc.getByMemberEmail("john.doe@example.com");
		for(GroupClass t:groupClasses){
			System.out.println(t);
		}

		List<GroupClass> aClass = groupClassJdbc.getAllClass();
		for(GroupClass t:aClass){
			System.out.println(t);
		}

		String email = "john.doe@example.com";
		GroupClass aClass1 = new GroupClass();
		aClass1.setMember_email(email);
		aClass1.setClass_id(4);

		boolean b = groupClassJdbc.addOne(aClass1);
		System.out.println(b);

		b = groupClassJdbc.deleteOne(aClass1);
		System.out.println(b);

	}

	@Autowired
	private RoomJdbc roomJdbc;
	@Test
	void testRoom(){


		Room room1 = new Room();
		room1.setRoom_number("R110");
		room1.setDate(Date.valueOf("2024-03-22"));
		room1.setStart_time(Time.valueOf("09:00:00"));
		room1.setEnd_time(Time.valueOf("10:00:00"));

		roomJdbc.addOne(room1);

		List<Room> room = roomJdbc.getAllRoom();
		for(Room t:room){
			System.out.println(t);
		}

		System.out.println(roomJdbc.deleteOne(12));
	}

	@Autowired
	private EquipmentJdbc equipmentJdbc;
	@Test
	void testEquipment(){
		Equipment equipment = new Equipment();
		equipment.setRoom_id(4);
		equipment.setModel("R120");
		equipment.setStatus(0);

		equipmentJdbc.save(equipment);

		List<Equipment> all = equipmentJdbc.getAll();

		for(Equipment t:all){
			System.out.println(t);
		}

		System.out.println(equipmentJdbc.delete(11));

	}

	@Test
	void admClass(){
		GroupClass groupClass = new GroupClass();
		groupClass.setClass_name("FFFFFFF");
		groupClass.setDate(Date.valueOf("2024-03-22"));
		groupClass.setStart_time(Time.valueOf("09:00:00"));
		groupClass.setEnd_time(Time.valueOf("10:00:00"));
		groupClass.setRoom_id(4);
		groupClass.setRoom_number(roomJdbc.getRoomNumber(4));
//		System.out.println(groupClass);

//		groupClassJdbc.addNewClass(groupClass);
		groupClass.setClass_id(11);

		groupClassJdbc.updateClass(groupClass);


	}

	@Autowired
	private BillJdbc billJdbc;

	@Test
	void testBill(){
		List<Bill> bill = billJdbc.getAllBill();

		for(Bill t:bill){
			System.out.println(t);
		}

		Bill bill1 = new Bill("john.doe@example.com",Date.valueOf("2024-03-23"), Time.valueOf("09:00:00"), "Month fee", "123456",90.6,0.13);

		System.out.println(billJdbc.addNewBill(bill1));
	}

}
