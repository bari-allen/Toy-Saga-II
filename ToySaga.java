//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Toy Saga II - ToySaga
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

import java.io.File;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class implements the main graphic user interface (GUI) of the p05 Toy Saga II program
 */
public class ToySaga extends processing.core.PApplet { // TODO declare ToySaga to inherit from the PApplet class

  // CONSTANTS
  // PATH to the folder of all images
  private static final String IMAGES_PATH = "images" + File.separator;

  // filename of the day background image of this toy saga
  protected static final String DAY_BACKGROUND = IMAGES_PATH + "backgroundDay.png";

  // filename of the night background image of this toy saga
  protected static final String NIGHT_BACKGROUND = IMAGES_PATH + "backgroundNight.png";

  // filename of the image of the bed
  protected static final String BED = IMAGES_PATH + "bed.png";

  // filename of the image of the nightstand
  protected static final String NIGHTSTAND = IMAGES_PATH + "nightstand.png";

  // filename of the image of the rug
  protected static final String RUG = IMAGES_PATH + "rug.png";

  // filename of the image of the car
  protected static final String CAR = IMAGES_PATH + "car.png";

  // filename of the image of the teddy bear
  protected static final String BEAR = IMAGES_PATH + "teddyBear.png";

  // filename of the image of the hoverball when it is on (night mode)
  protected static final String HOVERBALL_ON = IMAGES_PATH + "hoverBallOn.png";

  // filename of the image of the hoverball when it is off (day mode)
  protected static final String HOVERBALL_OFF = IMAGES_PATH + "hoverBallOff.png";

  // day mode
  protected static final String DAY_MODE = "DAY";

  // night mode
  protected static final String NIGHT_MODE = "NIGHT";

  // Maximum number of visible toys that can be stored in the drawableObjects list.
  private static final int MAX_TOYS_COUNT = 8;

  // other fields
  private static PImage backgroundImage; // PImage object that represents the background image
  private String mode;
  private ArrayList<Drawable> drawableObjects;


  // TODO add an instance (NOT final) field of type ArrayList named drawableObjects.
  // The drawableObjects arraylist stores elements of type Drawable (interface Drawable) ONLY.

  // TODO add an instance (NOT final) field of type String named mode.
  // mode represents the current mode of this ToySaga application.


  /**
   * Driver method that launches the application by calling this.runApplication()
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    PApplet.main("ToySaga"); //starts application
  }

  /**
   * Gets the current mode of this Toy Saga app. The mode might be DAY or NIGHT.
   * 
   * @return the current mode of this application
   */
  public String getMode() {
    return mode;
  }

  /**
   * Returns true if this ToySaga mode is NIGHT_MODE
   * 
   * @return true if this ToySaga mode is NIGHT_MODE
   */
  public boolean isNightMode() {
      return mode.equals(NIGHT_MODE);// default return statement
  }


  /**
   * Switches the mode of this toy saga application and loads the background image of the switched
   * mode. <BR>
   * 
   * Meaning, sets the mode to NIGHT_MODE if it was DAY_MODE and vice versa, and updates the
   * background image accordingly.
   */
  public void switchMode() {
    if (!isNightMode()) {
      mode = NIGHT_MODE;
      backgroundImage = loadImage(NIGHT_BACKGROUND);
    } else {
      mode = DAY_MODE;
      backgroundImage = loadImage(DAY_BACKGROUND);
    }
  }

  // TODO override the settings(), setup(), draw(), mousePressed(), mouseReleased(),
  // and keyPressed() callback methods predefined in the base class PApplet
  // uncomment the below code and complete the missing implementations
  /**
   * Sets the size of the display window of this graphic application
   */
   @Override
   public void settings() {
   this.size(800, 600);
   }

  /**
   * Sets the title and defines the initial environment properties of this graphic application. <br>
   * This method initializes all the data fields defined in this class.
   */
  @Override
  public void setup() {
    this.getSurface().setTitle("P5 Toy Saga v2.0");
    this.textAlign(CENTER, CENTER);
    this.imageMode(CENTER);
    this.rectMode(CORNERS);
    this.focused = true;

    mode = DAY_MODE;
    backgroundImage = loadImage(DAY_BACKGROUND);
    drawableObjects = new ArrayList<>();

    GraphicObject.setProcessing(ToySaga.this);
    SwitchButton.setProcessing(ToySaga.this);

    drawableObjects.add(new SwitchButton(565, 20));
    drawableObjects.add(new GraphicObject(BED, 520, 270));
    drawableObjects.add(new GraphicObject(RUG, 220, 370));
    drawableObjects.add(new GraphicObject(NIGHTSTAND, 325, 240));

  }

  /**
   * This callback method continuously draws and updates the application display window. It is
   * automatically called directly after setup() and continuously executes until the program is
   * stopped.
   * 
   * This method first draws the background image to the center of the screen. Then, it draws every
   * object stored in the drawableObjects list
   */
  @Override
  public void draw() {
    image(backgroundImage, width / 2, height / 2);

    for (Drawable item : drawableObjects) {
      item.draw();
    }
  }

  /**
   * Callback method called once after every time the mouse button is pressed.
   * 
   * This method calls the onClick() method on every instance of MouseListener stored in the
   * drawableObjects list
   * 
   */
  @Override
  public void mousePressed() {
    for (Drawable item : drawableObjects) {
      if (item instanceof MouseListener) {
        ((MouseListener) item).onClick();
      }
    }
  }

  /**
   * Callback method called every time the mouse button is released.
   * 
   * This method calls the onRelease() method on every instance of MouseListener stored in the
   * drawableObjects list
   * 
   */
  @Override
  public void mouseReleased() {
    for (Drawable item : drawableObjects) {
      if (item instanceof MouseListener) {
        ((MouseListener) item).onRelease();
      }
    }
  }

  /**
   * Callback method called once every time a key is pressed. The key that was pressed is returned
   * by the this.key() this method.<BR>
   * The ToySaga.keyPressed() method performs the below actions based on the pressed key: <BR>
   *
   * - Pressing 'c' or 'C' adds a new Car object at the mouse position if the MAX TOYS COUNT is not
   * reached. <BR>
   * - Pressing 't' or 'T' adds a new TeddyBear object at the mouse position if the MAX TOYS COUNT
   * is not reached. <BR>
   * - Pressing 'h' or 'H' adds a new Hoverball object at the mouse position if the MAX TOYS COUNT
   * is not reached. <BR>
   * - Pressing 'd' or 'D' sets/switches the mode to DAY_MODE and loads the DAY_BACKGROUND for the
   * background image of this application. <BR>
   * - Pressing 'n' or 'N' sets/switches the mode to NIGHT_MODE and loads the NIGHT_BACKGROUND for
   * the background image of this application. <BR>
   *
   */
  @Override
  public void keyPressed() {
    boolean addToy = getToyCount() != MAX_TOYS_COUNT;
    char key = this.key;

    if (addToy) {
      switch (key) {
        case 'c', 'C':
          drawableObjects.add(new Car(mouseX, mouseY));
          break;
        case 't', 'T':
          drawableObjects.add(new TeddyBear(mouseX, mouseY));
          break;
        case 'h', 'H':
          drawableObjects.add(new Hoverball(mouseX, mouseY));
          break;
      }
    }

    switch (key) {
      case 'd', 'D':
        mode = DAY_MODE;
        backgroundImage = loadImage(DAY_BACKGROUND);
        break;
      case 'n', 'N':
        mode = NIGHT_MODE;
        backgroundImage = loadImage(NIGHT_BACKGROUND);
        break;
    }
  }

  /**
   * Returns whether any toy object in the ArrayList is being dragged
   *
   * @return true if no toy objects are being dragged and false otherwise
   */
  public boolean noToyIsDragging() {
    for (Drawable item : drawableObjects) {
      if (item instanceof Toy && !((Toy) item).isDragging()) return true;
    }

    return false;
  }

  /**
   * Returns the number of Toy objects in the drawableObjects ArrayList
   *
   * @return the number of Toy objects in the drawableObjects ArrayList
   */
  public int getToyCount() {
    int count = 0;
    for (Drawable item : drawableObjects) {
      if (item instanceof Toy) ++ count;
      }
    return count;
    }

  }

