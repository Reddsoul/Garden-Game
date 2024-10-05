import java.util.Scanner;
import java.io.*;

class GardenMain {

  public static void main(String[] args) throws IOException {

    System.out.println("Garden Simulator");

    System.out.println("----------------");

    System.out.println("You are the gardener for this soon to be beautiful garden, you can grow flowers, bushes, and tree. Growing plants are in lowercase letters (f, b, t) while grown plants are in uppercase letters (F, B ,T).");

    System.out.println("However, you must protect your garden from WEEDS and dangerous CREATURES like Fox's (O), Locust's (L) while maintaining your gardens prestine look. You also have Bee's (E) that help you\n");

    System.out.println("P.S. Don't run out of water.\n");

    try (Scanner input = new Scanner(System.in)) {
		System.out.println("Please enter the size of your new Garden's height: ");

		int height = input.nextInt();

		System.out.println("Please enter the size of your new Garden's length: ");

		int length = input.nextInt();

		boolean expandsion = false;


		Plot garden = new Plot(height, length);

		int day = 0;

		while (true) {

		  day++;

		  // Weeds have a chance of spreading every day
		  garden.spreadWeed();

		  // The water levels go down by 1 every day
		  garden.waterPlant();

		  // The fertilizer levels go down by 1 every day
		  garden.fertilizePlant();

		  // There is a change an animal will be created and its ability be used
		  garden.createAnimal(garden);

		  System.out.print("\n- - - - - -\n" + "Day:" + day + "\n- - - - - -\n");

		  System.out.println("Water levels: " + garden.getWaterSupply());

		  System.out.println("Fertilizer levels: " + garden.getFertilizer());

		  garden.printPlot();

		  System.out.println("\nPick: \n" + 
		                     "1. tend to plant\n" +	 
		                     "2. tend to critters\n" +
		                     "3. tend to plot\n" +
		                     "4. to quit\n");

		  int choice = input.nextInt();

		  // Every 25 days you have the ability to expand the plot
		  if(day % 25 == 0) {

		    System.out.println("\nYou can now expand the plot\n");

		  }

		  if (day % 25 == 0) {
			  
		    expandsion = true;
		    
		  }


		  // the game loop

		  switch (choice) {

		    case 1:

		      System.out.println("1. tend to plant");

		      System.out.print(
		        "\t1. Flowers\n" + 
		        "\t2. Bushes\n" + 
		        "\t3. Trees\n" + 
		        "\t4. Remove Weeds\n");

		        int choice1 = input.nextInt();

		        switch(choice1) {

		          case 1:
		            // Their is a chance a flower will grow on the plot/garden
		            System.out.println("choice:" + choice1);

		            garden.tendToPlant(choice1);

		            break;

		          case 2:

		             // Their is a chance bush/bushes will grow on the plot/garden

		            System.out.println("choice:" + choice1);

		            garden.tendToPlant(choice1);

		            break;

		          case 3:

		            // Their is a chance a tree will grow on the plot/garden

		            System.out.println("choice:" + choice1);

		            garden.tendToPlant(choice1);

		            break;

		          case 4:

		            // Gets rid of weeds

		            garden.killWeed();
		            System.out.println("choice:" + choice1);

		            break;

		        }

		      break;

		      case 2:

		        System.out.println("2. tend to critters");

		      System.out.print("\t1. Attack pest\n");

		        int choice2 = input.nextInt();

		        switch(choice2) {

		          case 1:
		            // Kills an Animal
		            garden.killAnimal();

		            break;
		        }
		        break;

		      case 3:
		        System.out.println("3. tend to plot");

		        System.out.print("\t1. hydrate\n" + 
		                         "\t2. fertalize\n" + 
		                         "\t3. expand\n");

		        int choice3 = input.nextInt();

		        switch (choice3){

		          case 1:
		            // Increases waterSupply levels
		            garden.hydrateGarden();

		            break;

		          case 2:

		            // Checks if the soil is fertilized, if fertilizer levels are 0, plants take more time to grow

		            garden.fertilizeSoil();

		            break;

		          case 3:
		        	// User can chose to expand the plot by double every 25 days 

		            if (expandsion == true) {
		              garden.expandPlot();
		              expandsion = false;
		            }

		            else {

		              System.out.println("You can't expand the plot, you can expand the plot every 25 days");

		            }

		            break;
		        }

		      break;

		      case 4:
		        System.exit(0);

		      break;
		    }// switch

		}//for
	}

  }// main

}// class