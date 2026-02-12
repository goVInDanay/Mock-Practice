package m1_mock_questions.eco_trail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrailUtil {
	private List<Trail> trailList = new ArrayList<Trail>();

	public void addTrailRecord(Trail trail) {
		trailList.add(trail);
		System.out.println("Trail added successfully");
	}

	public Trail getTrailById(String trailId) {
		for (Trail trail : trailList) {
			if (trail.getTrailId().equals(trailId)) {
				return trail;
			}
		}
		System.out.println("Trail ID " + trailId + " not found");
		return null;
	}

	public Set<Trail> getMostHikedTrails() {
		Set<Trail> mostHiked = new LinkedHashSet<Trail>();
		int max = 0;
		for (Trail trail : trailList) {
			max = Math.max(trail.getHikeCount(), max);
		}
		for (Trail trail : trailList) {
			if (trail.getHikeCount() == max) {
				mostHiked.add(trail);
			}
		}
		return mostHiked;
	}

	public Map<String, String> getHikeCountByRegion() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (Trail trail : trailList) {
			String region = trail.getRegion();
			map.put(region, map.getOrDefault(region, 0) + trail.getHikeCount());
		}
		Map<String, String> regionWiseHike = new LinkedHashMap<String, String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			regionWiseHike.put(entry.getKey(), entry.getValue() + " hikes");
		}
		return regionWiseHike;
	}

	public Map<String, List<Trail>> groupTrailsByDifficulty() {
		Map<String, List<Trail>> difficultyMap = new LinkedHashMap<String, List<Trail>>();
		for (Trail trail : trailList) {
			String difficulty = trail.getDifficulty();
			if (!difficultyMap.containsKey(difficulty)) {
				difficultyMap.put(difficulty, new ArrayList<Trail>());
			}
			difficultyMap.get(difficulty).add(trail);
		}
		return difficultyMap;
	}

	public boolean updateHikeCount(String trailId, int additionalHikes) {
		for (Trail trail : trailList) {
			if (trail.getTrailId().equals(trailId)) {
				int hikeCount = trail.getHikeCount();
				trail.setHikeCount(hikeCount + additionalHikes);
				return true;
			}
		}
		System.out.println("Trail not found");
		return false;
	}

	public List<Trail> filterTrails(String region, String difficulty) {
		List<Trail> filteredList = new ArrayList<Trail>();
		for (Trail trail : trailList) {
			if (trail.getRegion().equals(region) && trail.getDifficulty().equals(difficulty)) {
				filteredList.add(trail);
			}
		}
		return filteredList;
	}

	public Map<String, List<Trail>> getTopTrailsByRegion(int n) {
		Map<String, List<Trail>> grouped = new LinkedHashMap<>();
		for (Trail trail : trailList) {
			String region = trail.getRegion();
			if (!grouped.containsKey(region)) {
				grouped.put(region, new ArrayList<>());
			}
			grouped.get(region).add(trail);
		}
		Map<String, List<Trail>> topTrails = new LinkedHashMap<>();
		for (String region : grouped.keySet()) {
			List<Trail> list = grouped.get(region);
			Collections.sort(list, (t1, t2) -> t2.getHikeCount() - t1.getHikeCount());
			List<Trail> topList = new ArrayList<>();
			for (int i = 0; i < n && i < list.size(); i++) {
				topList.add(list.get(i));
			}
			topTrails.put(region, topList);
		}
		return topTrails;
	}

	public Map<String, String> getDifficultyStats() {
		Map<String, List<Trail>> grouped = new LinkedHashMap<>();
		for (Trail trail : trailList) {
			String difficulty = trail.getDifficulty();
			if (!grouped.containsKey(difficulty)) {
				grouped.put(difficulty, new ArrayList<>());
			}
			grouped.get(difficulty).add(trail);
		}

		Map<String, String> stats = new LinkedHashMap<String, String>();
		for (String difficulty : grouped.keySet()) {
			List<Trail> list = grouped.get(difficulty);
			int count = list.size();
			int total = 0;
			for (Trail trail : list) {
				total += trail.getHikeCount();
			}
			int average = 0;
			if (count != 0) {
				average = total / count;
			}
			String summary = "count =" + count + ", totalHikes=" + total + ", averageHikes=" + average;
			stats.put(difficulty, summary);
		}
		return stats;
	}

	public List<Trail> getTrailList() {
		return trailList;
	}

	public void setTrailList(List<Trail> trailList) {
		this.trailList = trailList;
	}
}
