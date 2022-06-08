import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ListOfIntsTest {
    IListOfInts emptyList, intsList1, intsList2, intsList3;

    @Before
    public void setup(){

        emptyList = new EmptyNode();
        intsList1 = new ElementNode(1, new ElementNode(2, new EmptyNode()));
        intsList2 = new ElementNode(4, new ElementNode(5, new ElementNode(6, new EmptyNode())));
        intsList3 = new ElementNode(10, new ElementNode(11, new ElementNode(12, new EmptyNode())));
    }

    @Test
    public void countTest(){
        assertEquals(0, emptyList.count());
        assertEquals(2, intsList1.count());
        assertEquals(3, intsList2.count());
        assertEquals(3, intsList3.count());
    }

    @Test
    public void toStringTest(){
        assertEquals("1  2 ", intsList1.toString());
        assertEquals("4  5  6 ", intsList2.toString());
        assertEquals("10  11  12 ", intsList3.toString());
    }

    @Test
    public void addAtIndexTest(){
        intsList1.addAtIndex(3,1);
        assertEquals(3, intsList1.count());
        assertEquals("1  3  2 ", intsList1.toString());
        intsList2.addAtIndex(1, 2);
        assertEquals(1, intsList2.count());
        assertEquals("4  5  1  6 ", intsList2.toString());
    }



    @Test
    public void addBackTest(){
        intsList3.addBack(13);
        assertEquals(4, intsList3.count());
        assertEquals("10  11  12  13 ", intsList3.toString());
        intsList1.addBack(3);
        assertEquals(3, intsList1.count());
        assertEquals("1  2   3", intsList1.toString());
    }

    @Test
    public void addFrontTest(){
        assertEquals("4 ", emptyList.addFront(4).toString());
        assertEquals("8  4  5  6 ", intsList2.addFront(8).toString());
        assertEquals("9  10  11  12 ", intsList3.addFront(9).toString());
    }

    @Test
    public void getDataAtIndex(){
        assertEquals(0, intsList1.getDataAtIndex(1));
        assertEquals(1, intsList1.getDataAtIndex(0));
        assertEquals(10, intsList3.getDataAtIndex(0));
    }

    @Test
    public void sumTest(){
        assertEquals(0, emptyList.sum());
        assertEquals(3, intsList1.sum());
        assertEquals(15, intsList2.sum());
        assertEquals(33, intsList3.sum());
    }

}

