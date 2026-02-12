package m1_mock_questions.eco_trail;

public class Trail {
	private String trailId;
	private String name;
	private String region;
	private String difficulty;
	private int hikeCount;

	Trail() {
	}

	Trail(String trailId, String name, String region, String difficulty, int hikeCount) {
		setTrailId(trailId);
		setName(name);
		setDifficulty(difficulty);
		setHikeCount(hikeCount);
		setRegion(region);
	}

	public String getTrailId() {
		return trailId;
	}

	public void setTrailId(String trailId) {
		this.trailId = trailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getHikeCount() {
		return hikeCount;
	}

	public void setHikeCount(int hikeCount) {
		this.hikeCount = hikeCount;
	}

	@Override
	public String toString() {
		return trailId + " | " + name + " | " + region + " | " + difficulty + " | " + hikeCount + " hikes";
	}

}
