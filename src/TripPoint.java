
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
	
	public static double avgSpeed(Trippoint a, TripPoint b) {
		
	}
	
	public static double totalTime() {
		
	}
	
	public static double totalDistance() {
		
	}
	
	public static void readFile(String filename) {
		
	}
}
