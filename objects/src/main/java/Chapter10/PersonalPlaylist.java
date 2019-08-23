package Chapter10;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class PersonalPlaylist extends Playlist {

  public void remove(Song song) {
    getTracks().remove(song);
    getSingers().remove(song.getSinger());
  }
}
