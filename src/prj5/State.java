package prj5;

/**
 * State class that contains the attributes of each state within the
 * visualization.
 *
 * @param <T>
 *            This is the type of object that this class will store
 * @author Giri Ganta (gantagiri4)
 * @version 2021.04.19
 */
public class State<T> {
    // fields
    private String name;
    private int totalCases;
    private int totalDeaths;
    private Race[] races;

    /**
     * Makes a new State Object.
     * 
     * @param name
     *            the name of the state.
     * @param totalCases
     *            the total COVID cases in the state.
     * @param totalDeaths
     *            the total deaths caused by COVID in the state.
     */
    public State(String stateName, Race[] race) {
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
     *         the races in a linked list.
     */
    public Races[] getRaces() {
        return races;
    }

}
