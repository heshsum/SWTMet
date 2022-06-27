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

    @BeforeEach
    void setup() {
        b = new Book(a, t);
    }

    @Test
    void getAuthor() {
        Assertions.assertEquals(b.getAuthor(), a);
    }

    @Test
    void getTitle() {
        Assertions.assertEquals(b.getTitle(), t);
    }

    @Test
    void getPublisher() {
        b.setPublisher(p);
        Assertions.assertEquals(b.getPublisher(), p);
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
}