package info.baethge.lk1617.wegfindung;

/**
 * Datenspeicher für die Angaben zu einer Stadt
 *
 * Comparable wird verwendet, um Städte miteinander vergleichbar zu machen und die städte-Liste zu sortieren
 *
 */
public class Stadt implements Comparable<Stadt> {
	protected String name;
	protected float lattitude;
	protected float longitude;
	protected Float entfernung;
	protected Float luftlinie;
	protected Stadt vorgänger;

	/**
	 * Konstruktor, erwartet die Eingaben als Text: Länge und Breite in der Form xx°xx'
	 *
	 * @param name - Name der Stadt
	 * @param lat  - geografische Breite
	 * @param lon  - geografische Länge
	 */
	public Stadt(String name, String lat, String lon) {
		this.name = name;
		lattitude = getKoordinate(lat);
		longitude = getKoordinate(lon);
		entfernung = Float.MAX_VALUE;
		luftlinie = Float.MAX_VALUE;
		vorgänger = null;
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

	protected int istKleiner(Stadt stadt) {
		Float schätzung = entfernung + luftlinie;
		return schätzung.compareTo(stadt.entfernung + stadt.luftlinie);
	}

	@Override
	public int compareTo(Stadt s) {
		return name.compareTo(s.name);
	}
	@Override
	public String toString() {
		return String.format("%s: (%f|%f)", name, lattitude, longitude);
	}
}