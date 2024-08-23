//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Toy Saga II - Car
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

/**
 * This class models a Car which extends from the Toy class.
 */
public class Car extends Toy {
    private static int absoluteSpeed = 8;
    private boolean isMovingRightward;
    private int speed;

    /**
     * Constructs a Car object at the inputted x and y-coordinates, sets isMovingRightWard to true,
     * and sets the speed to the absoluteSpeed. Calls to super(String filename, int x, int y)
     *
     * @param x the x-coordinate where to construct the Car object
     * @param y the y-coordinate where to construct the Car object
     */
    public Car(int x, int y) {
        super(ToySaga.CAR, x, y);
        isMovingRightward = true;
        speed = absoluteSpeed;
    }

    /**
     * Draws the Car object in the program window.
     */
    @Override
    public void draw() {
        if (toySaga.isNightMode()) {
            move();
            drawCarNightMode();
        } else {
            super.draw();
        }
    }

    /**
     * Draws the Car object in the program window when the mode is set to NIGHT
     */
    public void drawCarNightMode() {
        toySaga.pushMatrix();
        toySaga.rotate(0.0f);
        toySaga.translate(x, y);
        if (!isMovingRightward) {
            toySaga.scale(-1.0f, 1.0f);
        }
        toySaga.image(image, 0.0f, 0.0f);
        toySaga.popMatrix();
    }

    /**
     * Calls to super.move() when in day-mode. In night-mode the car is moved in the x-direction by
     * the speed.
     */
    @Override
    public void move() {
        final int SPEED = 8;

        if (!toySaga.isNightMode()) {
            super.move();
            return;
        }

        if (super.x >= (toySaga.width - (image.width / 2)) - SPEED
                        || super.x <= ((image.width / 2) + SPEED)) {
            flipDirection();
        }

        super.move(speed, 0);
    }

    /**
     * Sets isMovingRightward to !isMovingRightward and sets speed to -speed
     */
    public void flipDirection() {
        isMovingRightward = !isMovingRightward;
        speed = -speed;
    }

    /**
     * Returns the absolute speed of the Car object
     *
     * @return the absolute speed of the Car object
     */
    public static int getSpeed() {
        return absoluteSpeed;
    }

    /**
     * Sets the absolute speed of the car to the inputted speed
     *
     * @param speed the inputted speed
     */
    public static void setSpeed(int speed) {
        absoluteSpeed = speed;
    }
}
