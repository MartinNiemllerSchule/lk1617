package info.baethge.lk1617.wegfindung;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by frank on 30.03.17.
 */
public class Stadt implements Comparable<Stadt> {
	protected String name;
	private float lattitude;
	private float longitude;

	public Stadt(String name, String lat, String lon) {
		this.name = name;
		lattitude = getKoordinate(lat);
		longitude = getKoordinate(lon);
	}

	/**
	 * Koordinaten umwandeln von 50°7' nach float
	 * @param latlon - Eingabe im Format \d*°\d*'
	 * @return - Ausgabe als float
	 */
	private float getKoordinate(String latlon) {
		String[] werte = latlon.split("°");
		werte[1] = werte[1].substring(0,werte[1].length()-1);
		return (float) (Integer.parseInt(werte[0])) + (float)(Integer.parseInt(werte[1]))/60.0F;
	}

	/**
	 * ist stadt diese Stadt?
	 * @param stadt - Stadtname (Groß- und Kleinschreibung wichtig)
	 * @return
	 */
	protected int istStadt(String stadt) {
		return stadt.compareTo(name);
	}
	protected int compareTo(String name) {
		return this.name.compareTo(name);
	}

	@Override
	public int compareTo(Stadt s) {
		return name.compareTo(s.name);
	}
	@Override
	public String toString() {
		return String.format("%s: (%f,%f)", name, lattitude, longitude);
	}
}

/**
 *
 Autobahnen


 Daten aufbereiten
 FAM: 50°7’, 8°41’
 Kassel: 51°19’, 9°30’
 Münster: 51°58’, 7°38’
 Köln: 50°56’, 6°57’
 Trier: 49°46’, 6°39’

 https://www.kompf.de/gps/distcalc.html

 */