import inout.Console;

/**
 * Die Klasse MahnwesenDemo ermöglicht dem Benutzer die Auswahl eines von drei vorgegebenen
 * Mahntexten, welcher im Anschluss ausgegeben wird. Die Ein- und Ausgabe erfolgt über die Konsole.
 *
 * Erstellt von M. Lintl am 04.10.2016.
 */

public class MahnwesenDemo {
    public static void main (String args[]){
        String mahntext1 = "Dies ist die erste Mahnung. Bitte Rechnung bezahlen.";
        String mahntext2 = "Dies ist die zweite Mahnung. Bitte Rechnung schnellstmöglich bezahlen.";
        String mahntext3 = "Dies ist die dritte Mahnung. Bitte Rechnung sofort bezahlen.";

        System.out.println("Auswahl von Mahntexten");
        druckeTrennlinie();
        System.out.println("Mahntext 1: " + mahntext1);
        System.out.println("Mahntext 2: " + mahntext2);
        System.out.println("Mahntext 3: " + mahntext3);
        System.out.println("Bitte wählen Sie:");
        druckeTrennlinie();

        int wahl = Console.readInt();
        String ausgabetext;

        switch(wahl){
            case 1: ausgabetext = mahntext1; break;
            case 2: ausgabetext = mahntext2; break;
            case 3: ausgabetext = mahntext3; break;
            default: ausgabetext = "Dieser Mahntext ist nicht vorhanden.";
        }
        System.out.println(ausgabetext);
    }

    public static void druckeTrennlinie(){
        System.out.println("______________________ ");
    }
}
