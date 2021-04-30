package prj5;

import java.util.Arrays;

/**
 * This class tests the methods implemented within Linked List.
 * This is the type of object that this class will store
 * 
 * @author Giri Ganta (gantagiri4)
 * @version 2021.04.23
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Giri Ganta (gantagiri4)

public class LinkedListTest extends student.TestCase {
    // fields
    private LinkedList<String> emptyListA;
    private LinkedList<String> emptyListB;
    private LinkedList<String> smallListA;
    private LinkedList<String> smallListB;
    private LinkedList<String> bigListA;
    private LinkedList<String> bigListB;
    private String nullObject;

    /**
     * Sets up the initial conditions for each test case.
     */
    public void setUp() {
        emptyListA = new LinkedList<String>();
        emptyListB = new LinkedList<String>();

        smallListA = new LinkedList<String>();
        smallListB = new LinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new LinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        nullObject = null;
    }


    /**
     * Tests the add() method
     */
    public void testAdd() {
        LinkedList<String> pets = new LinkedList<String>();

        pets.add("dog");
        assertEquals(1, pets.getLength());
        pets.add("cat");
        assertEquals(2, pets.getLength());
        pets.add("bunny");
        pets.add("snake");
        assertEquals(pets.getEntry(0), "dog");
        assertEquals(pets.getEntry(1), "cat");
        assertEquals(pets.getEntry(2), "bunny");
        assertEquals(pets.getEntry(3), "snake");

        Exception exception = null;

        try {
            pets.add(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests the add() method with two parameters
     * 
     */
    public void testAddPosition() {
        LinkedList<String> pets = new LinkedList<String>();

        pets.add(0, "hamster");
        assertEquals(pets.getEntry(0), "hamster");

        Exception exception = null;
        try {
            pets.add(2, "ferret");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        try {
            pets.add(-1, "ferret");
        } 
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        smallListB.add(3, "basketball");
        assertEquals(4, smallListB.getLength());
        assertEquals(smallListB.getEntry(3), "basketball");

        smallListB.add(2, "tennis");
        assertEquals(5, smallListB.getLength());
        assertEquals(smallListB.getEntry(0), "soccer");
        assertEquals(smallListB.getEntry(1), "swimming");
        assertEquals(smallListB.getEntry(2), "tennis");
        assertEquals(smallListB.getEntry(3), "gymnastics");
        assertEquals(smallListB.getEntry(4), "basketball");

        Exception exception2 = null;
        try {
            smallListB.add(5, null);
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);

        Exception exception3 = null;
        try {
            smallListB.add(7, "hockey");
        }
        catch (Exception e) {
            exception3 = e;
        }
        assertNotNull(exception3);

        emptyListA.add(0, "bob");
        assertEquals("bob", emptyListA.getEntry(0));
        emptyListA.add(0, "karl");
    }


    /**
     * tests the clear() method
     */
    public void testClear() {
        assertEquals(3, smallListA.getLength());
        smallListA.clear();
        assertEquals(0, smallListA.getLength());
        emptyListA.clear();
        assertEquals(0, emptyListA.getLength());
    }


    /**
     * tests the contains() method
     */
    public void testContains() {
        assertTrue(smallListA.contains("soccer"));
        assertFalse(smallListA.contains("tennis"));
    }


    /**
     * tests the get() method
     */
    public void testGet() {
        LinkedList<String> pets = new LinkedList<String>();

        pets.add(0, "hamster");
        pets.add("dog");
        pets.add("cat");
        pets.add("snake");

        assertEquals("hamster", pets.getEntry(0));
        assertEquals("cat", pets.getEntry(2));

        Exception exception = null;
        try {
            emptyListA.getEntry(-1);
            fail("get() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        try {
            emptyListA.getEntry(5);
            fail("get() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

    }


    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        LinkedList<String> pets = new LinkedList<String>();

        pets.add(0, "hamster");
        pets.add("dog");
        pets.add("cat");
        pets.add("snake");

        assertFalse(pets.isEmpty());

        pets.clear();

        assertTrue(pets.isEmpty());
    }


    /**
     * tests the remove() index method
     */
    public void testRemove() {
        assertEquals("soccer", smallListB.remove(0));
        assertEquals(2, smallListB.getLength());
        assertEquals("{swimming, gymnastics}", smallListB.toString());

        assertEquals("swimming", smallListA.remove(1));
        assertEquals(2, smallListA.getLength());
        assertEquals("{soccer, gymnastics}", smallListA.toString());

        assertEquals("gymnastics", smallListB.remove(1));
        assertEquals(1, smallListB.getLength());
        assertEquals("{swimming}", smallListB.toString());

        Exception exception = null;
        try {
            emptyListA.remove(3);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

        Exception exception2 = null;
        try {
            emptyListB.remove(-1);
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);

    }


    /**
     * Tests the replace() method
     */
    public void testReplace() {
        LinkedList<String> pets = new LinkedList<String>();

        pets.add(0, "hamster");
        pets.add("dog");
        pets.add("cat");
        pets.add("snake");

        assertEquals("cat", pets.getEntry(2));

        pets.replace(2, "rat");

        assertEquals("rat", pets.getEntry(2));

        Exception exception = null;
        try {
            pets.replace(4, "parrot");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

        Exception exception2 = null;
        try {
            emptyListB.replace(-1, "bird");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        
        smallListB.replace(0, "replacement");
        assertEquals(smallListB.getEntry(0), "replacement");
    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        smallListA.remove(3);
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * tests the toString() method
     */
    public void testToString() {
        LinkedList<String> pets = new LinkedList<String>();

        pets.add("hamster");
        pets.add("dog");
        pets.add("cat");
        pets.add("snake");
        pets.add("snake");

        assertEquals("{hamster, dog, cat, snake, snake}", pets.toString());

        pets.remove(3);

        assertEquals("{hamster, dog, cat, snake}", pets.toString());

        pets.add(2, "dolphin");

        assertEquals("{hamster, dog, dolphin, cat, snake}", pets.toString());

        assertEquals("{}", emptyListA.toString());
    }


    /**
     * tests the lastIndexOf() method
     */
    public void testLastIndexOf() {
        LinkedList<String> pets = new LinkedList<String>();

        pets.add("hamster");
        pets.add("dog");
        pets.add("cat");
        pets.add("snake");
        pets.add("snake");

        assertEquals(2, pets.lastIndexOf("cat"));
        assertEquals(4, pets.lastIndexOf("snake"));
        assertEquals(-1, pets.lastIndexOf("tiger"));

    }
    
    /**
     * tests insertionSort() method
     */
    public void testInsertionSort() {
        Race race1 = new Race("B_race1", 1, 2);
        Race race2 = new Race("A_race2", 3, 4);
        LinkedList<Race> races1 = new LinkedList<Race>();
        races1.add(race1);
        races1.add(race2);
        
        LinkedList<Race> races2 = new LinkedList<Race>();
        races2.add(race1);
        
        LinkedList<Race> races3 = new LinkedList<Race>();
        LinkedList<Race> races4 = new LinkedList<Race>();
        
        AlphaSort alpha = new AlphaSort();
        races1.insertionSort(alpha);
        
        assertEquals(race2, races1.getEntry(0));
        assertEquals(2, races1.getLength());
        
        races2.insertionSort(alpha);
        assertEquals(1, races2.getLength());
        
        races3.insertionSort(alpha);
        races4.add(race2);
        races4.add(race1);
        races4.insertionSort(alpha);
    }

}
