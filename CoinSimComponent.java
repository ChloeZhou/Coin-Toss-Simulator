// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA1
// Spring 2017

import javax.swing.JComponent;
import java.awt.*;
import java.awt.Color;

/**
 * CoinSimComponent class
 *
 * Initializes and calculates the necessary data to draw the bars.
 * Runs the simulation.
 *
 */
public class CoinSimComponent extends JComponent{

    private int numTrials;
    private int windowWidth;
    private int windowHeight;
    private int twoHeads;
    private int twoTails;
    private int headTails;

    /**
     Calculate the necessary data such as the height and the width of the bar.

     @param noOfTrials  The number of trials of simulation

     */
    public  CoinSimComponent(int noOfTrials){
        /**
         *Creates a constructor so that we can pass the the information to the constructor and save it as an instance
         *variable and use it in the other methods.
         *
         * Runs the simulation and calculates the data depending on the results.
         */
        numTrials = noOfTrials;
        CoinTossSimulator Sim = new CoinTossSimulator();
        Sim.run(numTrials);
        twoHeads = Sim.getTwoHeads();
        twoTails = Sim.getTwoTails();
        headTails = Sim.getHeadTails();

    }
    /**
     * Initializes the data such as location of the bottom of the label, location of the left side of the bar,
     * width of the bar (in pixels), height of the bar in application units, how many pixels per application unit
     * the color of the bar, and the label at the bottom of the bar).
     *
     * Every time the window gets resized, the bar graph will also get resized appropriately.
     *
     @param g  the graphics context
     */
    public void paintComponent(Graphics g){
        windowWidth = this.getWidth();    // Get the current window width.
        windowHeight = this.getHeight();  // Get the current window height.

        Graphics2D g2 = (Graphics2D) g;
        double RATIO_OF_BOTTOM = 0.95;       // Initialize the position of the bottom according to different window height, so I use ratio to find the appropriate position
        double RATIO_OF_INTERVAL = 0.203125; // Initialize the position of the bar according to different window width and place the bars evenly across the window.
        double RATIO_OF_WIDTH = 0.0625;

        int bottom = (int)(windowHeight * RATIO_OF_BOTTOM);
        int left = (int)(windowWidth * RATIO_OF_INTERVAL);
        int width = (int)(windowWidth * RATIO_OF_WIDTH);
        double scale1 = (twoHeads/(double)numTrials);   // Calculate the ratio to get height of the bar of two heads.
        double scale2 = (headTails/(double)numTrials);  // Calculate the ratio to get height of the bar of one head and one tail.
        double scale3=  (twoTails/(double)numTrials);   // Calculate the ratio to get height of the bar of two tails.

        int CHANGE_TO_PERCENTAGE = 100;
        /*
        Edit the content of the label
         */
        String label1 = "Two Heads: " + twoHeads + " " +  (int)(scale1 * CHANGE_TO_PERCENTAGE) + "%";
        String label2 = "A Head and a Tail: " + headTails + " " + (int)(scale2 * CHANGE_TO_PERCENTAGE) + "%";
        String label3 = "Two Tails: " + twoTails + " " + (CHANGE_TO_PERCENTAGE - (int)(scale1 * CHANGE_TO_PERCENTAGE) - (int)(scale2 * CHANGE_TO_PERCENTAGE)) + "%";
        /*
        Create three bars represent the three kinds of results separately.
         */
        Bar bar1 = new Bar(bottom, left, width, windowHeight, scale1, Color.red, label1 );
        Bar bar2 = new Bar(bottom, 2 * left + width, width, windowHeight, scale2, Color.green, label2);
        Bar bar3 = new Bar(bottom, 3 * left + 2 * width, width, windowHeight, scale3, Color.blue, label3);
        /*
        Draw the bars.
         */
        bar1.draw(g2);
        bar2.draw(g2);
        bar3.draw(g2);
    }

}
