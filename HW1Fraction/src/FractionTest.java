import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FractionTest {
    Fraction fraction1, fraction2, fraction3;

    @Before
    public void setup(){
        fraction1 = new Fraction(-2, 9);
        fraction2 = new Fraction(2,4);
        fraction3 = new Fraction(0, 3);
    }

    @Test
    public void testgetNumerator(){
        assertEquals(-2, fraction1.getNumerator());
        assertEquals(2, fraction2.getNumerator());
        assertEquals(0, fraction3.getNumerator());
    }
    @Test
    public void testgetDenominator(){
        assertEquals(9, fraction1.getDenominator());
        assertEquals(4, fraction2.getDenominator());
        assertEquals(3, fraction3.getDenominator());
    }

    @Test
    public void testsetNumerator(){
        fraction1.setNumerator(2);
        assertEquals(2, fraction1.getNumerator());
        fraction2.setNumerator(-3);
        assertEquals(-3, fraction2.getNumerator());
        fraction3.setNumerator(8);
        assertEquals(8, fraction3.getNumerator());
    }

    @Test
    public void testSetDenominator(){
        fraction1.setDenominator(11);
        assertEquals(11, fraction1.getDenominator());
        fraction2.setDenominator(12);
        assertEquals(12, fraction2.getDenominator());
        fraction3.setDenominator(13);
        assertEquals(13, fraction3.getDenominator());
    }

    @Test
    public void testToDouble(){
        assertEquals(-0.222, fraction1.toDouble(), 0.001);
        assertEquals(0.5, fraction2.toDouble(), 0.001);
        assertEquals(0.0, fraction3.toDouble(), 0.001);
    }

    @Test
    public void testToString(){
        assertEquals("-2 / 9", fraction1.toString());
        assertEquals("2 / 4", fraction2.toString());
        assertEquals("0 / 3", fraction3.toString());
    }

    @Test
    public void testCompareTo(){
        Fraction newfraction1 = new Fraction(1, 2);
        assertEquals(0, fraction2.compareTo(fraction2));
        assertEquals(-1, fraction1.compareTo(fraction1));
        assertEquals(1, fraction3.compareTo(fraction3));
    }

    @Test
    public void testReciprocal(){
        assertEquals("2 / 1", fraction2.reciprocal().toString());
        assertEquals("-9 / 2", fraction1.reciprocal().toString());
    }

    @Test
    public void testAdd(){
        assertEquals("-19 / 30", fraction2.add(fraction1).toString());
        assertEquals("1 / 6", fraction2.add(fraction3).toString());
        Fraction newfraction1 = new Fraction(-2, 4);
        assertEquals("-1 / 1", fraction1.add(newfraction1).toString());
    }
}

