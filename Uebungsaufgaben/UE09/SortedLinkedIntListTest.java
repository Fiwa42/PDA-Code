import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortedLinkedIntListTest {

    @Test
    public void testSortedLinkedIntList() {
        SortedLinkedIntList sortedList = new SortedLinkedIntList();

        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(8);
        sortedList.add(1);

        assertArrayEquals(new int[]{1, 3, 5, 8}, sortedList.toArray());

        sortedList.reset();
        assertTrue(sortedList.hasNext());
        assertEquals(1, sortedList.getNext());
        assertTrue(sortedList.hasNext());
        assertEquals(3, sortedList.getNext());
        assertTrue(sortedList.hasNext());
        assertEquals(5, sortedList.getNext());
        assertTrue(sortedList.hasNext());
        assertEquals(8, sortedList.getNext());
        assertFalse(sortedList.hasNext());

        sortedList.add(2);
        sortedList.add(7);

        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 8}, sortedList.toArray());
    }
}
