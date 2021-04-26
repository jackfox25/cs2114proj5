package prj5;

/**
 * State class that contains the attributes of each state within the
 * visualization.
 *
 * @author Giri Ganta (gantagiri4)
 * @version 2021.04.19
 */

//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Giri Ganta (gantagiri4)

public class State {
    // fields
    private String name;
    private int totalCases;
    private int totalDeaths;
    private LinkedList<Race> races;

    /**
     * Makes a new State Object.
     * 
     * @param stateName
     *            the name of the state.
     * @param race
     *            races in an array
     */
    public State(String stateName, LinkedList<Race> race) {
        name = stateName;
        races = race;
        setTotalCases();
        setTotalDeaths();
    }


    /**
     * Getter method to get the name of the state.
     * 
     * @return
     *         the name of the state.
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method to get the number of total cases for the state.
     * 
     * @return
     *         the number of total cases.
     */
    public int getTotalCases() {
        return totalCases;
    }


    /**
     * Getter method to get the number of total deaths for the state.
     * 
     * @return
     *         the number of total deaths.
     */
    public int getTotalDeaths() {
        return totalDeaths;
    }


    /**
     * Getter method to get the races of the state.
     * 
     * @return
     *         the races in an array.
     */
    public LinkedList<Race> getRaces() {
        return races;
    }


    /**
     * Sets totalCases field.
     */
    public void setTotalCases() {
        totalCases = 0;
        for (int i = 0; i < 5; i++) {
            Race race = getRaces().getEntry(i);
            int raceCases = race.getCases();
            int addToField = raceCases == -1 ? 0 : raceCases;
            totalCases += addToField;
        }
    }


    /**
     * Sets totalDeaths field.
     */
    public void setTotalDeaths() {
        totalDeaths = 0;
        for (int i = 0; i < 5; i++) {
            Race race = getRaces().getEntry(i);
            int raceDeaths = race.getDeaths();
            int addToField = raceDeaths == -1 ? 0 : raceDeaths;
            totalDeaths += addToField;
        }
    }

}
