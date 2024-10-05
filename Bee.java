public class Bee extends Animal{


  // ---------------------------------------------------------------

  // Bee constructor that calls the Animal constructor
  public Bee(){
	  
    super();
    
  }

  // ---------------------------------------------------------------

  // Uses the bee's ability which decreases the fertilizer levels
  public int ability(Plot garden) {
	  
    int fertilizer = garden.getFertilizer();
    
    Bee bee = new Bee();
    
    int beeEffectiveness = bee.getEffectiveness();

    if (beeEffectiveness == 0) {
    	
      fertilizer += 3;
      
    }

    if (beeEffectiveness == 1) {
    	
      fertilizer += 5;
      
    }

    else {
    	
      fertilizer += 7;
      
    }

    return fertilizer;
    
  }


  // ---------------------------------------------------------------

  // Returns the bee's symbol
  public char getSymbol() {

    return 'E';

  }
  
  // ---------------------------------------------------------------

}