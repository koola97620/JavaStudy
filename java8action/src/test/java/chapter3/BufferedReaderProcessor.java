package chapter3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author choijaeyong on 2020/03/27.
 * @project java8action
 * @description
 */

@FunctionalInterface
public interface BufferedReaderProcessor {
  String process(BufferedReader br) throws IOException;

}
