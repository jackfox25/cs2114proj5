/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Jack Fox (jackf19)
 * @version 2021.04.23
 *
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Fox (jackf19)

public class CFRSort implements Comparator<Race> {

    /**
     * Compares two races
     * 
     * @param x
     *            first race
     * @param y
     *            second race
     * @return compareTo value
     */
    public int compare(Race x, Race y) {
        int result = (int)((y.getCFR() - x.getCFR()) * 100);
        if (result == 0) {
            AlphaSort alpha = new AlphaSort();
            return alpha.compare(x, y);
        }
        return result;
    }

}
