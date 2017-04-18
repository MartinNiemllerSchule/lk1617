package info.baethge.lk1617.wegfindung;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 30.03.17.
 */
public class Städte {
	private List<Stadt> städte;
	private List<Autobahn> autobahnen;

	public Städte() {
		städte = new ArrayList<>();
		autobahnen = new ArrayList<>();
	}

	/**
	 * Hinzufügen einer neuen Stadt
	 * TODO: es wird nicht gepüft, ob die Stadt schon vorhanden ist
	 *
	 * @param s - Instanz einer Stadt
	 */
	protected void add(Stadt s) {
		städte.add(s);
		städte.sort((s1, s2) -> s1.compareTo(s2)); // lambda-Ausdrücke funktionieren erst ab Java 8
	}

	/**
	 * ergibt die Position der Stadt in der Stadtliste (und damit eine Zugang zu den Stadt-Daten)
	 * @param name - Name der Stadt
	 * @return - Position der Stadt in städte
	 */
	protected int getStadtIdx(String name) {
		int idx = 0;
		while (idx < städte.size() && städte.get(idx).compareTo(name) < 0) idx ++;
		if (städte.get(idx).compareTo(name) == 0) {
			return idx;
		} else {
			return -1;
		}
	}

	/**
	 * Hinzufügen einer Autobahn -> die add-Methode ist überladen (siehe oben)
	 * @param vonS - Stadtname
	 * @param nachS - Satdtname
	 * @param entf - Entfernung in km
	 */
	protected void add(String vonS, String nachS, Integer entf) {
		int vonSIdx = getStadtIdx(vonS);
		int nachSIdx = getStadtIdx(nachS);
		if ( vonSIdx >= 0 && nachSIdx >= 0 && entf >= 0) {
			autobahnen.add(new Autobahn(städte.get(vonSIdx),städte.get(nachSIdx),entf));
		} else {
			System.out.printf("Autobahn %s - %s konnte nicht eingefügt werden %d - %d", vonS, nachS, vonSIdx, nachSIdx);
		}
	}

	/**
	 * Ausgabe aller Städte und der bestehenden Autobahnen im GraphViz-Format (zumindest leicht kopierbar)
	 * @return - Text aller Sädte und deren Autobahnen
	 */
	@Override
	public String toString() {
		String erg = "Städte\n";
		for (Stadt s: städte) erg += s.toString() + "\n";
		erg += "\n Autobahnen\n";
		for (Autobahn a: autobahnen) erg += a.toString();
		return erg;
	}

}
