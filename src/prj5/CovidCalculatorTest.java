package prj5;

import student.TestCase;
import java.util.ArrayList;

/**
 * Tests the methods in CovidCalculator
 * 
 * @author Ethan Homoroc (homorocethanj22)
 * @version 04.23.21
 */
public class CovidCalculatorTest extends TestCase {

    private CovidCalculator calculator;
    private LinkedList<State> states = new LinkedList<State>();
    private Race[] races = new Race[5];

    /**
     * Sets up the test methods
     */
    public void setUp() {
        races[0] = new Race("asian", 1, 2);
        races[1] = new Race("black", 3, 4);
        races[2] = new Race("white", 5, 6);
        races[3] = new Race("latinx", 7, 8);
        states.add(new State("VA", races));
        calculator = new CovidCalculator(states);
    }


    /**
     * Tests the constructor
     */
    public void testCovidCalculator() {
        assertNotNull(calculator);
    }


    /**
     * Tests getList()
     */
    public void testGetList() {
        assertEquals(states, calculator.getList());
    }


    /**
     * Tests sortByAlpha()
     */
    public void testSortByAlpha() {
        ArrayList<Race> alpha = calculator.sortByAlpha(states.getEntry(0));
        assertEquals(races[0], alpha.get(0));
    }


    /**
     * Tests sortByCFR
     */
    public void testSortByCFR() {
        ArrayList<Race> cfr = calculator.sortByCFR(states.getEntry(0));
        assertEquals(races[1], cfr.get(0));
    }
}
