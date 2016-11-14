package chapter9;

import java.util.Collections;
import java.util.List;

public interface Observer {
	public void update();
}

class DataSheetView implements Observer {
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
		this.scoreRecord = scoreRecord;
		this.viewCount = viewCount;
	}
	
	
	public void update() { // 점수를 통보받음
		List<Integer> record = scoreRecord.getScoreRecord(); //점수를 조회함
		displayScores(record,viewCount);
	}
	
	private void displayScores(List<Integer> record, int viewCount) {
		System.out.println("List of " + viewCount + " entries : ");
		for(int i=0; i < viewCount && i < record.size() ; i++) {
			System.out.println(record.get(i) + " ");
		}
		System.out.println();
	}
}


class MinMaxView implements Observer {
	private ScoreRecord scoreRecord;
	
	public MinMaxView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}
	
	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMax(record);
	}
	
	private void displayMinMax(List<Integer> record) {
		int min = Collections.min(record);
		int max = Collections.max(record);
		System.out.println("Min : " + min + "   Max : " + max);
	}
	
}

class StatisticsView implements Observer {
	private ScoreRecord scoreRecord;
	
	public StatisticsView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}
	
	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayStatistics(record);
	}
	
	private void displayStatistics(List<Integer> record) {
		int sum=0;
		for(int score : record) {
			sum += score;
		}
		float ave = (float) sum/record.size();
		System.out.println("Sum : " + sum + "   Avg : " + ave);
	}
	
	
}


