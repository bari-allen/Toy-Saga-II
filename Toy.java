//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Toy Saga II - Toy
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
 * The super class for the Teddy Bear, Car, and Hoverball objects.
 *
 * @author karl haidinyak
 */
public class Toy extends GraphicObject implements MouseListener, Movable {


    private boolean isDragging;

    /**
     * Constructs a Toy object with the inputted file name. Calls to super(String filename)
     *
     * @param filename the filename of the Toy object
     */
    public Toy(String filename) {
        super(filename);
    }

    /**
     * Constructs a Toy object with the inputted file name, and x and y coordinates. Calls to
     * super(String filename, int x, int y)
     *
     * @param filename the filename of the Toy object
     * @param x the x coordinate to construct the Toy object
     * @param y the y coordinate to construct the Toy object
     */
    public Toy(String filename, int x, int y) {
        super(filename, x, y);
    }

    /**
     * Draws the Toy object in the program window. Calls to the super.draw() method.
     */
    @Override
    public void draw() {
        move();
        super.draw();
    }

    /**
     * Returns whether the Toy is being dragged or not
     * @return true when the Toy object is being dragged and false otherwise
     */
    public boolean isDragging() {
        return isDragging;
    }

    /**
     * Sets isDragging to true
     */
    public void startDragging() {
        isDragging = true;
    }

    /**
     * Sets isDragging to false
     */
    public void stopDragging() {
        isDragging = false;
    }

    /**
     * Moves the Toy object by dx and dy.</BR>
     * If the x-coordinate + dx is greater than the width or less than 0, the object
     * will not be moved in the x-direction.</BR>
     * If the y-coordinate + dy is greater than the height or less than 0, the object will
     * not be moved in the y-direction.
     *
     * @param dx how much the object is moved in the x-direction
     * @param dy how much the object is moved in the y-direction
     */
    protected void move(int dx, int dy) {
        if (!(super.getX() + dx >= toySaga.width - image.width / 2)
                        && !(super.getX() + dx <= image.width / 2 )) {
            super.x = super.getX() + dx;
        } else super.x = super.getX();

        if (!(super.getY() + dy >= toySaga.height - (image.height / 2))
                        && !(super.getY() + dy <= image.height / 2)) {
            super.y = super.getY() + dy;
        } else super.y = super.getY();
    }

    /**
     * If the Toy object is being dragged, then the change in the x and y-coordinates will be
     * calculated. This method calls to the move(int dx, int dy) method to change the x and
     * y-coordinates of the Toy object
     */
    @Override
    public void move() {
        if (isDragging) {
            int dx = toySaga.mouseX - toySaga.pmouseX;
            int dy = toySaga.mouseY - toySaga.pmouseY;
            move(dx, dy);
        }
    }

    /**
     * Determines whether the Toy object is over the inputted x and y-coordinates.
     *
     * @param x the inputted x-coordinate
     * @param y the inputted y-coordinate
     * @return true if the Toy object is over the inputted coordinates and false otherwise
     */
    public boolean isOver(int x, int y) {
        return ((super.getX() >= x - (image.width) / 2) && (super.getX() <= x + (image.width) / 2))
                && ((super.getY() >= y - (image.height))) && (super.getY() <= y + (image.height));
    }

    /**
     * Calls to the startDragging() method if the mouse is over the Toy object and no other
     * Toy object is being dragged
     */
    @Override
    public void onClick() {
        if (isMouseOver() && toySaga.noToyIsDragging()) startDragging();
    }

    /**
     * Calls to the stopDragging() method
     */
    public void onRelease() {
        stopDragging();
    }

    /**
     * Determines whether the mouse is over the Toy object.
     * This method calls to the .isOver(int x, int y) method.
     *
     * @return true if the mouse is over the Toy object and false otherwise
     */
    public boolean isMouseOver() {
        return isOver(toySaga.mouseX, toySaga.mouseY);
    }
}
