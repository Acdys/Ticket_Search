package ru.netology;

public class Ticket implements Comparable<Ticket>{
    private final int id;
    private final String from;
    private final String to;
    private final int price;
    private final int duration;

    public Ticket(int id, String from, String to, int price, int duration) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.getPrice();
    }
}
