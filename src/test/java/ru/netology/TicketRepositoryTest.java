package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    @Test
    public void shouldTicketAll(){

        TicketRepository repo = new TicketRepository();

        Ticket ticket1 = new Ticket(1, "MSK", "SPB", 3_000, 92);
        Ticket ticket2 = new Ticket(2, "MSK", "KRR", 5_000, 135);
        Ticket ticket3 = new Ticket(3, "STW", "TR", 12_300, 150);
        Ticket ticket4 = new Ticket(4, "MSK", "SPB", 3_200, 88);
        Ticket ticket5 = new Ticket(5, "SPB", "KZ", 17_800, 220);
        Ticket ticket6 = new Ticket(6, "MSK", "BOS", 51_682, 785);
        Ticket ticket7 = new Ticket(7, "MSK", "SPB", 2_800, 95);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketOne(){

        TicketRepository repo = new TicketRepository();

        Ticket ticket7 = new Ticket(7, "MSK", "SPB", 2_800, 95);

        repo.add(ticket7);

        Ticket[] expected = {ticket7};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketFew(){

        TicketRepository repo = new TicketRepository();

        Ticket ticket2 = new Ticket(2, "MSK", "KRR", 5_000, 135);
        Ticket ticket5 = new Ticket(5, "SPB", "KZ", 17_800, 220);
        Ticket ticket7 = new Ticket(7, "MSK", "SPB", 2_800, 95);


        repo.add(ticket2);
        repo.add(ticket5);
        repo.add(ticket7);

        Ticket[] expected = {ticket2, ticket5, ticket7};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
