import java.util.*;

public class Fox extends Animal{

  // Fox constructor that calls the Animal constructor
  public Fox(){
	  
    super();
    
  }

  // ---------------------------------------------------------------

  // Uses the fox's ability which kills plants
  public char[][] ability(Plot garden) {
	  
    Fox fox = new Fox();
    
    int foxEffectiveness = fox.getEffectiveness();
    
    Random random = new Random();
    
    char[][] plot = garden.getPlot();
    

    for (int i = 1; i <= garden.getHeight(); i++) {
    	
      for (int j = 1; j <= garden.getLength(); j++) {

        if (foxEffectiveness == 0) {

          if (plot[i][j] != '.' && plot[i][j] != 'x' && plot[i][j] != 'O' && plot[i][j] != 'E' && plot[i][j] != 'L' && random.nextDouble() < 0.2) {

          plot[i][j] = 'x';

          System.out.println("Plant at position (" + i + ", " + j + ") has died");
          
          }
          
        }

          if (foxEffectiveness == 1) {

            if (plot[i][j] != '.' && plot[i][j] != 'x' && plot[i][j] != 'O' && plot[i][j] != 'E' && plot[i][j] != 'L' && random.nextDouble() < 0.4) {

            plot[i][j] = 'x';

            System.out.println("Plant at position (" + i + ", " + j + ") has died");
            
            }
            
          }

          else {

            if (plot[i][j] != '.' && plot[i][j] != 'x' && plot[i][j] != 'O' && plot[i][j] != 'E' && plot[i][j] != 'L' && random.nextDouble() < 0.6) {

            plot[i][j] = 'x';

            System.out.println("Plant at position (" + i + ", " + j + ") has died");
            
            }
            
          }

      }

    }
    
    return plot;
    
  }
  
  // ---------------------------------------------------------------

  // Returns the fox's symbol
  public char getSymbol() {
	  
    return 'O';
    
  }

  // ---------------------------------------------------------------
}
