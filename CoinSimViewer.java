// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA1
// Spring 2017

import java.util.Scanner;
import javax.swing.JFrame;

/**
 *CoinSimViewer class
 *
 * Input the number of trials and creates the frame containing CoinSimComponent to display the result.
 *
 */
public class CoinSimViewer {
    /**
     * Creates the main method
     *
     * After running the main method, there will be a bar graph shows the result of simulation.
     *
     */
    public static void main(String[] args) {
            /*
            Read the the number of trials
             */
            Scanner in = new Scanner(System.in);
            System.out.print("Enter number of trials: ");
            int noOfTrials = in.nextInt();
            /*
            Check the input
             */
            while (noOfTrials <= 0) {
                System.out.println("ERROR: Number entered must be greater than 0.");
                System.out.print("Enter number of trials: ");
                noOfTrials = in.nextInt();
            }
            /*
            If the input is valid, draw the bar graph.
             */
            JFrame frame = new JFrame();
            int WINDOW_WIDTH = 800;
            int WINDOW_HEIGHT = 500;
            frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setTitle("CoinSim");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CoinSimComponent component = new CoinSimComponent(noOfTrials);
            frame.add(component);
            frame.setVisible(true);
    }
}

