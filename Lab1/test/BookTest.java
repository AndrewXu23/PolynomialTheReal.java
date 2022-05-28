import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Person class
 */
public class BookTest {

    private Book Shame;
    private Book AmericanGods;

    @Before
    public void setUp() {
        this.Shame = new Person("Shame", "Doe", 36);
        this.AmericanGods = new Person("AmericanGods", "Bill", 99);
    }

    @Test
    public void testTitle() {
        assertEquals("Shame", this.Shame.getTitle());
        assertEquals("AmericanGods", this.AmericanGods.getTitle());
    }

    @Test
    public void testPrice() {
        assertEquals(36, this.Shame.getPrice(), delta:0.001);
        assertEquals(99, this.AmericanGods.getPrice(), delta:0.001);
    }

    @Test
    public void testAuthor() {
        assertEquals("Doe", this.Shame.getAuthor());
        assertEquals("bILL", this.AmericanGods.getAuthor());
    }
}
