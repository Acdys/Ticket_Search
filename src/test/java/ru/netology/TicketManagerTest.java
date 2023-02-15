package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {

    @Test
    public void shouldSortTicket() {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "MSK", "SPB", 3_000, 92);
        Ticket ticket2 = new Ticket(2, "MSK", "KRR", 5_000, 135);
        Ticket ticket3 = new Ticket(3, "STW", "TR", 12_300, 150);
        Ticket ticket4 = new Ticket(4, "MSK", "SPB", 3_000, 88);
        Ticket ticket5 = new Ticket(5, "SPB", "KZ", 17_800, 220);
        Ticket ticket6 = new Ticket(6, "MSK", "BOS", 51_682, 785);
        Ticket ticket7 = new Ticket(7, "MSK", "SPB", 2_800, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket7, ticket1, ticket4};
        Ticket[] actual = manager.findAll("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketNegative() {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "MSK", "SPB", 3_000, 92);
        Ticket ticket2 = new Ticket(2, "MSK", "KRR", 5_000, 135);
        Ticket ticket3 = new Ticket(3, "STW", "TR", 12_300, 150);
        Ticket ticket4 = new Ticket(4, "MSK", "SPB", 3_200, 88);
        Ticket ticket5 = new Ticket(5, "SPB", "KZ", 17_800, 220);
        Ticket ticket6 = new Ticket(6, "MSK", "BOS", 51_682, 785);
        Ticket ticket7 = new Ticket(7, "MSK", "SPB", 2_800, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MSK", "UFA");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketOne() {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "MSK", "SPB", 3_000, 92);
        Ticket ticket2 = new Ticket(2, "MSK", "KRR", 5_000, 135);
        Ticket ticket3 = new Ticket(3, "STW", "TR", 12_300, 150);
        Ticket ticket4 = new Ticket(4, "MSK", "SPB", 3_200, 88);
        Ticket ticket5 = new Ticket(5, "SPB", "KZ", 17_800, 220);
        Ticket ticket6 = new Ticket(6, "MSK", "BOS", 51_682, 785);
        Ticket ticket7 = new Ticket(7, "MSK", "SPB", 2_800, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.findAll("MSK", "BOS");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketComparator() {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "MSK", "SPB", 3_000, 92);
        Ticket ticket2 = new Ticket(2, "MSK", "KRR", 5_000, 135);
        Ticket ticket3 = new Ticket(3, "STW", "TR", 12_300, 150);
        Ticket ticket4 = new Ticket(4, "MSK", "SPB", 3_200, 88);
        Ticket ticket5 = new Ticket(5, "SPB", "KZ", 17_800, 220);
        Ticket ticket6 = new Ticket(6, "MSK", "BOS", 51_682, 785);
        Ticket ticket7 = new Ticket(7, "MSK", "SPB", 2_800, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketComparator.TicketByDurationAscComparator();

        Ticket[] expected = {ticket4, ticket1, ticket7};
        Ticket[] actual = manager.findAll("MSK", "SPB",comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
