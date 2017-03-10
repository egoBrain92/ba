/*
* City.java
* Models a city
*/

public class City {
    String cityName;
    int x;
    int y;
  
    
    // Constructs a randomly placed city
    public City(){
        this.cityName = "defautCityName";
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // Constructs a city at chosen x, y location
    public City(String cityName, int x, int y){
        this.cityName = cityName;
        this.x = x;
        this.y = y;
    }
    
    // Sets city's cityName
    public void setCityName(String newCityName){
        this.cityName = newCityName;
    }
    
    // Gets city's cityName
    public String getCityName(){
        return this.cityName;
    }
    
    // Gets city's x coordinate
    public int getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public int getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getCityName() + ": " + getX()+", "+getY();
    }
}