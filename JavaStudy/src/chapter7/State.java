package chapter7;

public interface State {
	public void insertMoney(int money);
	public void pushButton(int price);
	public void returnMoney();
}


class NoMoneyState implements State {
	private VendingMachine machine;
	
	public NoMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);
		System.out.println(money + "원을 넣었다.");
		
		// 돈이 전혀 투입되지 않은 상태에서 음료를 사기에 충분한 돈을 투입한 경우.
		if(money >= machine.getDrinking().getPrice()) {
			machine.setState(machine.getEnoughMoney());
		} else {  //음료를 사기에 돈이 충분히 투입되지 않은 경우.
			machine.setState(machine.getNoEnoughMoney());
		}
		System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + " 원 입니다.");
	}
	
	public void pushButton(int price) { //돈이 전혀 투입되지 않은 경우 버튼을 누르는 경우.
		System.out.println("동전을 넣어주세요.");
	}
	public void returnMoney() {
		System.out.println("반환할 동전이 없어요.");
	}
	
}

class NoEnoughMoneyState implements State {
	private VendingMachine machine;
	public NoEnoughMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);
		System.out.println(money + "원을 넣었다.");
		
		//돈이 충분하게 투입되지 않은 상태에서 음료를 사기에 충분한 돈을 투입한 경우.
		if(machine.getMoneyBox().getMoney() >= machine.getDrinking().getPrice()) {
			machine.setState(machine.getEnoughMoney());
		} else {
			machine.setState(machine.getNoEnoughMoney());
		}
		System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원 입니다.");
	}
	
	public void pushButton(int price) {
		System.out.println("돈을 더 넣으세요.");
	}
	public void returnMoney() {
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoEnoughMoney());
	}
	
}

class EnoughMoneyState implements State {
	private VendingMachine machine;
	public EnoughMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);
		System.out.println(money + "원을 넣었다.");
		System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원 입니다.");
	}
	public void pushButton(int price) {
		machine.getMoneyBox().dispense(price);
		machine.getDrinking().dispense(); // 음료수 구입
		System.out.println("음료수가 나왔습니다.");
		
		//재고가 없다면.
		if(machine.getDrinking().getStock() == 0) {
			machine.setState(machine.getSoldOutState());
		} else if(machine.getMoneyBox().getMoney() < machine.getDrinking().getPrice()) { //돈이 부족한경우.
			machine.setState(machine.getNoEnoughMoney());
		} else if(machine.getMoneyBox().getMoney() == 0) {  // 잔액이 하나도 없는경우.
			machine.setState(machine.getNoMoneyState());
		}	
	}
	public void returnMoney() {
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoMoneyState());
	}
	
}

class SoldOutState implements State {
	private VendingMachine machine;
	public SoldOutState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		System.out.println("재고가 없어요! ");
	}
	public void pushButton(int price) { // 매진상태에서는 동작하지 않는다.
		
	}
	
	public void returnMoney() {
		int tmp = machine.getMoneyBox().getMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoMoneyState());
	}
}




