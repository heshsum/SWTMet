package org.pareto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pareto.model.Book;

/**
 * Class to test Book.
 * @author Hendrik Schlange
 * @version 1.0
 */
class TestBook {
    /** Book object to use in tests. */
    Book b;

    /** Default title to use in tests. */
    String t = "title";

    /** Default author to use in tests. */
    String a = "author";

    /** Default publisher to use in tests. */
    String p = "publisher";

    /** Default year to use in tests. */
    int y = 1988;

    /** Default ISBN to use in tests. */
    String i = "123456";

    /** Default price to use in tests. */
    double price = 9.99;

    @BeforeEach
    void setup() {
        b = new Book(a, t);
    }

    @Test
    void getAuthor() {
        Assertions.assertEquals(a, b.getAuthor());
    }

    @Test
    void getTitle() {
        Assertions.assertEquals(t, b.getTitle());
    }

    @Test
    void getPublisher() {
        b.setPublisher(p);
        Assertions.assertEquals(p, b.getPublisher());
    }

    @Test
    void getEbook() {
        Assertions.assertFalse(b.getEbook());
        b.setEbook(true);
        Assertions.assertTrue(b.getEbook());
    }

    @Test
    void setAuthor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> b.setAuthor(""));
    }

    @Test
    void setTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> b.setTitle(""));
    }

    @Test
    void year() {
        b.setYear(y);
        Assertions.assertEquals(y, b.getYear());
    }

    @Test
    void isbn() {
        b.setIsbn(i);
        Assertions.assertEquals(i, b.getIsbn());
    }

    @Test
    void price() {
        b.setPrice(price);
        Assertions.assertEquals(price, b.getPrice());
    }
}
