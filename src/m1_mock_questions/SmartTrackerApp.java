package m1_mock_questions;

public class SmartTrackerApp {

	public static double averageTemperature(int[] temps) {
		int sum = 0;
		for (int t : temps) {
			sum += t;
		}
		return (double) sum / temps.length;
	}
	public static void hottestAndColdest(int[] temps) {
		int max = temps[0];
		int min = temps[0];
		int maxDay = 1;
		int minDay = 1;
		for (int i = 1; i < temps.length; i++) {
			if (temps[i] > max) {
				max = temps[i];
				maxDay = i + 1;
			}
			if (temps[i] < min) {
				min = temps[i];
				minDay = i + 1;
			}
		}

		System.out.println("Highest Temperature: " + max + " celcius on day " + maxDay);
		System.out.println("Lowest Temperature: " + min + " celcius on day " + minDay);
	}

	public static int countHotDays(int[] temps) {
		int count = 0;
		for (int t : temps) {
			if (t > 30) {
				count++;
			}
		}
		return count;
	}

	public static int totalSales(int[] sales) {
		int total = 0;
		for (int s : sales) {
			total += s;
		}
		return total;
	}

	public static void highestAndLowestSales(int[] sales) {
		int max = sales[0];
		int min = sales[0];
		int maxDay = 1;
		int minDay = 1;
		for (int i = 1; i < sales.length; i++) {
			if (sales[i] > max) {
				max = sales[i];
				maxDay = i + 1;
			}
			if (sales[i] < min) {
				min = sales[i];
				minDay = i + 1;
			}
		}

		System.out.println("Highest Sale: " + max + " on day " + maxDay);
		System.out.println("Lowest Sale: " + min + " on day " + minDay);
	}

	public static int countHighSalesDays(int[] sales) {
		int count = 0;
		for (int s : sales) {
			if (s > 100) {
				count++;
			}
		}
		return count;
	}

	public static void searchSale(int[] sales, int target) {
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] == target) {
				System.out.println("Sale " + target + " found on Day " + (i + 1));
				return;
			}
		}
		System.out.println("Sale " + target + " not found");
	}

	public static void updateSale(int[] sales, int day, int val) {
		sales[day - 1] = val;
		System.out.println("Updated sales for Day " + day + ": " + sales[day - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sales = { 120, 80, 150, 90, 200, 75, 110 };
		int[] temperatures = { 32, 28, 31, 29, 35, 27, 30 };
		
		System.out.printf("Average Temperature: %.1f celcius%n", averageTemperature(temperatures));
		hottestAndColdest(temperatures);
		System.out.println("Number of hot days (>30 celcius): " + countHotDays(temperatures));
		int total = totalSales(sales);
		System.out.println("Total Sales: " + total);
		System.out.printf("Average Sales: %.2f%n", (double) total / sales.length);
		highestAndLowestSales(sales);
		System.out.println("Number of high sales days (>100): " + countHighSalesDays(sales));
		searchSale(sales, 150);
		updateSale(sales, 2, 95);
	}

}
