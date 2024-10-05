public class Locust extends Animal{

  // Locust constructor that calls the Animal constructor
  public Locust(){
	  
    super();
    
  }
  
  // ---------------------------------------------------------------

  // Uses the locust's ability which decreases the water supply
  public int ability(Plot garden) {
	  
    int waterSupply;
    
    waterSupply = garden.getWaterSupply();
    
    Locust locust = new Locust();
    
    int locustEffectiveness = locust.getEffectiveness();

    if (locustEffectiveness == 0) {
    	
      waterSupply = waterSupply - 2;
    }

    if (locustEffectiveness == 1) {
    	
      waterSupply = waterSupply - 4;
    }

    else {
    	
      waterSupply = waterSupply - 6;
    }

    return waterSupply;
  }

  // ---------------------------------------------------------------

  // Returns the locust's symbol
  public char getSymbol() {
	  
    return 'L';
  }
  
  // ---------------------------------------------------------------

}