package prj5;

import cs2.Window;
import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.WindowSide;

/**
 * Display window
 * 
 * @author Ethan Homoroc (homorocethanj22)
 * @version 4.23.2021
 */
public class CovidWindow {

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
    private TextShape textShape;
    private TextShape black;
    private TextShape white;
    private TextShape asian;
    private TextShape latinx;
    private TextShape other;

    /**
     * CovidWindow Constructor
     *
     */
    public CovidWindow() {

        window = new Window();

        sortByAlpha = new Button("Sort by Alpha");
        window.addButton(sortByAlpha, WindowSide.NORTH);
        sortByAlpha.onClick(this, "clickedSortAlphaButton");

        sortByCFR = new Button("Sort By CFR");
        window.addButton(sortByCFR, WindowSide.NORTH);
        sortByCFR.onClick(this, "clickedSortCFRButton");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuitButton");
        this.textShape = new TextShape(250, 25, "");
        window.addShape(textShape);

        dc = new Button("Represent DC");
        window.addButton(dc, WindowSide.SOUTH);
        dc.onClick(this, "clickedDC");

        ga = new Button("Represent GA");
        window.addButton(ga, WindowSide.SOUTH);
        ga.onClick(this, "clickedRepGA");

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

    }


    public static void main(String[] args) {
        CovidWindow w = new CovidWindow();
    }
}
