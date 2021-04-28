package prj5;

import java.io.*;

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
     * @throws IOException
     */
    public CovidReader(String file) throws IOException {

        stateList = readStates(file);

        // sortData(); (for intermediate submission)
    }


    /**
     * Parses data file.
     * 
     * @param file
     *            Input file.
     * @return LinkedList of State objects.
     * @throws ParseException
     * @throws IOException
     */
    private LinkedList<State> readStates(String fileName) throws IOException {
        File f = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        LinkedList<State> stateList = new LinkedList<State>();

        // skips description line in file
        br.readLine();

        String nextIn = "";

        while ((nextIn = br.readLine()) != null) {
            String[] parsedIn = nextIn.split(",");
            String stateName = parsedIn[0];

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

        br.close();
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

    
    /**
     * Sorts the state's Race data using the AlphaSort comparator.
     * @param state
     */
    public void sortAlpha(State state) {
        AlphaSort alpha = new AlphaSort();
        state.getRaces().insertionSort(alpha);
    }
    
    /**
     * Sorts the state's Race data using the CFRSort comparator.
     * @param state
     */
    public void sortCFR(State state) {
        CFRSort cfr = new CFRSort();
        state.getRaces().insertionSort(cfr);
    }

// FOR INTERMEDIATE SUBMISSION
//    /**
//     * Sorts data, calls print method.
//     */
//    public void sortData() {
//        for (int i = 0; i < stateList.getLength(); i++) {
//
//            State state = stateList.getEntry(i);
//            LinkedList<Race> races = state.getRaces();
//
//            System.out.println(state.getName());
//
//            AlphaSort alpha = new AlphaSort();
//            races.insertionSort(alpha);
//            // printData(state, races);
//
//            CFRSort cfr = new CFRSort();
//            races.insertionSort(cfr);
//            // printData(state, races);
//
//        }
//    }

// FOR INTERMEDIATE SUBMISSION
//    /**
//     * Prints data.
//     * 
//     * @param state
//     *            State to print name.
//     * @param races
//     *            Linked list of sorted races in the state.
//     */
//    private void printData(State state, LinkedList<Race> races) {
//        for (int j = 0; j < races.getLength(); j++) {
//            System.out.println(races.getEntry(j).toString());
//        }
//        System.out.println("=====");
//    }

}
