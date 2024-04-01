package comp3005.project.club.DAO;

import comp3005.project.club.Entity.HealthStatistics;

public interface HealthStatisticsDAO{

    HealthStatistics getByEmail(String email);
}
