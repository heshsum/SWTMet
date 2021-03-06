package org.pareto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pareto.model.Book;
import org.pareto.model.PersonalLibrary;

class TestPersonalLibrary {
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
    void addByBook() {
        pl.add(b1);
        Assertions.assertEquals(1, pl.getSize());
        pl.add(b2);
        Assertions.assertEquals(2, pl.getSize());
        pl.add(b3);
        Assertions.assertEquals(3, pl.getSize());
    }

    @Test
    void addByString() {
        pl.add("author", "title");
        Assertions.assertEquals("author", pl.get(0).getAuthor());
        Assertions.assertEquals("title", pl.get(0).getTitle());
    }

    @Test
    void removeByBook() {
        pl.add(b1);
        Assertions.assertEquals(1, pl.getSize());
        pl.remove(b1);
        Assertions.assertEquals(0, pl.getSize());
        pl.add(b1);
        pl.add(b2);
        pl.remove(b1);
        Assertions.assertEquals(1, pl.getSize());
    }

    @Test
    void removeByIndex() {
        pl.add(b1);
        pl.add(b2);
        Assertions.assertEquals(2, pl.getSize());
        pl.remove(0);
        Assertions.assertEquals(1, pl.getSize());
        Assertions.assertEquals(b2, pl.get(0));
    }

    @Test
    void getByIndex() {
        pl.add(b1);
        pl.add(b2);
        pl.add(b3);
        Assertions.assertEquals(b1, pl.get(0));
        Assertions.assertEquals(b2, pl.get(1));
        Assertions.assertEquals(b3, pl.get(2));
    }

    @Test
    void getByIllegalIndex() {
        pl.add(b1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> pl.get(1));
    }

    @Test
    void getAll() {
        pl.add(b1);
        pl.add(b2);
        pl.add(b3);
        Assertions.assertEquals(3, pl.getAll().size());
        Assertions.assertEquals(b1, pl.getAll().get(0));
        Assertions.assertEquals(b2, pl.getAll().get(1));
        Assertions.assertEquals(b3, pl.getAll().get(2));
    }
}
