package Misson.Week01;

/**
 * @author choijaeyong on 07/07/2019.
 * @project objects
 * @description
 *
 * 1. 마지막 theater 예제에서 TicketOffice는 암묵적으로 하나의 극장하고만
 * 계약하고 있다는 가정이 있게 구현되어 있다. 코드상 이 조건을 강제하도록 개선하라.
 *
 * 2. 마지막 theater 예제에서 Theater는 단 하나의 영화만 고정 가격으로 상영중이다.
 *  다양한 가격의 영화를 상영할 수 있게 개선하라.
 * (Movie클래스가 새롭게 필요하고 또한 이에 따라 초대, 티켓, 티켓오피스등의 총괄적인 변화가 일어남)
 *
 * 고민해야할 점
 * - 하나의 영화가 여러개의 가격을 가질 수 있는 건가.?
 * - 과제에서 극장의 수는 하나로 고정인건가? 아닌듯.
 *   티켓의 isValid 메서드를 보면 극장이 여러개 일 수도 있다고 가정하는 코드가 보인다.
 *
 * 일단 1,2 번의 문제만 해결하는 코드만 만들어보자.
 */
public class Main {
  public static void main(String[] args) {
    Theater theater = new Theater("CGV");

    Audience audience1 = new Audience(100L);
    Audience audience2 = new Audience(100L);
    TicketOffice ticketOffice = new TicketOffice(0L,theater);

    TicketSeller seller = new TicketSeller();
    seller.setTicketOffice(ticketOffice);

    Movie movie1 = new Movie("코드스피츠1");
    Movie movie2 = new Movie("코드스피츠2");

    theater.setTicketOffices(ticketOffice);
    theater.setTicket(ticketOffice,10L, movie1, 100L);
    theater.setTicket(ticketOffice, 10L, movie2, 200L);
    theater.setInvitation(audience1, movie1);
    theater.setInvitation(audience2, movie2);


    audience1.buyTicket(seller , movie1);
    boolean isOk1 = theater.enter(audience1,movie1);

    audience1.buyTicket(seller,movie1);
    boolean isOk2 = theater.enter(audience1,movie1);

    audience1.buyTicket(seller,movie1);
    boolean isOk3 = theater.enter(audience1,movie1);

    System.out.println(isOk1);
    System.out.println(isOk2);
    System.out.println(isOk3);

    audience2.buyTicket(seller , movie1);
    boolean isOk4 = theater.enter(audience2,movie1);

    audience2.buyTicket(seller , movie2);
    boolean isOk5 = theater.enter(audience2,movie2);

    audience2.buyTicket(seller , movie1);
    boolean isOk6 = theater.enter(audience2,movie1);

    audience2.buyTicket(seller , movie2);
    boolean isOk7 = theater.enter(audience2,movie2);

    System.out.println(isOk4);
    System.out.println(isOk5);
    System.out.println(isOk6);
    System.out.println(isOk7);

  }

}
