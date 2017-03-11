// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA1
// Spring 2017

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 *
 * Draw bars and add the corresponding label in the window.
 *
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 *
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 *
 */

public class Bar {



    /**
     Creates a labeled bar.  You give the height of the bar in application
     units (e.g., population of a particular state), and then a scale for how
     tall to display it on the screen (parameter scale).

     @param bottom  location of the bottom of the label
     @param left  location of the left side of the bar
     @param width  width of the bar (in pixels)
     @param bHeight  height of the bar in application units
     @param scale  how many pixels per application unit
     @param color  the color of the bar
     @param label  the label at the bottom of the bar
     */
    private int labelsBottom;
    private int barLeft;
    private int barWidth;
    private int bHeight;
    private double applyUnitScale;
    private Color barColor;
    private String bottomLabel;
    /**
     *Creates a constructor so that we can pass the the information to the constructor and save it as an instance
     *variable and use it in the other methods.
     */
    public Bar(int bottom, int left, int width, int barHeight,
               double scale, Color color, String label) {

           labelsBottom = bottom;
           barLeft = left;
           barWidth = width;
           applyUnitScale = scale;
           bHeight = barHeight;
           barColor = color;
           bottomLabel = label;

    }

    /**
     Draw the labeled bar.
     @param g2  the graphics context
     */
    public void draw(Graphics2D g2) {
        /*
           Get the dimensions of the label.
         */
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D labelBounds = font.getStringBounds(bottomLabel, context);
        int widthOfLabel = (int)labelBounds.getWidth();
        int heightOfLabel = (int)labelBounds.getHeight();
        /*
           Draw the bar.
         */
        bHeight = (int)((2 * labelsBottom - bHeight - heightOfLabel) * applyUnitScale);         // calculate the height of the bar according to the window size
        /*
           Create a rectangle and draw it.
         */
        int yCoordinate = labelsBottom - (heightOfLabel + bHeight); // Calculate the Y coordinate of the upper-left corner of the Rectangle.
        Rectangle rect = new Rectangle(barLeft, yCoordinate, barWidth, bHeight );
        g2.setColor(barColor);
        g2.draw(rect);
        g2.fill(rect);
        /*
           Add the label which is centered under the bar.
         */
        g2.setColor(Color.black);
        int xCoordinate = barLeft + (barWidth - widthOfLabel)/2; // Calculate the X coordinate of the label.
        g2.drawString(bottomLabel, xCoordinate, labelsBottom);

    }
}
