package chapter8;

public interface Command {
	public void execute();
}


class LampOnCommand implements Command {
	private Lamp theLamp;
	
	public LampOnCommand(Lamp theLamp) {
		this.theLamp = theLamp;
	}
	public void execute() {
		theLamp.turnOn();
	}
}

class AlarmOnCommand implements Command {
	private Alarm theAlarm;
	
	public AlarmOnCommand(Alarm alarm) {
		this.theAlarm = alarm;
	}
	public void execute() {
		theAlarm.start();
	}
	
}