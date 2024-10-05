import java.util.*;

public abstract class Animal {
  private int effectiveness;

  // Animal constructor
  public Animal() {
	  
    Random random = new Random();
    
    effectiveness = random.nextInt(3);
    
  }
  
  // ---------------------------------------------------------------

  // Returns the effectiveness of the animal
  public int getEffectiveness() {
	  
      return effectiveness;
  }
  
  // ---------------------------------------------------------------

  // Will contain the symbol that represents each animal
  public abstract char getSymbol();
  
  // ---------------------------------------------------------------

}