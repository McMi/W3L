/**
 * Die Klasse Bildverarbeitung2 ermöglicht die Bestimmung und Ausgabe des Medians eines ganzzahligen Feldes beliebiger
 * Länge. Bei einem Feld mit gerader Länge, wird der Durchschnitt der beiden mittleren Elemente als MEdian ausgegeben.
 *
 * Erstellt durch M. Lintl am 07.10.2016.
 */

public class Bildverarbeitung2 {
    public static void main (String args[]){
        int werte[] = {22,0,4,2,62,262,25,2,86,7,21,6,9,2,1,5,11,45};

        //Michael Lintl, ML=13,12
        //int werte[] = {33,9,2,6,5,8,2,4,8,43,58,34,2,5,2,13,12};

        int anzahlElemente = werte.length;
        double median = anzahlElemente%2==1?werte[(anzahlElemente-1)/2]:((double) werte[anzahlElemente/2-1]+werte[anzahlElemente/2])/2;

        System.out.println("Median: "+median);
    }
}
