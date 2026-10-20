
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
public class TripPoint {
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip;
	
	/**TripPoint Constructor: initializes the class fields 'time', 'lat', and 'lon'.
	 * @param time
	 * @param lat
	 * @param lon
	 */
	public TripPoint(int time, double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
		this.time = time;
	}
	
	/**getTime() returns time. Simple method.
	 * 
	 * @return
	 */
	public int getTime() {
		return time;
	}
	
	/**getLat() returns latitude value.
	 * 
	 * @return
	 */
	public double getLat() {
		return lat;
	}
	
	/**getLon() returns the longitude value.
	 * 
	 * @return
	 */
	public double getLon() {
		return lon;
	}
	
	/**Creates a copy of trip ArrayList in order to stay enumerated.
	 * 
	 * @return
	 */
	public static ArrayList<TripPoint> getTrip() {
		ArrayList<TripPoint> copy = new ArrayList<>();	
		for (TripPoint tp : trip) {
			copy.add(tp);
		}
		return copy;
	}
	
	/**Uses the haversine formula to find the Distance between two TripPoints
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double haversineDistance(TripPoint a, TripPoint b) {
		double deltaLat = b.getLat() - a.getLat();
		double deltaLon = b.getLon() - a.getLon();
		//haversine formula to find havdegree
		double havTheta = hav(deltaLat) + Math.cos(Math.toRadians(a.getLat())) *
				Math.cos(Math.toRadians(b.getLat())) * hav(deltaLon);
		
		//Finding distance by multiplying the radius with the hav inverse of havTheta.
		return 2 * Math.asin(Math.sqrt(havTheta)) * 6371;
	}
	
	//Helper method to solve for the havsine of a value
	public static double hav(double toHav) {
		return Math.pow(Math.sin(Math.toRadians(toHav) / 2), 2);
	}
	
	/**Calculates the average speed by taking the distance between the two points
	 * (using the haversineDistance method) and dividing it by the time in hours.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double avgSpeed(TripPoint a, TripPoint b) {
		double hours = Math.abs(b.getTime() - a.getTime()) / 60.0;
		return haversineDistance(a, b) / hours;
	}
	
	/**Finds the last index of time in the trip ArrayList and converts it into hours 
	 * before returning the value.
	 * 
	 * @return
	 */
	public static double totalTime() {
		return trip.get(trip.size() - 1).getTime() / 60.0;
	}
	
	public static double totalDistance() {
		return 1.0;
	}
	
	/**Initializes trip ArrayList
	 * Reads each line of filename and converts the time, lat, and lon into a TripPoint object.
	 * Adds the created object to the trip ArrayList.
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFile(String filename) throws FileNotFoundException, IOException{
		trip = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String lineToRead = "";
			String[] temp = new String[3];
			while((lineToRead = br.readLine()) != null) {
				try {
					temp = lineToRead.split(",");
					trip.add(new TripPoint(Integer.parseInt(temp[0]),Double.parseDouble(temp[1]),
							Double.parseDouble(temp[2])));
				}
				catch (Exception e){
					continue;
				}
			}
			br.close();
		}
	}
	
}
