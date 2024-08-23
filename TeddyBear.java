//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Toy Saga II - Teddy Bear
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
import java.util.Objects;

/**
 * This class models a Teddy Bear, which inherits from Toy, The properties of the Teddy Bear include
 * rotation, rotationDirection, callout, and ToySaga object.
 */
public class TeddyBear extends Toy {
    private Callout callout; //the text box of the bear when in night mode
    private float rotation; //how much the bear is being rotated
    private boolean rotationDirection; //the direction of the rotation - true is clockwise

    /**
     * Constructs a Teddy Bear object positioned at the specified location given by the x and
     * y position.
     *
     * @param x the x position where to create the Teddy Bear object
     * @param y the y position where to create the Teddy Bear object
     */
    public TeddyBear(int x, int y) {
        super(ToySaga.BEAR, x, y);
        rotation = 0;
        rotationDirection = true; //clockwise direction
        callout = new Callout(x, y);
    }

    /**
     * Returns how much the Teddy Bear is being rotated
     * @return the rotation of the Teddy Bear object
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * Sets the rotation of the Teddy Bear
     * @param rotation the new rotation of the Teddy Bear object
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * Returns the direction the Teddy Bear is being rotated
     *
     * @return true when the object is rotated clockwise and false when the object is rotated
     * counter-clockwise.
     */
    public boolean getRotationDirection() {
        return rotationDirection;
    }

    /**
     * Draws the Teddy Bear object in the program window
     */
    @Override
    public void draw() {
        if (toySaga.isNightMode()) drawTeddyBearNightMode();
        else super.draw();
    }

    /**
     * Draws the Teddy Bear object when the program is in night-mode.
     */
    private void drawTeddyBearNightMode() {
        move();
        toySaga.pushMatrix();
        toySaga.translate(x, y);
        toySaga.rotate(rotation * PApplet.PI / 2);
        if (Objects.equals(toySaga.getMode(), "NIGHT")) {
            toySaga.image(callout.image, 20f, -90f);
        }
        toySaga.image(image, 0.0f, 0.0f);
        toySaga.popMatrix();
    }

    /**
     * Alters the position of the Teddy Bear object in the program window.</BR>
     * If the program is in night-mode, then the Teddy Bear object with be rotated by 3 degrees.</BR>
     * If the program is in day-mode, then the Teddy Bear object will move according to super.move().
     */
    @Override
    public void move() {
        if (toySaga.isNightMode()){
            if (rotation > PApplet.radians(30) || rotation < PApplet.radians(-30))
                rotationDirection = !rotationDirection;
            if (rotationDirection)  rotation += PApplet.radians(3); //clockwise direction
             else rotation -= PApplet.radians(3); //counterclockwise direction
        } else super.move();
    }

}
