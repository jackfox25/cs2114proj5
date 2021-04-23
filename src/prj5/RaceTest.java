package prj5;

/**
 * Tests the methods in Race
 * 
 * @author Ethan Homoroc (homorocethanj22)
 * @version 04.23.21
 */
public class RaceTest extends student.TestCase {

    private Race race1;
    private Race race2;
    private Race race3;

    /**
     * setUp() method
     */
    public void setUp() {
        race1 = new Race("asian", 1, 2);
        race2 = new Race("white", -1, 10);
        race3 = new Race("black", 100, 1);
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
        assertEquals(1, race1.getNumberOfCases());
    }


    /**
     * tests getDeaths()
     */
    public void testGetDeaths() {
        assertEquals(2, race1.getDeaths());
    }


    /**
     * tests setNumberOfCases()
     */
    public void testSetNumberOfCases() {
        race1.setNumberOfCases(6);
        assertEquals(6, race1.getNumberOfCases());
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
        race1.setNumberOfCases(1);
        assertEquals(100, race1.getCFR(), .1);
        assertEquals(-1, race2.getCFR(), .1);
    }


    /**
     * tests toString()
     */
    public void testToString() {
        assertEquals("asian: 1 cases, 200% CFR", race1.toString());
        assertTrue(race2.toString().equals("white: -1 cases, -1% CFR"));
        assertTrue(race3.toString().equals("black: 100 cases, 1% CFR"));

    }
}
