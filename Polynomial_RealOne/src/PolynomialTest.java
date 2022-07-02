import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PolynomialTest {
    Line Polynomial1, Polynomial2, Polynomial3;
    Quadratic Polynomial4, Polynomial5, Polynomial6;
    Constant Polynomial7, Polynomial8, Polynomial9;

    /**
     * just set up polynomials and initialization
     */
    @Before
    public void setup(){
        Polynomial1 = new Line(2, 4);
        Polynomial2 = new Line(-2,-4);
        Polynomial3 = new Line();

        Polynomial4 = new Quadratic(2, 4, 6);
        Polynomial5 = new Quadratic(-2,-4, -6);
        Polynomial6 = new Quadratic();

        Polynomial7 = new Constant(2);
        Polynomial8 = new Constant(-2);
        Polynomial9 = new Constant();
    }

    /**
     * test constructor throwing Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1(){
        Line invalidLine = new Line(2, 0);
    }

    /**
     * test constructor throwing Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2(){
        Quadratic invalidQuadratic = new Quadratic(2, 4, 0);
    }

    /**
     * test getDegree method
     */
    @Test
    public void testGetDegree(){
        assertEquals(1, Polynomial1.getDegree());
        assertEquals(1, Polynomial2.getDegree());
        assertEquals(1, Polynomial3.getDegree());
        assertEquals(2, Polynomial4.getDegree());
        assertEquals(2, Polynomial5.getDegree());
        assertEquals(2, Polynomial6.getDegree());
        assertEquals(0, Polynomial7.getDegree());
        assertEquals(0, Polynomial8.getDegree());
        assertEquals(0, Polynomial9.getDegree());
    }
    /**
     * test getCoefficient method
     */
    @Test
    public void testGetCoefficient(){
        assertEquals(2.0, Polynomial1.getCoefficient(0), 0.01);
        assertEquals(4.0, Polynomial1.getCoefficient(1), 0.01);
        assertEquals(-2.0, Polynomial2.getCoefficient(0), 0.01);
        assertEquals(-4.0, Polynomial2.getCoefficient(1), 0.01);
        assertEquals(0.0, Polynomial3.getCoefficient(0), 0.01);
        assertEquals(0.0, Polynomial3.getCoefficient(1), 0.01);

        assertEquals(2.0, Polynomial4.getCoefficient(0), 0.01);
        assertEquals(4.0, Polynomial4.getCoefficient(1), 0.01);
        assertEquals(6.0, Polynomial4.getCoefficient(2), 0.01);
        assertEquals(-2.0, Polynomial5.getCoefficient(0), 0.01);
        assertEquals(-4.0, Polynomial5.getCoefficient(1), 0.01);
        assertEquals(-6.0, Polynomial5.getCoefficient(2), 0.01);
        assertEquals(0.0, Polynomial6.getCoefficient(0), 0.01);
        assertEquals(0.0, Polynomial6.getCoefficient(1), 0.01);
        assertEquals(0.0, Polynomial6.getCoefficient(2), 0.01);

        assertEquals(2.0, Polynomial7.getCoefficient(0), 0.01);
        assertEquals(-2.0, Polynomial8.getCoefficient(0), 0.01);
        assertEquals(0.0, Polynomial9.getCoefficient(0), 0.01);
    }

    /**
     * test getLeadingCoefficient method
     */
    @Test
    public void testGetLeadingCoefficient(){
        assertEquals(2.0, Polynomial1.getLeadingCoefficient(), 0.01);
        assertEquals(-2.0, Polynomial2.getLeadingCoefficient(), 0.01);
        assertEquals(0, Polynomial3.getLeadingCoefficient(), 0.01);

        assertEquals(2.0, Polynomial4.getLeadingCoefficient(), 0.01);
        assertEquals(-2.0, Polynomial5.getLeadingCoefficient(), 0.01);
        assertEquals(6.0, Polynomial6.getLeadingCoefficient(), 0.01);

        assertEquals(2.0, Polynomial7.getLeadingCoefficient(), 0.01);
        assertEquals(-2.0, Polynomial8.getLeadingCoefficient(), 0.01);
        assertEquals(0.0, Polynomial9.getLeadingCoefficient(), 0.01);
    }

    /**
     * test isRoot method
     */
    @Test
    public void testisRoot(){
        assertTrue(Polynomial1.isRoot(-2));
        assertFalse(Polynomial2.isRoot(98));
        assertTrue(Polynomial3.isRoot(0));

        assertFalse(Polynomial4.isRoot(99));
        assertFalse(Polynomial5.isRoot(98));
        assertTrue(Polynomial6.isRoot(0));

        assertFalse(Polynomial7.isRoot(99));
        assertFalse(Polynomial8.isRoot(98));
        assertTrue(Polynomial9.isRoot(2));
    }

    /**
     * test toString method
     */
    @Test
    public void testToString(){
        assertEquals("P(x) = 2.0x + 4", Polynomial1.toString());
        assertEquals("P(x) = -2.0x - 4", Polynomial2.toString());
        assertEquals("P(x) = 0", Polynomial3.toString());

        assertEquals("P(x) = 2.0x^2 + 4.0x + 6", Polynomial4.toString());
        assertEquals("P(x) = -2.0x^2 - 4.0x - 6", Polynomial5.toString());
        assertEquals("P(x) = 0", Polynomial6.toString());

        assertEquals("P(x) = 2.0", Polynomial7.toString());
        assertEquals("P(x) = -2.0", Polynomial8.toString());
        assertEquals("P(x) = 0", Polynomial9.toString());
    }

    /**
     * test getSting method
     */
    @Test
    public void testGetString(){
        assertEquals("P(x) = 2.0x + 4", Polynomial1.toString());
        assertEquals("P(x) = -2.0x - 4", Polynomial2.toString());
        assertEquals("", Polynomial3.toString());

        assertEquals("P(x) = 2.0x^2 + 4.0x + 6", Polynomial4.toString());
        assertEquals("P(x) = -2.0x^2 - 4.0x - 6", Polynomial5.toString());
        assertEquals("", Polynomial6.toString());

        assertEquals("P(x) = 2.0", Polynomial7.toString());
        assertEquals("P(x) = -2.0", Polynomial8.toString());
        assertEquals("", Polynomial9.toString());
    }


    /**
     * test plus method
     */

    @Test
    public void testPlus(){
        assertEquals("P(x) = 0", Polynomial1.plus(Polynomial2).toString());
        assertEquals("P(x) = -2x - 4", Polynomial2.plus(Polynomial3).toString());
        assertEquals("P(x) = 2x + 4", Polynomial3.plus(Polynomial1).toString());

        assertEquals("P(x) = 0", Polynomial3.plus(Polynomial4).toString());
        assertEquals("P(x) = -2x^2 - 2x - 2", Polynomial4.plus(Polynomial1).toString());
        assertEquals("P(x) = 2x^2 + 4x + 6", Polynomial6.plus(Polynomial4).toString());

        assertEquals("P(x) = 2x^2 + 4x + 8", Polynomial7.plus(Polynomial4).toString());
        assertEquals("P(x) = -2x - 6", Polynomial8.plus(Polynomial2).toString());
        assertEquals("P(x) = 2x + 4", Polynomial9.plus(Polynomial1).toString());
    }

    /**
     * test translate method
     */
    @Test
    public void testTranslate(){
        assertEquals("P(x) = 8", Polynomial1.translate(1,2).toString());
        assertEquals("P(x) = -4", Polynomial2.translate(1,2).toString());
        assertEquals("P(x) = 2", Polynomial3.translate(1,2).toString());

        assertEquals("P(x) = 14", Polynomial4.translate(1,2).toString());
        assertEquals("P(x) = -10", Polynomial5.translate(1,2).toString());
        assertEquals("P(x) = 2", Polynomial6.translate(1,2).toString());

        assertEquals("P(x) = 4", Polynomial7.translate(1,2).toString());
        assertEquals("P(x) = -1", Polynomial8.translate(1,2).toString());
        assertEquals("P(x) = 2", Polynomial9.translate(1,2).toString());
    }

    /**
     * test multiply method
     */
    @Test
    public void testMultiply(){
        assertEquals("P(x) = 4.0x + 8", Polynomial1.multiply(Polynomial7).toString());
        assertEquals("P(x) = -4.0x - 8", Polynomial2.multiply(Polynomial7).toString());
        assertEquals("P(x) = 0", Polynomial3.multiply(Polynomial7).toString());

        assertEquals("P(x) = 4.0x^2 + 8x + 12", Polynomial4.multiply(Polynomial7).toString());
        assertEquals("P(x) = -4.0x^2 - 8x - 12", Polynomial5.multiply(Polynomial7).toString());
        assertEquals("P(x) = 0", Polynomial6.multiply(Polynomial7).toString());

        assertEquals("P(x) = 4", Polynomial7.multiply(Polynomial7).toString());
        assertEquals("P(x) = -4", Polynomial8.multiply(Polynomial7).toString());
        assertEquals("P(x) = 0", Polynomial9.multiply(Polynomial7).toString());

    }

    /**
     * Test for getCoefficient() method when it will throw Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetCoefficient1() {
        //Quadratic doesn't have item with power > 2
        Polynomial3.getCoefficient(3);
    }

    /**
     * Test1 for multiply() method when it will throw Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyException1() {
        //result will have degree >= 3
        Polynomial3.multiply(Polynomial5); //degree is x^3
    }


    /**
     * Tests whether the getYIntercept() method work correctly for all polynomials
     */
    @Test
    public void testGetYIntercept() {
        //2x + 4
        assertEquals(-2, Polynomial1.getYIntercept(), 0.01);
        //-2x-4
        assertEquals(2, Polynomial2.getYIntercept(), 0.01);
        assertEquals(0, Polynomial3.getYIntercept(), 0.01);

        //2x^2 + 4x + 6
        assertEquals(6, Polynomial4.getYIntercept(), 0.01);
        //-2x^2 -4x -6
        assertEquals(-6, Polynomial5.getYIntercept(), 0.01);
        assertEquals(0, Polynomial6.getYIntercept(), 0.01);

        //2
        assertEquals(2, Polynomial7.getYIntercept(), 0.01);
        //-2
        assertEquals(-2, Polynomial8.getYIntercept(), 0.01);
        assertEquals(0, Polynomial9.getYIntercept(), 0.01);
    }
}

