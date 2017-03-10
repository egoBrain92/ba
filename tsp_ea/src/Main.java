public class Main {

	public static void main(String[] args) {
		
		//init cities
		for(int i = 0; i < 10; i++){
			
	        //TourManager.addCity(new City(Integer.toString(i) ,i, i)); //default constructor could be used
	        TourManager.addCity(new City());
		}

        //print results
        System.out.println("init	" + "avg	" + "fittest	" + "avg");

        Population pop = new Population(300);

        pop = GA.selection(pop);
        for (int i = 0; i < 300; i++) {
            pop = GA.selection(pop);
        }
    }
}
