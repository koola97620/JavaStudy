package chapter7;

public class VendingMachine {
	private State noMoneyState;
	private State noEnoughMoneyState;
	private State enoughMoneyState;
	private State soldOutState;
	private State state;
	
	private Drinking drinking;
	private MoneyBox moneyBox;
	
	public VendingMachine(int price, int stock) {
		noMoneyState = new NoMoneyState(this);
		noEnoughMoneyState = new NoEnoughMoneyState(this);
		enoughMoneyState = new EnoughMoneyState(this);
		soldOutState = new SoldOutState(this);
		
		drinking = new Drinking(price, stock);
		moneyBox = new MoneyBox();
		
		if(drinking.getStock() > 0) {
			state = noMoneyState;
		} else {
			state = soldOutState;
		}
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	
	public void insertMoney(int money) {
		state.insertMoney(money);
	}
	public void pushButton(int price) {
		state.pushButton(price);
	}
	public void returnMoney() {
		state.returnMoney();
	}
	
	public MoneyBox getMoneyBox() {
		return moneyBox;
	}
	public Drinking getDrinking() {
		return drinking;
	}
	
	public State getNoEnoughMoney() {
		return noEnoughMoneyState;
	}
	public State getEnoughMoney() {
		return enoughMoneyState;
	}
	public State getNoMoneyState() {
		return noMoneyState;
	}
	public State getSoldOutState() {
		return soldOutState;
	}
	
	
}


class Drinking {
	private int price;
	private int stock;
	public Drinking(int price, int stock) {
		this.price=price;
		this.stock=stock;
	}
	public void dispense() {
		this.stock--;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
}

class MoneyBox {
	private int money;
	public int getMoney() {
		return money;
	}
	public void insert(int money) {
		this.money += money;
	}
	public void dispense(int money) {
		this.money -= money;
	}
	public int returnMoney() {
		int temp = this.money;
		this.money=0;
		return temp;
	}
	
}