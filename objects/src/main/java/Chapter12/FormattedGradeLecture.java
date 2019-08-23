package Chapter12;

import java.util.List;

/**
 * @author choijaeyong on 19/08/2019.
 * @project objects
 * @description
 */
public class FormattedGradeLecture extends GradeLecture {

  public FormattedGradeLecture(int pass, String title, List<Integer> scores,
      List<Grade> grades) {
    super(pass, title, scores, grades);
  }

  public String formatAverage() {
    return String.format("Avg: %1.1f" , super.average());
  }
}
