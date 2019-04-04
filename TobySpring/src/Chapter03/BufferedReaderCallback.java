package Chapter03;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author choijaeyong on 04/04/2019.
 * @project TobySpring
 * @description
 */
public interface BufferedReaderCallback {
  Integer doSomethingWithReader(BufferedReader br) throws IOException;

}
