package id.rakhmad.demo;

import java.util.concurrent.ThreadLocalRandom;

public class Book {

    public String title;
    public int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public static Book of(String title) {
        int year = ThreadLocalRandom.current().nextInt(1980, 2020);
        return new Book(title, year);
    }

    @Override
    public String toString() {
        return String.format("Book %s is published on %d.", title, year);
    }
}
