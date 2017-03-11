// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA1
// Spring 2017

/**
 * class CoinTossSimulator
 *
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 *
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants,
 * and private methods to the class.  You will also be completing the
 * implementation of the methods given.
 *
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 *
 */
import java.util.Random;
public class CoinTossSimulator {

    private int trials;
    private int[] num1;
    private int[] num2;
    /**
     Creates a coin toss simulator with no trials done yet.
     */
    public CoinTossSimulator() {

    }


    /**
     Runs the simulation for numTrials more trials. Multiple calls to this
     without a reset() between them add these trials to the simulation
     already completed.

     @param numTrials  number of trials to for simulation; must be >= 1
     */
    public void run(int numTrials) {

        Random generator = new Random();
        num1 = new int[trials + numTrials];
        num2 = new int[trials + numTrials];
        for (int i = trials; i < trials + numTrials; i++){
            int BOUND_OF_RANDOM_NUM = 2;
            num1[i] = generator.nextInt(BOUND_OF_RANDOM_NUM);
            num2[i] = generator.nextInt(BOUND_OF_RANDOM_NUM);
        }
        trials = trials + numTrials;
    }


    /**
     Get number of trials performed since last reset.
     */
    public int getNumTrials() {
        return trials; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up two heads since last reset.
     */
    public int getTwoHeads() {
        int NumTwoHeadsTrial = 0;
        for (int i = 0; i < trials; i++){
            if (num1[i] == 1 && num2[i] ==1){
                NumTwoHeadsTrial = NumTwoHeadsTrial + 1;
            }
        }
        return NumTwoHeadsTrial; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up two tails since last reset.
     */
    public int getTwoTails() {
        int NumTwoTailsTrial = 0;
        for (int i = 0; i < trials; i++){
            if (num1[i] == 0 && num2[i] ==0){
                NumTwoTailsTrial = NumTwoTailsTrial + 1;
            }
        }
        return NumTwoTailsTrial; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up one head and one tail since last reset.
     */
    public int getHeadTails() {
        int NumHeadTails = 0;
        for (int i = 0; i < trials; i++){
            if (num1[i] == 0 && num2[i] ==1 || num1[i] == 1 && num2[i] == 0){
                NumHeadTails = NumHeadTails + 1;
            }
        }
        return NumHeadTails;
    }


    /**
     Resets the simulation, so that subsequent runs start from 0 trials done.
     */
    public void reset() {
      trials = 0;
    }

}
