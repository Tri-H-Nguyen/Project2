
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	public static double haversinDistance(TripPoint a, TripPoint b) {

	}
	
	public static double avgSpeed(TripPoint a, TripPoint b) {

	}
	
	public static double totalTime() {

	}
	
	public static double totalDistance() {

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
