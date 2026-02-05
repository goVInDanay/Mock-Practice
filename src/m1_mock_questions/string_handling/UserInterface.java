package m1_mock_questions.string_handling;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PackageBookingUtil bookingUtil = new PackageBookingUtil();
		System.out.println("Enter booking details");

		try (Scanner sc = new Scanner(System.in);) {
			String input = sc.nextLine();
			String[] data = input.split(":");

			String customerName = data[0];
			String packageName = data[1];
			int numberOfDays = Integer.parseInt(data[2]);
			String season = data[3];

			double basePrice = bookingUtil.validateTravelPackage(packageName);
			int discount = bookingUtil.validateDays(numberOfDays);
			int seasonalCharge = bookingUtil.validateSeason(season);

			double finalPrice = bookingUtil.calculateFinalPrice(basePrice, discount, seasonalCharge);

			System.out.println("Total Booking Price for " + customerName + " is: Rs " + finalPrice);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
