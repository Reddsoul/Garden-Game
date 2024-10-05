import java.util.*;

public class Plot {

  private static final char EMPTY = '.';

  private static final char FLOWER = 'F';

  private static final char TREE = 'T';

  private static final char BUSH = 'B';

  private static final char GROWING_TREE = 't';

  private static final char GROWING_BUSH = 'b';

  private static final char GROWING_FLOWER = 'f';

  private static final char WEED = 'W';

  private static final char DEAD = 'x';

  private char[][] plot;

  private int height;

  private int length;

  private int waterSupply;

  private int fertilizer;

  private double growthSpeedOne = 0.1;

  private double growthSpeedTwo = 0.2;

  private double growthSpeedThree = 0.3;

  private int growthRate = 0;

  private int beeCounter = 0;

  // ---------------------------------------------------------------
 
  // Constructor for plot
  public Plot(int height, int length) {

    this.height = height;

    this.length = length;

    this.plot = new char[height + 2][length + 2];

    this.waterSupply = 5;

    this.fertilizer = 10;

    initializePlot();

  }

  // ---------------------------------------------------------------
  
  // Returns the plot height
  public int getHeight() {

    return height;

  }
    // ---------------------------------------------------------------

  // Returns the plot length
  public int getLength() {

    return length;

  }

  // Returns the plot
  public char[][] getPlot() {
    return plot;
  }
  
  // ---------------------------------------------------------------

  // Returns the water supply
  public int getWaterSupply() {

    return waterSupply;

  }

  // ---------------------------------------------------------------

  // Returns the fertilizer levels
  public int getFertilizer() {

    return fertilizer;

  }

  // ---------------------------------------------------------------

  // Expands the plot which can happen every 25 days
  public void expandPlot() {

    int numRowsToAdd = height;

    int numColsToAdd = length;

    char[][] newPlot = new char[height + numRowsToAdd + 2][length + numColsToAdd + 2];

    // Initialize the new rows and columns

    for (int i = 1; i <= height + numRowsToAdd; i++) {

      for (int j = 1; j <= length + numColsToAdd; j++) {

        newPlot[i][j] = EMPTY;
      }

    }

    // Copy the existing plot to the new plot
    for (int i = 1; i <= height; i++) {

      System.arraycopy(plot[i], 1, newPlot[i], 1, length);

    }

    // Update the garden plot and dimensions

    plot = newPlot;

    height += numRowsToAdd;

    length += numColsToAdd;

    System.out.println("Garden plot has been expanded!");

  }

  // ---------------------------------------------------------------
  
  // Initializing the plot
  private void initializePlot() {

    for (int i = 0; i < plot.length; i++) {

      for (int j = 0; j < plot[0].length; j++) {

        plot[i][j] = EMPTY;

      }

    }

  }

  // ---------------------------------------------------------------

  // Printing the plot to the console
  public void printPlot() {

    for (int i = 1; i <= height; i++) {

      for (int j = 1; j <= length; j++) {

        System.out.print(plot[i][j] + " ");

      }

      System.out.println();

    }

  }

  // ---------------------------------------------------------------

//Every day water supply is reduced, and if it's 0, killPlant() is called which the kills plants
  public void waterPlant() {

    if (waterSupply > 0) {

      waterSupply--;

    }

    if (waterSupply == 1) {

      System.out.println("Plants need water");

    }

    else if (waterSupply == 0) {

      System.out.println("Plants are dying due to lack of water!");

      killPlant();

    }

  }

  // ---------------------------------------------------------------

  // Every day, reduce fertilizer, and if it's 0, plants grow slower
  public void fertilizePlant() {

    if (fertilizer > 0) {

      fertilizer--;

    }

    if (fertilizer == 1) {

      System.out.println("Plants need fertilizer!");

    }

    else if (fertilizer == 0) {

      System.out.println("Plants are growing slower due to lack of fertilizer!");

      growthRate = 1;

    }

  }

  // ---------------------------------------------------------------
  
  // Increases water supply by 7
  public void hydrateGarden() {

    waterSupply += 7;

    System.out.println("The plot has been hydrated");
    
  }

  // ---------------------------------------------------------------

  // Increases fertilizer levels by 10
  public void fertilizeSoil() {

    fertilizer += 10;

    System.out.println("The plot has been fertilized");

  }

  // ---------------------------------------------------------------

  // There is a chance plant/plants will grow
  public void tendToPlant(int choice1) {
	  
    Random random = new Random();

    boolean flowerGrown = true;

    boolean treeGrown = true;

    boolean bushGrown = true;

    int i = random.nextInt(height) + 1;

    int j = random.nextInt(length) + 1;

    // Changes the growth rate
    if (growthRate == 1) {

      growthSpeedThree = 0.15;

      growthSpeedTwo = 0.1;

      growthSpeedOne = 0;

    }

    // Flower have a chance of growing (f), if flower is already on plot their is a chance it will become a grown flower (F)
    if (choice1 == 1) {

      if (plot[i][j] == GROWING_FLOWER && random.nextDouble() < growthSpeedThree) {

        plot[i][j] = FLOWER;
      } 

      else if (plot[i][j] != FLOWER && flowerGrown == true && random.nextDouble() < 0.3) {

        plot[i][j] = GROWING_FLOWER;

        System.out.println("A flower has grown at position (" + i + ", " + j + ")");

        flowerGrown = false;

      }

    }

    // Bush have a chance of growing (b), if bush is already on plot their is a chance it will become a grown bush (B)
    // Bushes have a chance to grow in clusters
    if (choice1 == 2) {		

      if (plot[i][j] == GROWING_BUSH && random.nextDouble() < growthSpeedThree) {

        plot[i][j] = BUSH;

      } 

      else if (plot[i][j] != BUSH && bushGrown == true && random.nextDouble() < growthSpeedTwo) {

        plot[i][j] = GROWING_BUSH;

        System.out.println("The bushs have spread to position (" + i + ", " + j + ")");

        bushGrown = false;

        if (random.nextDouble() < growthSpeedTwo) {

          plot[i - 1][j] = GROWING_BUSH;

          System.out.println("The bush have spread to position (" + i + ", " + j + ")");

        }

        if (random.nextDouble() < growthSpeedTwo) {

          plot[i + 1][j] = GROWING_BUSH;

          System.out.println("The bush have spread to position (" + i + ", " + j + ")");

        }

        if (random.nextDouble() < growthSpeedTwo) {

          plot[i][j - 1] = GROWING_BUSH;

          System.out.println("The bush have spread to position (" + i + ", " + j + ")");

        }

        if (random.nextDouble() < growthSpeedTwo) {

          plot[i][j + 1] = GROWING_BUSH;

          System.out.println("The bush have spread to position (" + i + ", " + j + ")");

        }

      }

    }

    // Tree has a chance of growing (t), if tree is already on plot their is a chance it become a grown tree (T)
    if (choice1 == 3) {

      if (plot[i][j] == GROWING_TREE && random.nextDouble() < growthSpeedTwo) {

        plot[i][j] = TREE;

      } 

      else if (plot[i][j] != TREE && treeGrown == true && random.nextDouble() < growthSpeedOne) {

        plot[i][j] = GROWING_TREE;

        System.out.println("A tree has grown at position (" + i + ", " + j + ")");

        treeGrown = false;

      }

    }

  }

  // ---------------------------------------------------------------

  // Every day their is a chance weeds will spread on the plot
  // Weeds can grow in clusters
  public void spreadWeed() {

    Random random = new Random();

    int i = random.nextInt(height) + 1;

    int j = random.nextInt(length) + 1;

    boolean weedGrown = true;

    if (weedGrown == true && random.nextDouble() < 0.1) {

      plot[i][j] = WEED;

      System.out.println("Weeds have spread to position (" + i + ", " + j + ")");

      weedGrown = false;

      if (random.nextDouble() < 0.2) {

        plot[i - 1][j] = WEED;

        System.out.println("Weeds have spread to position (" + i + ", " + j + ")");

      }

      if (random.nextDouble() < 0.2) {

        plot[i + 1][j] = WEED;

        System.out.println("Weeds have spread to position (" + i + ", " + j + ")");

      }

      if (random.nextDouble() < 0.2) {

        plot[i][j - 1] = WEED;

        System.out.println("Weeds have spread to position (" + i + ", " + j + ")");

      }

      if (random.nextDouble() < 0.2) {

        plot[i][j + 1] = WEED;

        System.out.println("Weeds have spread to position (" + i + ", " + j + ")");

      }

    }

  }

  // ---------------------------------------------------------------

  // There is a chance weed/weeds will be killed
  public void killWeed() {

    Random random = new Random();

    for (int i = 1; i < height; i++) {

      for (int j = 1; j <= length; j++) {

        if (plot[i][j] == WEED && random.nextDouble() < 0.4) {

          plot[i][j] = EMPTY;

          System.out.println("Weeds have been killed at position (" + i + ", " + j + ")");

        }

      }

    }

  }

  // ---------------------------------------------------------------

  // There is a chance some plants will die
  private void killPlant() {

    Random random = new Random();

    for (int i = 1; i <= height; i++) {

      for (int j = 1; j <= length; j++) {

        if (plot[i][j] != EMPTY && plot[i][j] != DEAD  && plot[i][j] != 'O' && plot[i][j] != 'E' && plot[i][j] != 'L' && random.nextDouble() < 0.3) {

          plot[i][j] = DEAD;

          System.out.println("Plant at position (" + i + ", " + j + ") has died");

        }

      }

    }

  }

  // ---------------------------------------------------------------

  // If animal is created and spawns on plot, it will stay their until the user remove the animal
  public void repeatAnimal(Plot garden) { 
	  
    for (int i = 1; i <= height; i++) {
    	
      for (int j = 1; j <= length; j++) {

        // A fox's ability will be used
        if (plot[i][j] == 'O') {

          Fox fox = new Fox();

          plot = fox.ability(garden);

          System.out.println("A fox came durnig the night and destoyed some of your plants!");

        }
        
        // If the bee has been on the plot after two days, it will disappear
        if (plot[i][j] == 'E' && beeCounter >= 2) {
        	
            plot[i][j] = EMPTY;
            
            beeCounter = 0;
            
          }
        
          // A bee's ability will be used
          else if (plot[i][j] == 'E') {
        	  
          Bee bee = new Bee();
          
          fertilizer = bee.ability(garden);
          
          beeCounter++;

          System.out.println("A bee has polinated your plot and increases the fertilizer levels to maintain plant growth.");
      }

        // A locust's ability will be used
        if (plot[i][j] == 'L') {
        	
          Locust locust = new Locust();
          
          waterSupply = locust.ability(garden);

          if (waterSupply < 0) {
        	  
            waterSupply = 0;
            
          }

          System.out.println("A swarm of locust's are drinking some of your water!");
          
        }
        
      }
      
    }
    
  }
  
  // ---------------------------------------------------------------

  // A animal will be killed if on the plot
  public void killAnimal() {
	  
    for (int i = 1; i <= height; i++) {
    	
      for (int j = 1; j <= length; j++) {
    	  
        if (plot[i][j] == 'O') {
        	
          plot[i][j] = EMPTY;
          
        }
        
        else if (plot[i][j] == 'L') {
        	
          plot[i][j] = EMPTY;
          
        }
        
      }
      
    }
    
    System.out.println("Bad creature has been killed.");
    
  }

  // ---------------------------------------------------------------
  
  // Every day there is a chance an animal will be created and use its ability
  public void createAnimal(Plot garden) {
	  
    Random random = new Random();
    
    int i = random.nextInt(height);
    
    int j = random.nextInt(length);
    
    garden.repeatAnimal(garden);

      // A locust's ability will be used
      if (random.nextDouble() < 0.1) {
    	  
        Locust locust = new Locust();
        
        waterSupply = locust.ability(garden);
        
        plot[i][j] = locust.getSymbol();

        System.out.println("A swarm of locust's came and dank some of your water!");

        if (waterSupply < 0) {
        	
          waterSupply = 0;
          
        }

        // A fox's ability will be used
      } else if (random.nextDouble() < 0.1) {
    	  
        Fox fox = new Fox();

        plot = fox.ability(garden);
        
        plot[i][j] = fox.getSymbol();

        System.out.println("A fox came durnig the night and destoyed some of your plants.");

        // A bee's ability will be used
      } else if (random.nextDouble() < 0.1) {
    	  
        Bee bee = new Bee();
        
        fertilizer = bee.ability(garden);
        
        plot[i][j] = bee.getSymbol();

        System.out.println("A bee has polinated your plot and increases the fertilizer levels to maintain plant growth!");

      }
      
    }
  
  // ---------------------------------------------------------------

  }