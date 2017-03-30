/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wegfindung_dijkstra;

import java.util.*;

/**
 * @author Frank Baethge
 */
public class Wegfindung_Dijkstra {
	// Graph initialisieren
	char[] knoten = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
	int[][] kanten = {
			{0, 2, 0, 0, 0, 9, 15, 0, 0}, //A
			{2, 0, 4, 0, 0, 0, 6, 0, 0},  //B
			{0, 4, 0, 2, 0, 0, 0, 0, 15}, //C
			{0, 0, 2, 0, 1, 0, 0, 0, 1},  //D
			{0, 0, 0, 1, 0, 6, 0, 3, 0},  //E
			{9, 0, 0, 0, 6, 0, 0, 11, 0}, //F
			{15, 6, 0, 0, 0, 0, 0, 15, 2},//G
			{0, 0, 0, 0, 3, 11, 15, 0, 4},//H
			{0, 0, 15, 1, 0, 0, 2, 4, 0}  //I
	};

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int[][] kürzesteWegeVonA = (new Wegfindung_Dijkstra()).kurzerWeg('B');
		for(int[] eintrag: kürzesteWegeVonA) System.out.println("["+eintrag[0]+","+eintrag[1]+"]");
	}

	public int[][] kurzerWeg(char vonKnoten) {
		// Vorbelegung des Ergebnisses
		int[][] ergebnis = new int[knoten.length][2];
		for (int i = 0; i < ergebnis.length; i++) {
			ergebnis[i][0] = -1;
			ergebnis[i][1] = Integer.MAX_VALUE;
		}
		// Liste der unbearbeiteten Nachbar-Knoten
		Set<Integer> unbearbeiteteKnoten = new HashSet<>();
		Set<Integer> bearbeiteteKnoten = new HashSet<>();

		// Suche vonKnoten
		int vonKnotenIndex = 0;
		while (knoten[vonKnotenIndex] != vonKnoten && vonKnotenIndex < knoten.length) {
			vonKnotenIndex++;
		}
		if (knoten[vonKnotenIndex] != vonKnoten) {
			return null; // Fehler diesen Knoten gibt es gar nicht
		}
		// markiere vonKnoten als Startpunkt
		ergebnis[vonKnotenIndex][0] = vonKnotenIndex;
		ergebnis[vonKnotenIndex][1] = 0;
		// nimm vonKnoten in die unbearbeiteten KnotenListe auf
		unbearbeiteteKnoten.add(vonKnotenIndex);

		// Dijkstra: markiere solange etwas zu markieren ist

		while (!unbearbeiteteKnoten.isEmpty()) {
			//  beginne immer beim Knoten mit der kleinsten Bewertung
			int minimum = Integer.MAX_VALUE;
			Integer nächsterKnotenIndex = -1;
			for (int i: unbearbeiteteKnoten) { // nur in noch offenen Knoten suchen
				if (ergebnis[i][1] < minimum) {
					nächsterKnotenIndex = i;
					minimum = ergebnis[i][1];
				}
			}
			// entferne den nächsten Knoten
			unbearbeiteteKnoten.remove(nächsterKnotenIndex);
			bearbeiteteKnoten.add(nächsterKnotenIndex);

			// für alle Nachbarknoten
			int[] aktuelleKanten = kanten[nächsterKnotenIndex];
			for (int i = 0; i < aktuelleKanten.length; i++) {
				if (0 < aktuelleKanten[i]) {
					int länge = aktuelleKanten[i] + ergebnis[nächsterKnotenIndex][1];
					if (länge < ergebnis[i][1]) {
						ergebnis[i][0] = nächsterKnotenIndex;
						ergebnis[i][1] = länge;
					}
					// füge neuen nachbarKnoten hinzu, falls noch unbearbeitet
					if (!bearbeiteteKnoten.contains(i)) unbearbeiteteKnoten.add(i);
				}
			}
		}

		return ergebnis;
	}
}
