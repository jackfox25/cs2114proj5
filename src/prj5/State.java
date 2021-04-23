package prj5;

/**
 * State class that contains the attributes of each state within the
 * visualization.
 *
 * @author Giri Ganta (gantagiri4)
 * @version 2021.04.19
 */
public class State {
    // fields
    private String name;
    private int totalCases;
    private int totalDeaths;
    private LinkedList<Race> races;

    /**
     * Makes a new State Object.
     * 
     * @param name
     *            the name of the state.
     * @param race
     *            races in an array
     */
    public State(String stateName, LinkedList<Race> race) {
        name = stateName;
        races = race;
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

}
