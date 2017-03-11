# Coin-Toss-Simulator
This is a graphics-based program to simulate someone tossing a pair of coins some number of times, and display the results. So for example the user may request 10 trials. For each trial two coins are tossed. The program reports in bar graph form how many times the result was two heads, how many times it was two tails, and how many times it was one of each.

This project includes four pieces of code. They are CoinTossSimulator class, Bar class, CoinSimViewer class, CoinSimComponent class. 

CoinSimViewer. Contains the main method. Prompts for the number of trials, and creates the JFrame containing the CoinSimComponent. 

CoinSimComponent. Extends JComponent. Constructor initializes any necessary data and runs the simulation. Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. 

CoinTossSimulator. This is the class responsible for doing the simulation. It has no graphical output, and in fact, does no I/O to the console either. It has a run method to run a simulation of tossing a pair of coins for some number of trials. It has accessors to get the results of the simulation. Subsequent calls to run add trials to the current simulation. To reset the CoinTossSimulator to start a new simulation, call the reset method. For examples of how it operates, see the sample output of the test program from the section on testing this class.

Bar. For drawing a bar in a bar graph.The only other method is draw which draws the bar given.
