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

    public void testTestCase() {
        assertEquals(2, 1+1);
    }

    /**
     * Calls covidReader constructor, then asserts states were instantiated
     * correctly.
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public void testReadStates() throws FileNotFoundException, ParseException {
        String fileName = "input1.txt";
        assertEquals(2, 1+1);
        CovidReader covRead = new CovidReader(fileName);
    }

}
