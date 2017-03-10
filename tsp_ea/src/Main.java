

public class Main {

	public static void main(String[] args) {
		
		//init cities
		for(int i = 0; i < 10; i++){
			//City newCity = new City(i, i);
	        TourManager.addCity(new City(Integer.toString(i) ,i, i));
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
