public class Main {
	
	public  int popSize = 300;

	public static void main(String[] args) {
		
		Tour initTour = new Tour(TourManager.getDestinationCities());
		
		//initialize cities
		for(int i = 0; i < 10; i++){
			
	        TourManager.addCity(new City( "(" + Integer.toString(i)+ ")" ,i*10, 10)); //default constructor could be used
	        //TourManager.addCity(new City());
		}



        Population pop = new Population(300);
        

        
        System.out.print("raw input beginn\n");
        System.out.println("	" + "	" + initTour.getDistance() + "	" + "	" + initTour.toString());
        System.out.print("raw input end\n");
        
        //print results
        System.out.println("init	" + "avg	" + "fittest	" + "avg");
        pop = GA.selection(pop);
        for (int i = 0; i < 150; i++) {
            pop = GA.selection(pop);
        }
    }
}
