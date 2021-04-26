/**
 * 
 */
package prj5;

import java.io.IOException;
import student.TestCase;

/**
 * Makes sure data is read correctly from input file in CovidReader.
 * 
 * @author Jack Fox (jackf19)
 * @version 2021.04.23
 *
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Fox (jackf19)

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
     * 
     * @throws ParseException
     * @throws IOException
     */
    public void testReadStates() throws IOException {
        String fileName = "Cases_and_Deaths_by_race_CRDT_Sep2020.csv";
        CovidReader covRead = new CovidReader(fileName);
        LinkedList<State> stateList = covRead.getStateList();

        State state1 = stateList.getEntry(0);
        assertEquals("DC", state1.getName());
        LinkedList<Race> raceList1 = state1.getRaces();
        Race race1s1 = raceList1.getEntry(0);
        assertEquals(179563, race1s1.getCases());
        assertEquals(13365, race1s1.getDeaths());
        assertEquals("black", race1s1.getName());

        State state4 = stateList.getEntry(3);
        LinkedList<Race> raceList4 = state4.getRaces();
        Race race3s4 = raceList4.getEntry(2);
        assertEquals(41305, race3s4.getCases());
        assertEquals(727, race3s4.getDeaths());
        assertEquals("asian", race3s4.getName());

        assertEquals(6, stateList.getLength());
        assertEquals(5, state1.getRaces().getLength());

    }

}
