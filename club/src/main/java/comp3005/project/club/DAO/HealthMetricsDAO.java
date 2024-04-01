package comp3005.project.club.DAO;

import comp3005.project.club.Entity.HealthMetrics;

public interface HealthMetricsDAO {

    HealthMetrics findByEmail(String email);

    int update(HealthMetrics healthMetrics);

    int save(HealthMetrics healthMetrics);
}
