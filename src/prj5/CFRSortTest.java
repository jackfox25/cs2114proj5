/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Tests the CFRSort comparator class.
 * 
 * @author Jack Fox (jackf19)
 * @version 2021.04.26
 *
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Fox (jackf19)

public class CFRSortTest extends TestCase {

    /**
     * Creates test scenario.
     */
    public void setUp() {
        // intentionally left blank
    }


    /**
     * Tests compare method.
     */
    public void testCompare() {
        Race r1 = new Race("white", 2, 1);
        Race r2 = new Race("asian", 3, 1);
        Race r3 = new Race("latinx", 4, 1);

        CFRSort cfr = new CFRSort();

        assertTrue(cfr.compare(r2, r1) > 0);
        assertEquals(cfr.compare(r2, r2), 0);
        assertTrue(cfr.compare(r2, r3) < 0);
    }

}
