/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Tests State class.
 * 
 * @author Jack Fox (jackf19)
 * @version 2021.04.23
 *
 */

//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Jack Fox (jackf19)

public class StateTest extends TestCase {

    private State s1;
    private LinkedList<Race> llr;
    
    /**
     * Creates scenario for test methods.
     */
    public void setUp() {
        Race r1 = new Race("r1", 40, 20);
        Race r2 = new Race("r2", 10, -1);
        Race r3 = new Race("r3", 23, 2);
        Race r4 = new Race("r4", 11, 1);
        Race r5 = new Race("r5", -1, -1);
        
        llr = new LinkedList<Race>();
        llr.add(r1);
        llr.add(r2);
        llr.add(r3);
        llr.add(r4);
        llr.add(r5);
        
        s1 = new State("s1", llr);
    }
    
    
    /**
     * Tests getName method.
     */
    public void testGetName() {
        assertEquals("s1", s1.getName());
    }
    
    
    /**
     * Tests getTotalCases method.
     */
    public void testGetTotalCases() {
        assertEquals(84, s1.getTotalCases());
    }
    
    
    /**
     * Tests getTotalDeaths method.
     */
    public void testGetTotalDeaths() {
        assertEquals(23, s1.getTotalDeaths());
    }
    
    
    /**
     * Tests getRaces method.
     */
    public void testGetRaces() {
        assertEquals(llr, s1.getRaces());
    }
    
    
    /**
     * Tests setTotalCases method.
     */
    public void testSetTotalCases() {
        s1.setTotalCases();
        assertEquals(84, s1.getTotalCases());
    }
    
    
    /**
     * Tests setTotalDeaths method.
     */
    public void testSetTotalDeaths() {
        s1.setTotalDeaths();
        assertEquals(23, s1.getTotalDeaths());
    }
    
}
