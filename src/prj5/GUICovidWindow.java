package prj5;

import cs2.Window;
import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.WindowSide;

// Include these if you want to full screen the window.
// import java.awt.Dimension;
// import java.awt.Toolkit;

/**
 * Display window: manipulates and updates graphics.
 * 
 * @author Ethan Homoroc (homorocethanj22)
 * @version 4.23.2021
 */

// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ethan Homoroc (homorocethanj22)

public class GUICovidWindow {

    private CovidReader covReader;
    private Window window;

    private Button quit;
    private Button sortByCFR;
    private Button sortByAlpha;
    private Button dc;
    private Button ga;
    private Button md;
    private Button mc;
    private Button tn;
    private Button va;

    private Shape[] bars;
    private TextShape title;
    private TextShape[] barRaceLabels;
    private TextShape[] barCFRLabels;

    private static final int BAR_Y = 50;
    private static final int BAR_WIDTH = 20;

    private static final String TITLE_STR = " Case Fatality Ratios by Race";
    private State currentDisplay;

    /**
     * CovidWindow Constructor
     */
    public GUICovidWindow(CovidReader covRead) {

        this.covReader = covRead;
        this.window = new Window("homorocethanj22 gantagiri4 jackf19");

        // BUTTON SETUP
        sortByAlpha = new Button("Sort by Alpha");
        window.addButton(sortByAlpha, WindowSide.NORTH);
        sortByAlpha.onClick(this, "clickedSortByAlpha");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        sortByCFR = new Button("Sort By CFR");
        window.addButton(sortByCFR, WindowSide.NORTH);
        sortByCFR.onClick(this, "clickedSortByCFR");

        dc = new Button("Represent DC");
        window.addButton(dc, WindowSide.SOUTH);
        dc.onClick(this, "clickedDC");

        ga = new Button("Represent GA");
        window.addButton(ga, WindowSide.SOUTH);
        ga.onClick(this, "clickedGA");

        md = new Button("Represent MD");
        window.addButton(md, WindowSide.SOUTH);
        md.onClick(this, "clickedMD");

        mc = new Button("Represent NC");
        window.addButton(mc, WindowSide.SOUTH);
        mc.onClick(this, "clickedNC");

        tn = new Button("Represent TN");
        window.addButton(tn, WindowSide.SOUTH);
        tn.onClick(this, "clickedTN");

        va = new Button("Represent VA");
        window.addButton(va, WindowSide.SOUTH);
        va.onClick(this, "clickedVA");

        // SHAPE SETUP

        bars = new Shape[5];
        barRaceLabels = new TextShape[5];
        barCFRLabels = new TextShape[5];

        currentDisplay = null;

        // To put the window in full screen.
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // double width = screenSize.getWidth();
        // double height = screenSize.getHeight();
        // window.setSize((int)width, (int)height);

    }


    /**
     * Called when "Represent DC" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedDC(Button b) {
        currentDisplay = covReader.getStateList().getEntry(0);
        draw();
    }


    /**
     * Called when "Represent GA" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedGA(Button b) {
        currentDisplay = covReader.getStateList().getEntry(1);
        draw();
    }


    /**
     * Called when "Represent MD" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedMD(Button b) {
        currentDisplay = covReader.getStateList().getEntry(2);
        draw();
    }


    /**
     * Called when "Represent NC" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedNC(Button b) {
        currentDisplay = covReader.getStateList().getEntry(3);
        draw();
    }


    /**
     * Called when "Represent TN" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedTN(Button b) {
        currentDisplay = covReader.getStateList().getEntry(4);
        draw();
    }


    /**
     * Called when "Represent VA" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedVA(Button b) {
        currentDisplay = covReader.getStateList().getEntry(5);
        draw();
    }


    /**
     * Called when "Sort By Alpha" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedSortByAlpha(Button b) {
        if (currentDisplay != null) {
            covReader.sortAlpha(currentDisplay);
            draw();
        }
    }


    /**
     * Called when "Sort by CFR" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedSortByCFR(Button b) {
        if (currentDisplay != null) {
            covReader.sortCFR(currentDisplay);
            draw();
        }
    }


    /**
     * Called when "Quit" is clicked.
     * 
     * @param b
     *            button
     */
    public void clickedQuit(Button b) {
        System.exit(0);
    }


    /**
     * Draws bars and labels on the screen according to Race data.
     * 
     * @param raceList
     *            Race data.
     */
    private void draw() {
        // clears existing bars
        clearDisplay();

        LinkedList<Race> raceList = currentDisplay.getRaces();
        double maxCFR = findMaxCFR(raceList);

        // creates title
        title = new TextShape(0, 0, currentDisplay.getName() + TITLE_STR);
        title.moveTo((window.getWidth() - title.getWidth()) / 2, 25);
        window.addShape(title);

        int tWindowWidth = window.getWidth() - 100;

        int spaceWidth = (tWindowWidth / 6) - 1;

        int[] startPoints = new int[5];
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                startPoints[i] = spaceWidth;
            }
            else {
                startPoints[i] = startPoints[i - 1] + spaceWidth + BAR_WIDTH;
            }
        }

        for (int i = 0; i < raceList.getLength(); i++) {

            Race race = raceList.getEntry(i);

            // calculates height for each bar
            double htFactor = race.getCFR() / maxCFR;
            int totalBarHeight = window.getHeight() - 230;
            int height = (int)(totalBarHeight * htFactor);

            // creates bars
            if (race.getCFR() != -1) {
                bars[i] = new Shape(startPoints[i], BAR_Y + totalBarHeight
                    - height, BAR_WIDTH, height, Color.BLUE);
                window.addShape(bars[i]);
            }
            else { // when CFR == 1:
                TextShape na = new TextShape(0, 0, "NA");
                na.moveTo(startPoints[i], BAR_Y + totalBarHeight - na
                    .getHeight());
                bars[i] = na;
                window.addShape(na);
            }

            // creates race labels
            TextShape raceLabel = new TextShape(0, 0, race.getName());
            raceLabel.moveTo(startPoints[i] + (BAR_WIDTH / 2) - raceLabel
                .getWidth() / 2, BAR_Y + totalBarHeight + 20);
            barRaceLabels[i] = raceLabel;
            window.addShape(raceLabel);

            // creates CFR labels
            if (race.getCFR() != -1) {
                TextShape cfrLabel = new TextShape(0, 0, String.valueOf(race
                    .getCFR()) + "%");
                cfrLabel.moveTo(startPoints[i] + (BAR_WIDTH / 2) - cfrLabel
                    .getWidth() / 2, BAR_Y + totalBarHeight + 40);
                barCFRLabels[i] = cfrLabel;
                window.addShape(cfrLabel);
            }
        }

    }


    /**
     * Wipes bars and bar labels from the display.
     */
    private void clearDisplay() {
        for (Shape sh : bars) {
            removeIfExist(sh);
        }

        for (Shape sh : barRaceLabels) {
            removeIfExist(sh);
        }

        for (Shape sh : barCFRLabels) {
            removeIfExist(sh);
        }

        removeIfExist(title);
    }


    /**
     * Helper method that removes Shapes from display if not null.
     * 
     * @param sh
     *            Shape being removed.
     */
    private void removeIfExist(Shape sh) {
        if (sh != null) {
            sh.remove();
        }
    }


    /**
     * Finds the maximum CFR in the list in order to calculate the relative
     * heights of the bars.
     * 
     * @param raceList
     *            LinkedList of Races to check.
     * @return maximum CFR found.
     */
    private double findMaxCFR(LinkedList<Race> raceList) {
        double maxCFR = 0;
        for (int i = 0; i < raceList.getLength(); i++) {
            double cfr = raceList.getEntry(i).getCFR();
            if (cfr > maxCFR) {
                maxCFR = cfr;
            }
        }
        return maxCFR;
    }

}
