package info.baethge.lk1617.wegfindung;

/**
 * Created by frank on 30.03.17.
 */
public class Autobahn {
	private Stadt von;
	private Stadt nach;
	private Integer entfernung;

	protected Autobahn(Stadt vonS, Stadt nachS, Integer entf) {
		von = vonS;
		nach = nachS;
		entfernung = entf;
	}
	@Override
	public String toString() {
		return String.format("\t%s -- %s [ label = %d ];\n", von.name, nach.name, entfernung);
	}
}
