package Chapter12;

/**
 * @author choijaeyong on 19/08/2019.
 * @project objects
 * @description
 */
public class Professor {
  private String name;
  private Lecture lecture;

  public Professor(String name, Lecture lecture) {
    this.name = name;
    this.lecture = lecture;
  }

  public String compileStatistics() {
    return String.format("[%s] %s - Avg: %.1f" , name, lecture.evaluate(),lecture.average());
  }
}
