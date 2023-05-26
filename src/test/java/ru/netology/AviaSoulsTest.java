package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Moscow", "Irkutsk", 55_000, 8,14);
    Ticket ticket2 = new Ticket("Riga", "Novosibirsk", 15_000, 4, 9);
    Ticket ticket3 = new Ticket("Krasnoyarsk", "Novosibirsk", 30_000, 15,20);
    Ticket ticket4 = new Ticket("Moscow", "Irkutsk", 30_000, 6,9);
    Ticket ticket5 = new Ticket("Moscow", "Chita", 6_500, 5,8);
    Ticket ticket6 = new Ticket("Moscow", "Irkutsk", 13_500, 10,15);
    Ticket ticket7 = new Ticket("Krasnoyarsk", "Novosibirsk", 5_000, 4,6);
    Ticket ticket8 = new Ticket("Chita", "Novosibirsk", 8_000, 19,20);
    Ticket ticket9 = new Ticket("Krasnoyarsk", "Novosibirsk", 2_000, 15,16);
    Ticket ticket10 = new Ticket("Moscow", "Irkutsk", 18_000, 11,15);

    @Test
    public void shouldShowThatPriceAreGreater() {
        manager.add(ticket1);
        manager.add(ticket2);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowThatAreLess() {
        manager.add(ticket1);
        manager.add(ticket2);

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowThatAreEqual() {
        manager.add(ticket3);
        manager.add(ticket4);

        int expected = 0;
        int actual = ticket3.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromMSCToIKT() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket6, ticket10, ticket4, ticket1};
        Ticket[] actual = manager.search("Moscow", "Irkutsk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromKJAToNSK() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket9, ticket7, ticket3};
        Ticket[] actual = manager.search("Krasnoyarsk", "Novosibirsk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromHTAToNSK() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.search("Chita", "Novosibirsk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromPRSToBRL() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Paris", "Berlin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareThatOneDepartureTimeAreLessThanAnother() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        int expected = -1;
        int actual = comparator.compare(ticket5, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareThatOneDepartureTimeAreGreaterThanAnother() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        int expected = 1;
        int actual = comparator.compare(ticket3, ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareThatOneDepartureTimeAreEqualThanAnother() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        int expected = 0;
        int actual = comparator.compare(ticket8, ticket9);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromMSCToIKTByDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket4, ticket10, ticket6, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Irkutsk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromKJAToNSKDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket9, ticket7, ticket3};
        Ticket[] actual = manager.searchAndSortBy("Krasnoyarsk", "Novosibirsk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromHTAToNSKDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.searchAndSortBy("Chita", "Novosibirsk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTheTicketsFromPRSToBRLDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Paris", "Berlin", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
