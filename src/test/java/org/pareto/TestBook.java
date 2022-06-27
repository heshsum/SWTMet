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

    Boolean e = true;

    /** Default price to use in tests. */
    double price = 9.99;

    @BeforeEach
    void setup() {
        b = new Book(a, t);
    }

    @Test
    void create() {
        b.setAuthor(a);
        b.setTitle(t);
        b.setPublisher(p);
        b.setYear(y);
        b.setIsbn(i);
        b.setPrice(price);
        b.setEbook(e);

        Book test = new Book(a, t, p, y, i, price, e);

        Assertions.assertEquals(a, test.getAuthor());
        Assertions.assertEquals(t, test.getTitle());
        Assertions.assertEquals(p, test.getPublisher());
        Assertions.assertEquals(y, test.getYear());
        Assertions.assertEquals(i, test.getIsbn());
        Assertions.assertEquals(price, test.getPrice());
        Assertions.assertEquals(e, test.getEbook());
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
    void setIllegalAuthor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> b.setAuthor(""));
    }

    @Test
    void setAuthor() {
        String s = "test";
        b.setAuthor(s);
        Assertions.assertEquals(s, b.getAuthor());
    }

    @Test
    void setIllegalTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> b.setTitle(""));
    }

    @Test
    void setTitle() {
        String s = "test";
        b.setTitle(s);
        Assertions.assertEquals(s, b.getTitle());
    }

    @Test
    void setYear() {
        b.setYear(y);
        Assertions.assertEquals(y, b.getYear());
    }

    @Test
    void setIsbn() {
        b.setIsbn(i);
        Assertions.assertEquals(i, b.getIsbn());
    }

    @Test
    void setPrice() {
        b.setPrice(price);
        Assertions.assertEquals(price, b.getPrice());
    }

    @Test
    void getString() {
        String s1 = "test1";
        String s2 = "test2";
        String r = "Author: " + s1 + System.lineSeparator()
                + "Title: " + s2 + System.lineSeparator();
        b.setAuthor(s1);
        b.setTitle(s2);

        Assertions.assertEquals(r, b.toString());
    }
}
