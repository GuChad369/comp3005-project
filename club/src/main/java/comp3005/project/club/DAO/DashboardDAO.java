package comp3005.project.club.DAO;

import comp3005.project.club.Entity.Dashboard;

public interface DashboardDAO {

    Dashboard getByEmail(String email);
}
