package chapter6;



public class Client {
	private static final int User_Num=5;
	public static void main(String[] args) {
		UserThread[] user = new UserThread[User_Num];
		for(int i =0 ; i < User_Num ; i++) {
			user[i] = new UserThread((i+1) + "-thread"); // user인스턴스 생성
			user[i].start();
		}
		

	}

}
