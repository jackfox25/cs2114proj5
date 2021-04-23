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
     * Getter method to get the races of the state.
     * 
     * @return
     *         the races in an array.
     */
    public LinkedList<Race> getRaces() {
        return races;
    }

}
