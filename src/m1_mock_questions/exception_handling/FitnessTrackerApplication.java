package m1_mock_questions.exception_handling;

import java.util.*;

public class FitnessTrackerApplication {

	public static int validateActivity(String activityName) throws InvalidActivityName {
		switch (activityName.trim().toLowerCase()) {
		case "walking" -> {
			return 3;
		}
		case "running" -> {
			return 7;
		}
		case "cycling" -> {
			return 5;
		}
		default -> {
			throw new InvalidActivityName("Error:Invalid activity name.");
		}
		}
	}

	public static void validateDurationAndIntensity(int duration, int intensity) throws InvalidDurationOrIntesity {
		if (duration <= 0 || intensity <= 0 || intensity > 9) {
			throw new InvalidDurationOrIntesity("Error:Invalid duration or intensity.");
		}
	}

	public static void validateWeight(double weight) throws InvalidWeight {
		if (weight <= 0) {
			throw new InvalidWeight("Error:User Weight is invalid.");
		}
	}

	public static double calculateCalories(int caloriesPerMinute, int duration, int intensity, double weight) {
		return (caloriesPerMinute * duration * intensity * 60) / weight;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String data[] = input.split(":");
			if (data.length != 3) {
				throw new InvalidInputFormat("Error:Invalid activity data format.");
			}
			System.out.println("Enter weight");
			double weight = sc.nextDouble();
			String activityName = data[0];
			int duration = Integer.parseInt(data[1]);
			int intensity = Integer.parseInt(data[2]);
			int caloriesPerMinute = validateActivity(activityName);
			validateDurationAndIntensity(duration, intensity);
			validateWeight(weight);
			double caloriesBurned = calculateCalories(caloriesPerMinute, duration, intensity, weight);
			System.out.printf("Calories Burned:%.2f", caloriesBurned);
		} catch (InvalidActivityName | InvalidDurationOrIntesity | InvalidWeight | InvalidInputFormat e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
