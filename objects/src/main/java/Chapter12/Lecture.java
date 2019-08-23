package Chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public class Lecture {
  private int pass;
  private String title;
  private List<Integer> scores = new ArrayList<>();

  public Lecture(int pass, String title, List<Integer> scores) {
    this.pass = pass;
    this.title = title;
    this.scores = scores;
  }

  public double average() {
    return scores.stream()
        .mapToInt(Integer::intValue)
        .average().orElse(0);
  }

  public List<Integer> getScores() {
    return Collections.unmodifiableList(scores);
  }

  public String evaluate() {
    return String.format("Pass:%d Fail:%d" , passCount() , failCount());
  }

  private long passCount() {
    return scores.stream().filter(score -> score >= pass).count();
  }

  private long failCount() {
    return scores.size() - passCount();
  }

  public String stats() {
    return String.format("Title: %s, Evaluation Method: %s" , title, getEvaluationMethod());
  }

  public String getEvaluationMethod() {
    return "Pass or Fail";
  }

}
