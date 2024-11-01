/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Tests the AlphaSort comparator class.
 * 
 * @author Jack Fox (jackf19)
 * @version 2021.04.26
 *
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Fox (jackf19)

public class AlphaSortTest extends TestCase {

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
        Race r1 = new Race("white", 1, 1);
        Race r2 = new Race("asian", 1, 1);
        Race r3 = new Race("latinx", 1, 1);

        AlphaSort alpha = new AlphaSort();

        assertTrue(alpha.compare(r3, r2) > 0);
        assertEquals(alpha.compare(r3, r3), 0);
        assertTrue(alpha.compare(r3, r1) < 0);
    }

}
