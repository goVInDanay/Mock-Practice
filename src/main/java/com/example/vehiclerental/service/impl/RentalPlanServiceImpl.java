
package com.example.vehiclerental.service.impl;

import com.example.vehiclerental.exception.InvalidRentalPlanException;
import com.example.vehiclerental.model.RentalPlan;
import com.example.vehiclerental.repository.RentalPlanRepository;
import com.example.vehiclerental.service.IRentalPlanService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RentalPlanServiceImpl implements IRentalPlanService {

	private final RentalPlanRepository rentalPlanRepository;

	public RentalPlanServiceImpl(RentalPlanRepository rentalPlanRepository) {
		this.rentalPlanRepository = rentalPlanRepository;
	}

	@Override
	public RentalPlan addRentalPlan(RentalPlan plan) {
		return rentalPlanRepository.save(plan);
	}

	@Override
	public RentalPlan viewRentalPlanById(String planId) {
		return rentalPlanRepository.findById(planId)
				.orElseThrow(() -> new InvalidRentalPlanException("Plan does not exist"));
	}

	@Override
	public List<RentalPlan> viewPlansByVehicleType(String vehicleType) {
		return rentalPlanRepository.findByVehicleTypeContainingIgnoreCase(vehicleType);
	}

	@Override
	public List<RentalPlan> viewPlansByMileageAndDuration(int minMileage, int durationDays) {
		return rentalPlanRepository.findByMinMileageGreaterThanEqualAndRentalDurationDaysGreaterThanEqual(minMileage,
				durationDays);
	}

	@Override
	public Map<String, Long> getPlanCountByCategory() {
		List<Object[]> result = rentalPlanRepository.countPlansByCategory();
		Map<String, Long> plans = new HashMap<>();
		for (Object[] obj : result) {
			plans.put((String) obj[0], (Long) obj[1]);
		}
		return plans;
	}
}
