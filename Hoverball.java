//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Toy Saga II - Hoverball
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

import processing.core.PApplet;

/**
 * This class models a Hoverball which extends from the Toy class.
 */
public class Hoverball extends Toy{

    /**
     * Constructs a Hoverball object using the inputted x and y coordinates. This constructor calls
     * to the super class constructor.
     *
     * @param x the x position where the Hoverball object will be constructed
     * @param y the y position where the Hoverball object will be constructed
     */
    public Hoverball(int x, int y) {
        super(ToySaga.HOVERBALL_OFF, x, y);
    }

    /**
     * Changes the Hoverball image to HOVERBALL_ON when the program is in night-mode and sets it to
     * HOVERBALL_OFF otherwise.
     */
    public void switchOff() {
        if (toySaga.isNightMode()) setImage(ToySaga.HOVERBALL_ON);
        else setImage(ToySaga.HOVERBALL_OFF);
    }

    /**
     * Calls to super.draw() to draw the Hoverball object inside the program window
     */
    @Override
    public void draw() {
        switchOff();
        super.draw();
    }

    /**
     * Alters the height of the Hoverball object when in night-mode by
     * PApplet.sin(toySaga.frameCount & 0.1f) and calls to super.move()
     * when the program is in day-mode
     */
    @Override
    public void move() {
        if (toySaga.isNightMode()) {
            int dx = 0;
            int dy = Math.round(6 * PApplet.sin(toySaga.frameCount * 0.1f));
            super.move(dx, dy);
        } else super.move();
    }
}
