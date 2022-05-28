import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class PetRockTest {
    private PetRock rock;


    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Before
    public void myTestSetup() throws Exception{
        rock = new PetRock("Rocky");
    }

    @Test
    public void getName() {
        assertEquals("Rocky", rock.getName());
    }
    @Test
    public void testUnHappyToStart() throws Exception{
        assertFalse(rock.isHappy());
    }
    @Test
    public void testHappyAfterPlay() throws Exception {
        rock.playWithRock();
        assertTrue(rock.isHappy());

    }

    @Ignore("Exception throwing not yet defined")

    @Test (expected = IllegalStateException.class)
    public void nameFail() throws Exception {
        rock.getHappyMessage();
    }
    @Test
    public void name() throws Exception {
        rock.playWithRock();
        String msg = rock.getHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    @Test
    public void testFavNum () throws Exception {
        assertEquals(42, rock.getFavNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyNameFail () throws Exception {
        new PetRock("");

    }
    @Test(timeout = 100)
    public void waitForHappyTimeout () throws Exception {
        rock.waitTilHappy();
    }
    @Test
    public void whenAssertingNull() {
        assertNull("The pet should be null", rock.getPet());
    }
    @Test
    public void NotSameObject() {
        PetRock cat = new PetRock("cat");
        assertNotSame(cat, rock);
    }
}