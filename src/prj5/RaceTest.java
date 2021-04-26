package prj5;

import student.TestCase;

/**
 * Tests the methods in Race
 * 
 * @author Ethan Homoroc (homorocethanj22)
 * @version 04.23.21
 */

//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Ethan Homoroc (homorocethanj22)

public class RaceTest extends TestCase {

    private Race race1;
    private Race race2;
    private Race race3;

    /**
     * setUp() method
     */
    public void setUp() {
        race1 = new Race("asian", 3, 1);
        race2 = new Race("white", -1, 10);
        race3 = new Race("black", 145, 16);
    }


    /**
     * tests getName()
     */
    public void testGetName() {
        assertEquals("asian", race1.getName());
    }


    /**
     * tests getNumberOfCases()
     */
    public void testGetCaseNum() {
        assertEquals(3, race1.getCases());
    }


    /**
     * tests getDeaths()
     */
    public void testGetDeaths() {
        assertEquals(1, race1.getDeaths());
    }


    /**
     * tests setNumberOfCases()
     */
    public void testSetNumberOfCases() {
        race1.setCases(6);
        assertEquals(6, race1.getCases());
    }


    /**
     * tests setDeaths()
     */
    public void testSetDeaths() {
        race1.setDeaths(6);
        assertEquals(6, race1.getDeaths());
    }


    /**
     * tests getCFR()
     */
    public void testGetCFR() {
        race1.setDeaths(1);
        race1.setCases(1);
        assertEquals(100.0, race1.getCFR(), .1);
        assertEquals(-1.0, race2.getCFR(), .1);
    }


    /**
     * tests toString()
     */
    public void testToString() {
        assertEquals("asian: 3 cases, 33.3% CFR", race1.toString());
        assertEquals("white: -1 cases, -1% CFR", race2.toString());
        assertEquals("black: 145 cases, 11% CFR", race3.toString());

    }
}
