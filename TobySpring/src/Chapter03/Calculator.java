package Chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author choijaeyong on 04/04/2019.
 * @project TobySpring
 * @description
 */
public class Calculator {
  public Integer calcSum(String filePath) throws IOException {
    BufferedReaderCallback sumCallback =
        new BufferedReaderCallback() {
          @Override
          public Integer doSomethingWithReader(BufferedReader br) throws IOException {
            Integer sum = 0;
            String line = null;
            while((line = br.readLine()) != null) {
              sum += Integer.valueOf(line);
              System.out.println(sum);
            }
            return sum;
          }
        };
    System.out.println(filePath + "    ");
    return fileReadTemplate(filePath,sumCallback);

  }


  public Integer calcMultiply(String filepath) throws IOException {
    BufferedReaderCallback multiplyCallback =
        new BufferedReaderCallback() {
          @Override
          public Integer doSomethingWithReader(BufferedReader br) throws IOException {
            Integer multiply = 1;
            String line = null;
            while((line = br.readLine()) != null){
              multiply *= Integer.valueOf(line);
            }
            return multiply;
          }
        };
    return fileReadTemplate(filepath,multiplyCallback);

  }



  public Integer fileReadTemplate(String filePath,
      BufferedReaderCallback callback) throws IOException{

    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(filePath));

      // 콜백 오브젝트 호출, 템플릿에서 만든 컨텍스트 정보인 BufferedReader를 전달해주고
      // 콜백의 작업 결과를 받아둔다.
      int ret = callback.doSomethingWithReader(br);
      return ret;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      throw e;
    } finally {
      if(br!=null) {
        try{br.close();}
        catch(IOException e){
          System.out.println(e.getMessage());
        }
      }
    }

  }


}
