package interview_stpat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface Logging2 {
	void write(String message);
}


class ConsoleLogging implements Logging2{
	@Override
	public void write(final String message) {
		System.out.println(message);
	}

}


class FileLogging implements Logging2{
	private final File toWrite;
	
	public FileLogging(final File toWrite){
		this.toWrite = toWrite;
	}
	@Override
	public void write(final String message) {
		try {
			final FileWriter fos = new FileWriter(toWrite);
			fos.write(message);
			fos.close();
		}catch(IOException e) {
			
		}
	}
}