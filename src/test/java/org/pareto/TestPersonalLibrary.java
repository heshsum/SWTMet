package org.pareto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pareto.model.Book;
import org.pareto.model.PersonalLibrary;

public class TestPersonalLibrary {
    PersonalLibrary pl;

    Book b1;
    Book b2;
    Book b3;

    @BeforeEach
    void setup() {
        pl = new PersonalLibrary();
        b1 = new Book("author1", "title1");
        b2 = new Book("author2", "title2");
        b3 = new Book("author3", "title3");
    }

    @Test
    void add() {
        pl.add(b1);
        Assertions.assertEquals(1, pl.getSize());
        pl.add(b2);
        Assertions.assertEquals(2, pl.getSize());
        pl.add(b3);
        Assertions.assertEquals(3, pl.getSize());
    }
}
