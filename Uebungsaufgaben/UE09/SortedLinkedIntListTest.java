import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortedLinkedIntListTest {

    @Test
    public void testSortedLinkedIntList() {
        SortedLinkedIntList sortedList = new SortedLinkedIntList();

        // Test add method
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(8);
        sortedList.add(1);

        // Test toArray method
        assertArrayEquals(new int[]{1, 3, 5, 8}, sortedList.toArray());

        // Test reset, hasNext, and getNext methods
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

        // Test add method after iteration
        sortedList.add(2);
        sortedList.add(7);

        // Test toArray method after additional adds
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 8}, sortedList.toArray());
    }
}
