package Misson.Week01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class TicketOffice {
  private Long amount;
  //private List<Ticket> tickets = new ArrayList<>();
  private Map<Movie , List<Ticket>> movieListMap = new HashMap<>();
  private final Theater theater;

  public TicketOffice(Long amount, Theater theater) {
    this.amount = amount;
    this.theater = theater;
  }

  public void addTicket(Ticket ticket) {
    Movie movie = ticket.getMovie();
    if(movieListMap.containsKey(movie)) {
      movieListMap.get(movie).add(ticket);
    } else {
      List<Ticket> ticketList = new ArrayList<>();
      ticketList.add(ticket);
      movieListMap.put(movie, ticketList);
    }
  }

  public Long getTicketPrice(Movie movie) {
    if(movieListMap.size() == 0 ) return 0L;
    else return movieListMap.get(movie).get(0).getFee();
  }

  public Ticket getTicketWithFee(Movie movie) {
    if(movieListMap.size() == 0) return Ticket.EMPTY;
    else {
      Ticket ticket = movieListMap.get(movie).remove(0);
      amount += ticket.getFee();
      return ticket;
    }
  }

  public Ticket getTicketWithNoFee(Movie movie) {
    if(movieListMap.size() == 0) return Ticket.EMPTY;
    else return movieListMap.get(movie).remove(0);
  }

}
