package Exer_Bracket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Bracket bc = new Bracket(str);
		bc.setStrategy(new UseListStrategy());
		bc.bracVaild();
		
		bc.setStrategy(new UseStackStrategy());
		bc.bracVaild();
		

	}

}
