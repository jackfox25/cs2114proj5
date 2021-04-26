package prj5;

import java.text.DecimalFormat;

/**
 * Race gets the data for the respective race
 * 
 * @author Ethan Homoroc (homorocethanj22)
 * @version 04.21.21
 *
 */

//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Ethan Homoroc (homorocethanj22)

public class Race {

    private String name;
    private int cases;
    private int deaths;

    /**
     * Constructor to initialize fields
     * 
     * @param n
     *            name of race
     * @param c
     *            number of cases
     * @param d
     *            number of deaths
     */
    public Race(String n, int c, int d) {
        name = n;
        cases = c;
        deaths = d;
    }


    /**
     * sets the number of cases
     * 
     * @param num
     *            number of cases
     */
    public void setCases(int num) {
        cases = num;
    }


    /**
     * sets the number of deaths
     * 
     * @param num
     *            number of deaths
     */
    public void setDeaths(int num) {
        deaths = num;
    }


    /**
     * gets the name of race
     * 
     * @return the name of race
     */
    public String getName() {
        return name;
    }


    /**
     * gets the number of cases
     * 
     * @return return the number of cases
     */
    public int getCases() {
        return cases;
    }


    /**
     * gets the number of deaths
     * 
     * @return the number of deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * gets the CFR
     * 
     * @return the CFR to the tenths decimal place
     */
    public double getCFR() {
        if (deaths == -1 || cases == -1) {
            return -1;
        }

        DecimalFormat df = new DecimalFormat("##.#");
        //df.setRoundingMode(RoundingMode.DOWN);
        double cfr = ((double)deaths / (double)cases) * 100;
        return Double.parseDouble(df.format(cfr));
    }


    /**
     * converts data to string format
     * 
     * @return string format of the data
     */
    @Override
    public String toString() {
        if (getCFR() % (int)getCFR() == 0) {
            return name + ": " + cases + " cases, " + (int)getCFR() + "% CFR";
        }

        return name + ": " + cases + " cases, " + getCFR() + "% CFR";
    }
}
