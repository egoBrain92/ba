import java.util.ArrayList;

public class Main {
		
	public static int citieCount = 24; // 24 cities with google stuff
	public static int popSize = 1000;
	public static int generations = 2000;

	public static ArrayList<City> citiesToPaint = new ArrayList<City>();
	public static ArrayList<City> bestCitiesFromAllGenerations = new ArrayList<City>();
	public static Tour bestTourFromAllGenerations = new Tour(bestCitiesFromAllGenerations);
	public static Tour bestTourFromAllGenerationsCompare = new Tour(bestCitiesFromAllGenerations);

	public static void main(String[] args) throws InterruptedException {
		
		
		
		Tour initTour = new Tour(TourManager.getDestinationCities());
		
		//initialize cities
		for(int i = 0; i < citieCount; i++){
			
	        //TourManager.addCity(new City( "(" + Integer.toString(i)+ ")" ,i*10, 10)); 
	        TourManager.addCity(new City());
	        
	        
		}
		
//		City city0 = new City("(00)", 40, 100);
//        TourManager.addCity(city0);
//		City city1 = new City("(01)", 80, 900);
//        TourManager.addCity(city1);
//		City city2 = new City("(02)", 120, 800);
//        TourManager.addCity(city2);
//		City city3 = new City("(03)", 160, 100);
//        TourManager.addCity(city3);
//		City city4 = new City("(04)", 200, 200);
//        TourManager.addCity(city4);
//		City city5 = new City("(05)", 240, 300);
//        TourManager.addCity(city5);
//		City city6 = new City("(06)", 280, 600);
//        TourManager.addCity(city6);
//		City city7 = new City("(07)", 320, 500);
//        TourManager.addCity(city7);
//		City city8 = new City("(08)", 360, 400);
//        TourManager.addCity(city8);
//		City city9 = new City("(09)", 400, 010);
//        TourManager.addCity(city9);
//		City city10 = new City("(10)", 440, 100);
//        TourManager.addCity(city10);
//		City city11 = new City("(11)", 480, 900);
//        TourManager.addCity(city11);
//		City city12 = new City("(12)", 520, 800);
//        TourManager.addCity(city12);
//		City city13 = new City("(13)", 560, 100);
//        TourManager.addCity(city13);
//		City city14 = new City("(14)", 600, 200);
//        TourManager.addCity(city14);
//		City city15 = new City("(15)", 640, 300);
//        TourManager.addCity(city15);
//		City city16 = new City("(16)", 680, 600);
//        TourManager.addCity(city16);
//		City city17 = new City("(17)", 720, 500);
//        TourManager.addCity(city17);
//		City city18 = new City("(18)", 760, 400);
//        TourManager.addCity(city18);
//		City city19 = new City("(19)", 800, 010);
//        TourManager.addCity(city19);
//        
//		City city20 = new City("(20)", 840, 600);
//        TourManager.addCity(city20);
//		City city21 = new City("(21)", 880, 500);
//        TourManager.addCity(city21);
//		City city22 = new City("(22)", 920, 400);
//        TourManager.addCity(city22);
//		City city23 = new City("(23)", 960, 010);
//        TourManager.addCity(city23);
        

        Population pop = new Population(popSize);
        
        
        System.out.print("raw input beginn\n");
        System.out.println("	" + "	" + initTour.getDistance() + "	" + "	" + initTour.toString());
        System.out.print("raw input end\n");
        
        //print results
        System.out.println("init	" + "avg	" + "fittest	" + "avg");
        
        GUIElements jp = new GUIElements();

//        GUIFrame jf = new GUIFrame(jp);
        
        pop = GA.selection(pop);
        for (int i = 0; i < generations; i++) {
        	if(generations % 5 == 0){
//            	Thread.sleep(75); //sleep so that the user can take a look at the output
        		System.out.print(i);
            	citiesToPaint = pop.getFittest().getTour(); //get newest fittest individual
            	
            	
//            	if(bestTourFromAllGenerations.getDistance() > ){
//            		bestTourFromAllGenerationsCompare = pop.getFittest().getTour();
//            	}
            	
            	jp.setCitiesToPaint(citiesToPaint);
        	}
        	
            pop = GA.selection(pop);
        }
         
    }
}
