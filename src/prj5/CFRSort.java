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
    public int compare(Race y, Race x) {
        return (int)((x.getCFR() - y.getCFR()) * 100);
    }
    
}
