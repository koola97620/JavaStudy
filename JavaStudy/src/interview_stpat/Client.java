package interview_stpat;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class Client {
	
	private final Logging2 logging;
	public Client (Logging2 logging) {
		this.logging = logging;
	}
	
	public void doWork(final int count) {
		if(count % 2==0) {
			logging.write("Even number : " + count);
		}
	}

}

class ClientTest {
	@Test
	public void useConsoleLogging() {
		final Client c = new Client(new ConsoleLogging());
		c.doWork(32);
	}
	
	@Test
	public void useFileLogging() throws IOException {
		final File tempFile = File.createTempFile("test", "log");
		final Client c = new Client(new FileLogging(tempFile));
		c.doWork(41);
		c.doWork(42);
		c.doWork(43);
		
		final BufferedReader reader = new BufferedReader(new FileReader(tempFile));
		assertEquals("Even number : 42", reader.readLine());
		assertEquals(-1, reader.read());
	}
	
//	@Test
//	public void useMockLogging() {
//		final Logging2 mockLogging = mock(Logging2.class);
//	}

	
}