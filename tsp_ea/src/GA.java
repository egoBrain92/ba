/*
* GA.java
* Manages algorithms for evolving population
*/

public class GA {
	
	//private static final double mutationRate = 0.00001;
	private static final double mutationRate = 1/(Main.citieCount^2);

	public static Population selection (Population pop){
		
		Tour[] newTours = new Tour[pop.populationSize()];
		
		for(int i = 0; i < pop.populationSize(); i++){
			
			Tour firstParent = chooseParent(pop);
			Tour secondParent = chooseParent(pop);
			
			Tour child = crossover(firstParent, secondParent);
			mutate(child);
			newTours[i] = child;
		}
		
		System.out.print("	" + "	" + pop.getFittest().getDistance() + "	" + (int) pop.getAverageDistance()+ "	" /*+ pop.getFittest().toString()*/ + "\n");
		
		for(int j = 0; j < pop.populationSize(); j++){
			pop.saveTour(j, newTours[j]);
		}
		
		return pop;
	}
	
	//Mutate a tour using swap mutation
    private static void mutate(Tour tour) {
        //Loop through tour cities
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            //Apply mutation rate
            if(Math.random() < mutationRate){
                //Get a second random position in the tour
                int tourPos2 = (int) (tour.tourSize() * Math.random());

                //Get the cities at target position in tour
                City city1 = tour.getCity(tourPos1);
                City city2 = tour.getCity(tourPos2);

                //Swap them around
                tour.setCity(tourPos2, city1);
                tour.setCity(tourPos1, city2);
            }
        }
    }
	public static Tour chooseParent(Population pop){
		
		double selection = Math.random();
		//double fitness = 0;
		
		double percent = 0;
		
		double fitnessAll = 0;
		for(int i = 0; i < pop.populationSize(); i++){
			fitnessAll += pop.tours[i].getFitness();
		}
		
		
		for(int i = 0; i < pop.populationSize(); i++){
			percent += pop.tours[i].getFitness()/fitnessAll;
			//fitness += pop.tours[i].getFitness();
			if(selection <= percent){
				return pop.getTour(i);
			}
		}		
		//fail
		return null; 
	}
	
	/*public static Tour crossover(Tour parent1, Tour parent2) {
        //Create new child tour
        Tour child = new Tour();

        //Get start and end sub tour positions for parent1's tour
        int startPos;
        int endPos;
        
        int number1 = (int) (Math.random() * parent1.tourSize());
        int number2 = (int) (Math.random() * parent1.tourSize());
        
        if(number1 <= number2){
        	startPos = number1;
        	endPos = number2;
        }else{
        	startPos = number2;
        	endPos = number1;
        }
        
        //Loop and add the sub tour from parent1 to our child
        for (int i = startPos; endPos < child.tourSize(); i++) {
        	child.setCity(i, parent1.getCity(i));
        }

        //Loop through parent2's city tour
        for (int i = 0; i < parent2.tourSize(); i++) {
            //If child doesn't have the city add it
            if (!child.containsCity(parent2.getCity(i))) {
                //Loop to find a spare position in the child's tour
                for (int j = 0; j < child.tourSize(); j++) {
                    //Spare position found, add city
                    if (child.getCity(j) == null) {
                        child.setCity(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }*/
	
	
	public static Tour crossover(Tour parent1, Tour parent2) {
        //Create new child tour
        Tour child = new Tour();
        //Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        //Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.tourSize(); i++) {
            //If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            } //If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        //Loop through parent2's city tour
        for (int i = 0; i < parent2.tourSize(); i++) {
            //If child doesn't have the city add it
            if (!child.containsCity(parent2.getCity(i))) {
                //Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.tourSize(); ii++) {
                    //Spare position found, add city
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }	
}