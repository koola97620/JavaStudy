package chapter9;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}
	}
}

// 구체적인 변경 감시 대상 데이터
class ScoreRecord extends Subject {
	private List<Integer> scores = new ArrayList<Integer>();
	
	public void addScore(int score) {
		scores.add(score);
		
		//통보하기
		notifyObservers();
	}
	
	public List<Integer> getScoreRecord() {
		return scores;
	}
	
	
}
