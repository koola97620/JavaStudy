package Chapter10;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class Song {
  private String singer;
  private String title;

  public Song(String singer, String title) {
    this.singer = singer;
    this.title = title;
  }

  public String getSinger() {
    return singer;
  }

  public String getTitle() {
    return title;
  }
}
