package info.baethge.lk1617.wegfindung;

/**
 * Datenspeicher für die Verbindung zweier Städte über eine Autobahn
 */
public class Autobahn {
	private Stadt von;
	private Stadt nach;
	private Integer entfernung;

	/**
	 * Konstruktor
	 * prinzipiell wird hier mit einem ungerichteten Graphen gearbeitet (Autobahnen sind keine Einbahnstraßen)
	 *
	 * @param vonS  - Instanz einer Stadt
	 * @param nachS - Instanz einer Stadt
	 * @param entf  - Entfernung in km
	 */
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
