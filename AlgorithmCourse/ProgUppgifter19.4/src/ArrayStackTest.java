import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest
{

    ArrayStack<String> soup;
    ArrayStack<String> dopes;

    /**
     * Fixture initialization (common initialization for all tests).
     **/

    @Before
    public void setUp()
    {
        // new list for every test case
        soup= new ArrayStack();
        dopes = new ArrayStack();
    }

    @Test
    public void copyTest()
    {
        soup.push("A");
        soup.push("B");
        soup.push("C");
        soup.push("D");

        dopes = soup.copy();

        assertEquals("copyStack removes Krille", "D", dopes.pop());
        assertEquals("copyStack removes Rolle", "C", dopes.pop());
        assertEquals("copyStack removes Fredrik", "B", dopes.pop());
        assertEquals("copyStack removes André", "A", dopes.pop());
    }
     @Test
    public void copyTest()
    {
        soup.push("A");
        soup.push("B");
        soup.push("C");
        soup.push("D");

        dopes = soup.reverse();

        assertEquals("copyStack removes Krille", "A", dopes.pop());
        assertEquals("copyStack removes Rolle", "B", dopes.pop());
        assertEquals("copyStack removes Fredrik", "C", dopes.pop());
        assertEquals("copyStack removes André", "D", dopes.pop());
    }
}