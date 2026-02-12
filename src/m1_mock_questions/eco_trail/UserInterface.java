package m1_mock_questions.eco_trail;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TrailUtil util = new TrailUtil();
		System.out.println("Enter the number of trails to be added");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter trail details");
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String data[] = input.split(":");
			Trail trail = new Trail(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
			util.addTrailRecord(trail);
		}
		System.out.println();
		System.out.println("Enter the Trail Id to check hike status");
		String id = sc.nextLine();
		Trail found = util.getTrailById(id);
		if (found != null) {
			System.out.println(found);
		}
		System.out.println();

		System.out.println("Most hiked trails are");
		for (Trail trail : util.getMostHikedTrails()) {
			System.out.println(trail);
		}
		System.out.println();

		System.out.println("Region-wise hike counts");
		for (Map.Entry<String, String> entry : util.getHikeCountByRegion().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();

		System.out.println("Trails grouped by difficulty");
		for (Map.Entry<String, List<Trail>> entry : util.groupTrailsByDifficulty().entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println();
		System.out.println("Enter Trail Id to update hikes and additional hikes");
		String updateInput[] = sc.nextLine().split(" ");
		boolean updated = util.updateHikeCount(updateInput[0], Integer.parseInt(updateInput[1]));
		if (updated) {
			System.out.println("Updated " + updateInput[0] + " by " + updateInput[1] + " hikes");
			System.out.println(util.getTrailById(updateInput[0]));
		}
		System.out.println();

		System.out.println("Filter trails by region and difficulty");
		String[] filterInput = sc.nextLine().split(" ");
		List<Trail> filtered = util.filterTrails(filterInput[0], filterInput[1]);
		for (Trail trail : filtered) {
			System.out.println(trail);
		}
		System.out.println();
		int top = sc.nextInt();
		System.out.println("Top " + top + " trails per region");
		for (Map.Entry<String, List<Trail>> entry : util.getTopTrailsByRegion(top).entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println();
		System.out.println("Difficulty statistics");
		for (Map.Entry<String, String> entry : util.getDifficultyStats().entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
	}

}
