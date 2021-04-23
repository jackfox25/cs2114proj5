package covidvisualizer;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import bsh.ParseException;

/**
 * Parses data from input file.
 * 
 * @author Jack Fox (jackf19)
 * @version 2021.04.21
 *
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Fox (jackf19)

public class CovidReader {

    private LinkedList<State> stateList;

    /**
     * Calls read functions, sets up front end visual display.
     * 
     * @param file
     *            Input file
     */
    public CovidReader(String file)
        throws FileNotFoundException,
        ParseException {

        stateList = readStates(file);
    }


    /**
     * Parses data file.
     * 
     * @param file
     *            Input file.
     * @return LinkedList of State objects.
     * @throws FileNotFoundException
     * @throws ParseException
     */
    private LinkedList<State> readStates(String fileName)
        throws FileNotFoundException,
        ParseException {
        File f = new File(fileName);
        Scanner file = new Scanner(f);

        LinkedList<State> stateList = new LinkedList<State>();

        // skips description line in file
        file.nextLine();

        while (file.hasNextLine()) {
            String nextIn = file.nextLine();
            String[] parsedIn = nextIn.split(", *");
            if (parsedIn.length != 11) {
                file.close();
                throw new ParseException("incorrect data format");
            }

            String stateName = parsedIn[0];
            System.out.println(stateName);

            String[] rNames = { "white", "black", "latinx", "asian", "other" };
            LinkedList<Race> raceData = new LinkedList<Race>();

            for (int i = 0; i < 5; i++) {
                // grab race name
                String rName = rNames[i];

                // parse cases
                String cStr = parsedIn[i + 1];
                int cNum = cStr.equals("NA") ? -1 : Integer.valueOf(cStr);

                // parse deaths
                String dStr = parsedIn[i + 6];
                int dNum = dStr.equals("NA") ? -1 : Integer.valueOf(dStr);

                Race race_i = new Race(rName, cNum, dNum);
                raceData.add(race_i);
                ;
            }

            State newState = new State(stateName, raceData);
            stateList.add(newState);

        }

        for (int i = 0; i < stateList.getLength(); i++) { // Here is the
                                                          // comparator sorts
            State currState = stateList.getEntry(i);
            System.out.println(currState.getName());

            AlphaSort alpha = new AlphaSort();
            currState.getRaces().insertionSort(alpha);
            System.out.println(currState);

            CFRsort cfr = new CFRsort();
            currState.getRaces().insertionSort(cfr);
            System.out.println(currState);

        }

        file.close();
        return stateList;
    }


    /**
     * Getter method used for testing.
     * 
     * @return stateList.
     */
    public LinkedList<State> getStateList() {
        return stateList;
    }

    private class CFRsort implements Comparator<Race> {

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
            return (int)((x.getCFR() - y.getCFR()) * 100);
        }
    }


    /**
     * Class with comparator for Alphabetical
     * 
     * @author Ethan Homoroc (homorocethanj22)
     * @version 04.19.21
     *
     */
    private class AlphaSort implements Comparator<Race> {

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
            return x.getName().compareTo(y.getName());
        }
    }

}
