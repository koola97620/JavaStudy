package chapter9;

public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();
		DataSheetView data3 = new DataSheetView(scoreRecord,3);
		scoreRecord.attach(data3);
		
		MinMaxView mmv = new MinMaxView(scoreRecord);
		scoreRecord.attach(mmv);
		
		//3개목록, 5개목록 데이터뷰 , 그리고 minmax가 옵저버로 설정됨
		for(int i=1 ; i <= 5 ; i++) {
			int score = i * 10;
			System.out.println("Adding : " + score);
			scoreRecord.addScore(score);
		}
		
		scoreRecord.detach(data3); // 3개 목록짜리 Observer 아님
		
		
		
		StatisticsView stv = new StatisticsView(scoreRecord);
		scoreRecord.attach(stv);
		
		for(int i=1 ; i <=5 ; i++) {
			int score = i * 8;
			System.out.println("Adding : " + score);
			scoreRecord.addScore(score);
			
		}
		

	}

}
