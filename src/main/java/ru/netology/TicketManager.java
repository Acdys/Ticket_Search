package ru.netology;


import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private final TicketRepository repository;

    public TicketManager(TicketRepository repository){
        this.repository = repository;
    }
    public void add(Ticket product){
        repository.add(product);
    }

    public Ticket[] findAll(String from, String to){
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()){
            if(matches(ticket, from, to)){
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator){
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()){
            if(matches(ticket, from, to)){
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    private boolean matches(Ticket ticket, String from, String to){
        if (ticket.getFrom().equals(from)){
            return ticket.getTo().equals(to);
        }
        return false;
    }
}
