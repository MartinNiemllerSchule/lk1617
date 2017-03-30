package info.baethge.lk1617.wegfindung;

/**
 * Created by frank on 30.03.17.
 */
public class Autobahn {
	private Stadt von;
	private Stadt nach;
	private Integer entfernung;

	public Autobahn(Stadt vonS, Stadt nachS, Integer entf) {
		von = vonS;
		nachS = nachS;
		entfernung = entf;
	}
	@Override
	public String toString() {
		return String.format("$s - $s: %d\n", von, nach, entfernung);
	}
}
