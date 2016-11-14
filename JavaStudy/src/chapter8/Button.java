package chapter8;

public class Button {
	private Command theCommand;
	
	public Button(Command theCommand) {
		setCommand(theCommand);
	}
	
	public void setCommand(Command theCommand) {
		this.theCommand = theCommand;
	}
	
	public void pressed() {
		theCommand.execute();
	}
}

class Lamp {
	public void turnOn() {
		System.out.println("Lamp on!!");
	}
}

class Alarm {
	public void start() {
		System.out.println("Alarming...");
	}
	
}