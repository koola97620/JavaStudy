package chapter3;

class Kid {
	private Toy toy;
	
	public void setToy(Toy toy) {
		this.toy = toy;
	}
	
	public void play() {
		System.out.println(toy.toString());
	}
}

class Toy{
	
}
class Robot extends Toy {
	public String toString() {
		return "Robot";
	}
}
class Lego extends Toy {
	public String toString() {
		return "Lego";
	}
}

class test {
	private int k=1;
	
	private test() {
		System.out.println("생성자! ");
	}
}
public class dip_01 {

	public static void main(String[] args) {
		Toy[] t = {new Robot(), new Lego()};
		
		
		Kid k = new Kid();
		Robot r = new Robot();
//		test test1 = new test();
		k.setToy(r);
		k.setToy(t[0]);
		k.play();
		
		k.setToy(t[1]);
		k.play();
	}

}
