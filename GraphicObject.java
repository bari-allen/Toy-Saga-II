//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Toy Saga II - GraphicObject
// Course:   CS 300 Spring 2024
//
// Author:   Karl Haidinyak
// Email:    haidinyak@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import processing.core.PImage;

/**
 * The super class for the Toy class
 *
 * @author karl haidinyak
 */
public class GraphicObject implements Drawable {
    protected processing.core.PImage image; //the image of the GraphicObject
    protected static ToySaga toySaga; //the instance of toySaga
    protected int x; //the x-coordinate of the GraphicObject
    protected int y; //the y-coordinate of the GraphicObject

    /**
     * Constructs a GraphicObject with the inputted file name
     *
     * @param filename the file name of the GraphicObject image
     */
    public GraphicObject(String filename) {
        image = toySaga.loadImage(filename);
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructs a GraphicObject with the inputted file name, and x and y-coordinates
     *
     * @param filename the file name of the GraphicObject image
     * @param x the x-coordinate of the GraphicObject
     * @param y the y-coordinate of the GraphicObject
     */
    public GraphicObject(String filename, int x, int y) {
        image = toySaga.loadImage(filename);
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the image of the GraphicObject to the image specified by the file name
     *
     * @param filename the file name of the specified image
     */
    public void setImage(String filename) {
        image = toySaga.loadImage(filename);
    }

    /**
     * Draws the GraphicObject in the program window
     */
    @Override
    public void draw() {
        toySaga.image(image, x, y);
    }

    /**
     * Returns the x-coordinate of the GraphicObject
     *
     * @return the x-coordinate of the GraphicObject
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of the GraphicObject
     *
     * @return the y-coordinate of the GraphicObject
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the toySaga instance to the inputted toySaga instance
     *
     * @param toySaga the inputted toySaga instance
     */
    public static void setProcessing(ToySaga toySaga) {
        GraphicObject.toySaga = toySaga;
    }
}
