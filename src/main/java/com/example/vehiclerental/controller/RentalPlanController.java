
package com.example.vehiclerental.controller;

import com.example.vehiclerental.model.RentalPlan;
import com.example.vehiclerental.service.IRentalPlanService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalPlanController {

	private final IRentalPlanService rentalPlanService;

	public RentalPlanController(IRentalPlanService rentalPlanService) {
		this.rentalPlanService = rentalPlanService;
	}

	@PostMapping("/addRentalPlan")
	public ResponseEntity<RentalPlan> addRentalPlan(@Valid @RequestBody RentalPlan plan) {
		return new ResponseEntity<RentalPlan>(rentalPlanService.addRentalPlan(plan), HttpStatus.OK);
	}

	@GetMapping("/viewRentalPlanById/{planId}")
	public ResponseEntity<RentalPlan> viewRentalPlanById(@PathVariable String planId) {
		return new ResponseEntity<>(rentalPlanService.viewRentalPlanById(planId), HttpStatus.OK);
	}

	@GetMapping("/viewPlansByVehicleType/{vehicleType}")
	public ResponseEntity<List<RentalPlan>> viewPlansByVehicleType(@PathVariable String vehicleType) {
		return new ResponseEntity<>(rentalPlanService.viewPlansByVehicleType(vehicleType), HttpStatus.OK);
	}

	@GetMapping("/viewPlansByMileageAndDuration/{minMileage}/{durationDays}")
	public ResponseEntity<List<RentalPlan>> viewPlansByMileageAndDuration(@PathVariable int minMileage,
			@PathVariable int durationDays) {

		return new ResponseEntity<>(rentalPlanService.viewPlansByMileageAndDuration(minMileage, durationDays),
				HttpStatus.OK);
	}

	@GetMapping("/getPlanCountByCategory")
	public ResponseEntity<Map<String, Long>> getPlanCountByCategory() {
		return new ResponseEntity<>(rentalPlanService.getPlanCountByCategory(), HttpStatus.OK);
	}
}
