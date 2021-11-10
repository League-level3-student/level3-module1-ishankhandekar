package _07_California_Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 °F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature °F = 65.0, max temperature °F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather {
	public static void overcast(){
		Scanner scan = new Scanner(System.in);
		String whatCity = scan.nextLine();
	}
    void start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        
        // All city keys have the first letter capitalized of each word
        Scanner scan = new Scanner(System.in);
		String whatCity = scan.nextLine();
        String cityName = Utilities.capitalizeWords( whatCity );
        WeatherData datum = weatherData.get(whatCity);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
        Double whatTemperature = scan.nextDouble();
        ArrayList<String> cities= new ArrayList<String>();
        for (String e: weatherData.keySet()) {
			datum = weatherData.get(e);
			if (datum.temperatureF == whatTemperature) {
				cities.add(e);
			}
		}
        System.out.println(cities);
        Double whatTemperatureRange1 = scan.nextDouble();
        Double whatTemperatureRange2 = scan.nextDouble();
        ArrayList<String> cities2 = new ArrayList<String>();
        for (String e: weatherData.keySet()) {
			datum = weatherData.get(e);
			if ((datum.temperatureF > whatTemperatureRange1) && (datum.temperatureF < whatTemperatureRange2)) {
				cities.add(e);
			}
		}
        
    }
}
