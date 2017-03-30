package info.baethge.lk1617.wegfindung;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        (new Main()).run();
    }

    private void run() {
    	init();
		}

		private void init() {
			// alle info.baethge.lk1617.wegfindung.Städte eintragen
			Städte städte = new Städte();
			städte.add(new Stadt("FAM","50°7’","8°41’"));
			städte.add(new Stadt("Kassel","51°19’","9°30’"));
			städte.add(new Stadt("Münster","51°58’","7°38’"));
			städte.add(new Stadt("Köln","50°56’","6°57’"));
			städte.add(new Stadt("Trier","49°46’","6°39’"));
			städte.add(new Stadt("Flensburg","54°47’","9°26’"));
			städte.add(new Stadt("Bremen","53°5’","8°48’"));
			städte.add(new Stadt("Hamburg","53°33’","10°0’"));
			städte.add(new Stadt("Kiel","54°20’","10°8’"));
			städte.add(new Stadt("Schwerin", "53°38’","11°25’"));
			städte.add(new Stadt("Mannheim","49°29’","8°28’"));
			städte.add(new Stadt("Nürnberg","49°27’","11°5’"));
			städte.add(new Stadt("Stuttgart","48°47’","9°11’"));
			städte.add(new Stadt("München","48°8’","11°35’"));
			städte.add(new Stadt("Greifswald","54°6’","13°23’"));
			städte.add(new Stadt("Berlin","52°20’","12°22’"));
			städte.add(new Stadt("Leipzig","51°20’","12°22’"));
			städte.add(new Stadt("Dresden","51°3’","13°44’"));
			städte.add(new Stadt("Eisenach","50°58’","10°19’"));

			städte.add("FAM","Kassel",199);
			städte.add("Kassel","Münster",201);
			städte.add("Kassel","Köln",243);
			städte.add("Köln","FAM",190);
			städte.add("Trier","FAM",191);
			städte.add("Trier","Köln",174);
			städte.add("Köln","Münster",162);
			städte.add("Münster","Bremen",172);
			städte.add("Greifswald","Berlin",221);
			städte.add("Berlin","Leipzig",190);
			städte.add("Berlin","Kassel",380);
			städte.add("Kassel","Leipzig",254);
			städte.add("Leipzig","Dresden",120);
			städte.add("Leipzig","Eisenach",204);
			städte.add("Dresden","Eisenach",273);
			städte.add("Eisenach","Kassel",129);
			städte.add("Eisenach","Köln",207);
			städte.add("Eisenach","Trier",365);
			städte.add("FAM","Mannheim",84);
			städte.add("FAM","Nürnberg",226);
			städte.add("Mannheim","Stuttgart",132);
			städte.add("Mannheim","Nürnberg",237);
			städte.add("Nürnberg","Stuttgart",206);
			städte.add("Nürnberg","München",166);
			städte.add("Stuttgart","München",233);
			städte.add("Eisenach","Nürnberg",237);
			städte.add("Flensburg","Kiel",91);
			städte.add("Flensburg","Bremen",274);
			städte.add("Kiel","Schwerin",150);
			städte.add("Kiel","Hamburg",98);
			städte.add("Kiel","Bremen",211);
			städte.add("Hamburg","Schwerin",112);
			städte.add("Hamburg","Bremen",126);
			städte.add("Leipzig","Nürnberg",288);
			städte.add("Dresden","Nürnberg",357);
			städte.add("Berlin","Hamburg",288);
			städte.add("Hamburg","Kassel",310);
			städte.add("Berlin","Schwerin",213);
			städte.add("Schwerin","Greifswald",174);
		}
}
