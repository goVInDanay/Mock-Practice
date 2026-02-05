package m1_mock_questions.string_handling;

class PackageBookingUtil {
	public double validateTravelPackage(String packageName) {
		if (packageName == null) {
			throw new IllegalArgumentException("Invalid package name " + packageName);
		}
		switch (packageName) {
		case "P123" -> {
			return 5000;
		}
		case "P223" -> {
			return 10000;
		}
		case "P345" -> {
			return 12000;
		}
		default -> {
			throw new IllegalArgumentException("Invalid package name " + packageName);
		}
		}
	}

	public int validateDays(int numberOfDays) {
		if (numberOfDays <= 0) {
			throw new IllegalArgumentException("Invalid days " + numberOfDays);
		}
		return numberOfDays >= 7 ? 10 : 0;
	}

	public int validateSeason(String season) {
		if (season == null) {
			throw new IllegalArgumentException("Invalid season: " + season);
		}
		season = season.trim().toLowerCase();
		switch (season) {
		case "season" -> {
			return 15;
		}
		case "peakseason" -> {
			return 25;
		}
		case "offseason" -> {
			return 10;
		}
		default -> {
			throw new IllegalArgumentException("Invalid season: " + season);
		}
		}
	}

	public double calculateFinalPrice(double basePrice, int discount, int seasonCharge) {
		double finalPrice = (basePrice - ((discount * basePrice) / 100)) + ((seasonCharge * basePrice) / 100);
		return finalPrice;
	}
}
