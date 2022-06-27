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
    void testBook() {
        Assertions.assertEquals(b.getAuthor(), a);
        Assertions.assertEquals(b.getTitle(), t);
    }

    @Test
    void testException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> b.setTitle(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> b.setAuthor(""));
    }
}
