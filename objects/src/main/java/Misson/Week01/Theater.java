package Misson.Week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class Theater {
  final private List<TicketOffice> ticketOffices = new ArrayList<>();
  final private Long fee;

  public Theater(Long fee) {
    this.fee = fee;
  }

  Long getFee() {
    return this.fee;
  }

  public void setTicketOffices(TicketOffice ... ticketOffices) {
    this.ticketOffices.addAll(Arrays.asList(ticketOffices));
  }

  public void setTicket(TicketOffice ticketOffice, Long num) {
    if(!ticketOffices.contains(ticketOffice)) {
      return;
    }

    // 티켓오피스에 티켓을 세팅하는데. 티켓이 5만개면 . 반복문이 5만번 돌아가야하는건가 ㄷㄷ
    // num 이 갯수를 뜻하는게 맞긴 한가?
    while(num-- > 0) {
      ticketOffice.addTicket(new Ticket(this));
    }
  }

  public void setInvitation(Audience audience) {
    audience.setInvitation(new Invitation(this));
  }

  public boolean enter(Audience audience) {
    Ticket ticket = audience.getTicket();
    return ticket.isValid(this);
  }

}
