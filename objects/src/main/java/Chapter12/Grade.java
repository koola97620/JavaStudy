package Chapter12;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public class Grade {
  private String name;
  private int upper, lower;

  public Grade(String name, int upper, int lower) {
    this.name = name;
    this.upper = upper;
    this.lower = lower;
  }

  public String getName() {
    return name;
  }

  public boolean isName(String name) {
    return this.name.equals(name);
  }

  public boolean include(int score) {
    return score >= lower && score <= upper;
  }
}
