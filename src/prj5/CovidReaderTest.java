/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;
import student.TestCase;

/**
 * Makes sure data is read correctly from input file in CovidReader.
 * 
 * @author Jack Fox (jackf19)
 * @version 2021.04.23
 *
 */

//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Jack Fox (jackf19)

public class CovidReaderTest extends TestCase {

    /**
     * Creates test scenario for test case.
     */
    public void setUp() {
        // intentionally blank
    }


    /**
     * Calls CovidReader constructor, then asserts states were instantiated
     * correctly.
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public void testReadStates() throws FileNotFoundException, ParseException {
        String fileName = "input1.txt";
        assertEquals(2, 1+1);
        CovidReader covRead = new CovidReader(fileName);
        LinkedList<State> stateList = covRead.getStateList();
        
        State state1 = stateList.getEntry(0);
        assertEquals("DC", state1.getName());
        LinkedList<Race> raceList1 = state1.getRaces();
        Race race1s1 = raceList1.getEntry(0);
        assertEquals(70678, race1s1.getCases());
        assertEquals(1924, race1s1.getDeaths());
        assertEquals("white", race1s1.getName());
        
        State state4 = stateList.getEntry(3);
        LinkedList<Race> raceList4 = state4.getRaces();
        Race race3s4 = raceList4.getEntry(2);
        assertEquals(787616, race3s4.getCases());
        assertEquals(-1, race3s4.getDeaths());
        assertEquals("latinx", race3s4.getName());
        
        assertEquals(6, stateList.getLength());
        assertEquals(5, state1.getRaces().getLength());
        
    }

}
