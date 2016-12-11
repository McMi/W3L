import inout.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse TerminplanerUI ermöglicht die Verwaltung eines Terminplaners. Es können Termine angelegt und eingesehen
 * werden. Die Ein- und Ausgabe erfolgt über die Konsole.
 *
 * Erstellt von M. Lintl am 25.10.2016
 */
public class TerminplanerUI {
    private static List<Termin> terminplaner = new ArrayList<>();

    public static void main (String args[]) {
        //Abbruchkriterium
        boolean ende = false;

        //Privaten Standardtermin anlegen und in den Terminkalender einfügen
        TerminplanerUI.hinzufuegenTermin(terminplaner, new Termin(LocalDate.of(2016,12,24), "Michael Lintl"));

        while (!ende) {
            //Ausgabe der wählbaren Funktionen auf der Konsole
            System.out.println("-----------------------------------------------");
            System.out.println("Bitte wählen Sie zwischen folgenden Optionen:");
            System.out.println("Neuer Termin: 1");
            System.out.println("Termine anzeigen: 2");
            System.out.println("Anwendung beenden: 3");
            System.out.println("-----------------------------------------------");

            //Einlesen der Benutzereingabe
            int wahl = Console.readInt();

            //Auswertung der Benutzereingabe
            switch (wahl) {
                case 1:
                    //Datum des Termins einlesen
                    System.out.println("Bitte ein Datum (TT.MM.YYYY) in der Zukunft eingeben.");
                    LocalDate datum = Console.readDate();

                    //Prüfung, ob das eingegebene Datum in der Zukunft liegt
                    LocalDate heute = LocalDate.now();
                    if(datum.isBefore(heute)){
                        System.out.println("Die Eingabe ist ungültig. Bitte Anwendungsfall erneut durchführen.");
                        break;
                    }

                    //Beschreibung des Termins einlesen
                    System.out.println("Bitte eine Termin-Beschreibung eingeben.");
                    String beschreibung = Console.readString();

                    //Termin in Terminkalender eintragen und Erfolgsmeldung
                    TerminplanerUI.hinzufuegenTermin(terminplaner, new Termin(datum, beschreibung));
                    TerminplanerUI.sortiereTerminplaner(terminplaner);
                    System.out.println("Termin wurde angelegt.");
                    break;
                case 2:
                    System.out.println("Vorhandene Termine:");
                    TerminplanerUI.anzeigenTerminplaner(terminplaner);
                    break;
                case 3:
                    ende = true;
                    System.out.println("Anwendung wird beendet.");
                    break;
                default:
                    System.out.println("Diese Wahl ist nicht zulässig. Bitte gültigen Wert auswählen.");
            }
            System.out.println("");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Sortiert den Terminkalender mit Hilfe einer "Sortierung durch Auswahl".
     */
    private static void sortiereTerminplaner(List<Termin> terminplaner){
        for(int i=0; i<terminplaner.size();i++){
            Termin fruehesterTermin = terminplaner.get(i);
            int positionMin = i;
            for(int j=i; j<terminplaner.size();j++){
                if(terminplaner.get(j).vergleicheMit(fruehesterTermin) < 0){
                    fruehesterTermin = terminplaner.get(j);
                    positionMin = j;
                }
            }
            Termin merke = terminplaner.get(i);
            terminplaner.set(i,terminplaner.get(positionMin));
            terminplaner.set(positionMin,merke);
        }
    }
    //-----------------------------------------------------------------------
    /**
     * Gibt alle Termine des Terminkalenders auf der Konsole aus.
     */
    private static void anzeigenTerminplaner(List<Termin> terminplaner){
        for(Termin termin : terminplaner){
            System.out.println(termin.getDatum() +": "+ termin.getBeschreibung());
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Fügt einen Termin zum Terminkalender hinzu.
     */
    private static void hinzufuegenTermin(List<Termin> terminplaner, Termin termin){
        terminplaner.add(termin);
    }
}
