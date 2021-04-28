/**
 * 
 */
package prj5;

import java.io.IOException;
import bsh.ParseException;

/**
 * Sends input file to CovidReader, launches program.
 * 
 * @author Jack Fox (jackf19)
 * @version 2021.04.21
 *
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Fox (jackf19)

public class Input {

    /**
     * Default constructor
     */
    public Input() {
        // intentionally left blank
    }


    /**
     * Main method, instantiates a CovidReader
     * 
     * @param args
     *            Input file.
     * @throws ParseException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            String file = args[0];
            try {
                CovidReader covRead = new CovidReader(file);
                GUICovidWindow window = new GUICovidWindow(covRead);
            }
            catch (Exception e) {
                System.out.println("Input file is unreadable.");
            }
        }
        else {
            CovidReader covRead = new CovidReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            GUICovidWindow window = new GUICovidWindow(covRead);
        }

    }

}
