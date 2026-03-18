
package com.example.vehiclerental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vehiclerental.model.RentalPlan;

@Repository
public interface RentalPlanRepository extends JpaRepository<RentalPlan, String> {
	// Define data access method signatures here if needed
	List<RentalPlan> findByVehicleTypeContainingIgnoreCase(String vehicleType);

	List<RentalPlan> findByMinMileageGreaterThanEqualAndRentalDurationDaysGreaterThanEqual(int minMileage,
			int durationDays);

	@Query("SELECT r.rentalCategory, COUNT(r) FROM RentalPlan r GROUP BY r.rentalCategory")
	List<Object[]> countPlansByCategory();
}
