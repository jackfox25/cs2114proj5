package prj5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * CovidCalculator calculates CFR and Alphabetical for the lists of
 * states/races
 * 
 * @author Ethan Homoroc (homorocethanj22)
 * @version 04.19.21
 *
 */
public class CovidCalculator {

    private LinkedList<State> stateList;

    /**
     * Constructor
     * 
     * @param states
     *            LinkedList that gets passed
     */
    public CovidCalculator(LinkedList<State> states) {
        stateList = states;
    }


    /**
     * Gets the LinkedList for states
     * 
     * @return List with states
     */
    public LinkedList<State> getList() {
        return stateList;
    }


    /**
     * Sorts the data alphabetically
     * 
     * @param state
     *            state to sort
     * @return sorted list
     */
    public ArrayList<Race> sortByAlpha(State state) {
        Race[] races = state.getRaces();
        ArrayList<Race> list = new ArrayList<Race>(Arrays.asList(races));
        Collections.sort(list, new AlphaSort());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        return list;
    }


    /**
     * Sorts the data by CFR
     * 
     * @param state
     *            state to sort
     * @return sorted list
     */
    public ArrayList<Race> sortByCFR(State state) {
        Race[] races = state.getRaces();
        ArrayList<Race> list = new ArrayList<Race>(Arrays.asList(races));
        Collections.sort(list, new CFRsort());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        return list;
    }

    /**
     * Class with comparator for CFR
     * 
     * @author Ethan Homoroc (homorocethanj22)
     * @version 04.19.21
     *
     */
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
            return x.getName().compareTo(y.getName());
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
            int val = Double.compare(y.getCFR(), x.getCFR());
            if (val != 0) {
                return val;
            }
            return x.getName().compareTo(y.getName());
        }
    }
}
