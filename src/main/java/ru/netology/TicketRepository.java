package ru.netology;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll(){
        return tickets;
    }

    public void add(Ticket ticket){
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }
}
