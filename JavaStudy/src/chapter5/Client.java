package chapter5;



class TaekwonV extends Robot {
	public TaekwonV(String name) {
		super(name);
	}
}

class Atom extends Robot {
	public Atom(String name) {
		super(name);
	}
}

class FlyingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("I can fly!!");
	}
}
class WalkingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("i can only walk");
	}
}


class MissileStrategy implements AttackStrategy {
	public void attack() {
		System.out.println("i have missile");
	}
}
class PunchStrategy implements AttackStrategy {
	public void attack() {
		System.out.println("i have strong punch");
	}
}

public class Client {

	public static void main(String[] args) {
		Robot taekwonV = new TaekwonV("TaekwnoV");
		Robot atom = new Atom("Atom");
		
		taekwonV.setMovingStrategy(new WalkingStrategy());
		taekwonV.setAttackStrategy(new MissileStrategy());
		
		atom.setMovingStrategy(new FlyingStrategy());
		atom.setAttackStrategy(new PunchStrategy());
		
		
		System.out.println("my name is" + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		
		System.out.println("---------------------------");
		
		System.out.println("my name is" + atom.getName());
		atom.move();
		atom.attack();

	}

}
