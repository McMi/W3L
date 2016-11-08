import java.util.ArrayList;

/**
 * Die Klasse TelefonUI verwaltet Nutzer und ihre Zuordnung zu Endgeräten. Diese Daten werden auf der Konsole ausgegeben.
 *
 * Erstellt von M. Lintl am 07.11.2016
 */
public class TelefonUI {
    public static void main(String[] args){
        ArrayList<Nutzer> nutzer = new ArrayList<>();

        //Erzeugung und Hinzufügen des ersten Nutzers (Erzeugung und Hinzufügen der Endgeräte zum Nutzer in einem
        // Schritt, Ergänzung der Nummer eines Endgeräts in einem nächsten Schritt
        Nutzer ersterNutzer = new Nutzer("Michael Lintl");
        Telefon[] michaelsEndgeraete = {new Telefon(1,"12345"), new Telefon(3)};
        michaelsEndgeraete[1].setNummer("48523");
        ersterNutzer.setEndgeraete(michaelsEndgeraete);
        nutzer.add(ersterNutzer);

        //Erzeugung und Hinzufügen des ersten Nutzers (erst Erzeugung der Endgeräte, dann Erzeugung des Nutzer inklusive
        //seiner Endgeräte)
        Telefon[] neueEndgeraete = new Telefon[2];
        neueEndgeraete[0] = new Telefon(2);
        Nutzer zweiterNutzer = new Nutzer("Martina Mustermann",neueEndgeraete);
        nutzer.add(zweiterNutzer);

        //Ausgabe der Nutzer und ihrer Endgeräte auf der Konsole
        for(int i=0; i<nutzer.size(); i++){
            Nutzer einNutzer = nutzer.get(i);
            System.out.println("Nutzer " + einNutzer.getName());

            for(int j=0; j<einNutzer.getEndgeraete().length; j++){
                if(einNutzer.getEndgeraete()[j] != null){
                    Telefon einEndgerät = einNutzer.getEndgeraete()[j];
                    System.out.print("Endgerät "+(j+1)+": ");
                    System.out.print("  Typ " + einEndgerät.getTyp());
                    if (!einEndgerät.getNummer().equals("")) System.out.print(",  Nummer " + einEndgerät.getNummer());
                    System.out.println("");
                }
            }
            System.out.println("");
        }

    }
}
