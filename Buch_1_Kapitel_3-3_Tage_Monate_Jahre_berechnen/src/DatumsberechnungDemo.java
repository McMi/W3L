import inout.Console;

/**
 * Die Klasse DatumsberechnungDemo ermöglicht die Umrechnung einer eingegebenen
 * Anzahl an Tagen in Jahre, Monate und restliche Tage.
 *
 * @author M. Lintl
 * @version 1.0
 *
 * Erstellt durch Michael Lintl am 03.10.2016.
 */
public class DatumsberechnungDemo {
    public static void main(String args[]) {
        int eingabeTage, tage, monate, jahre;

        System.out.println("Geben Sie bitte eine Anzahl an Tagen ein:");
        eingabeTage = Console.readInt();

        jahre = eingabeTage / 365;
        monate = (eingabeTage - jahre * 365) / 30;
        tage = eingabeTage - jahre * 365 - monate * 30;

        System.out.println("Ihre Eingabe von " + eingabeTage + " Tagen entspricht " + jahre +
                " Jahr(en), " + monate + " Monat(en) und " + tage + " Tag(en).");
    }
}
