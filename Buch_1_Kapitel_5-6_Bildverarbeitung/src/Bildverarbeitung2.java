/**
 * Die Klasse Bildverarbeitung2 ermöglicht die Bestimmung und Ausgabe des Medians eines ganzzahligen Feldes beliebiger
 * Länge. Bei einem Feld mit gerader Länge, wird der Durchschnitt der beiden mittleren Elemente als Median ausgegeben.
 *
 * Erstellt durch M. Lintl am 07.10.2016.
 */

public class Bildverarbeitung2 {
    public static void main (String args[]){
        int werte[] = {22,0,4,2,62,262,25,2,86,7,21,6,9,2,1,5,11,45};

        //Michael Lintl, ML=13,12
        //int werte[] = {33,9,2,6,5,8,2,4,8,43,58,34,2,5,2,13,12};

        //Ausgabe des unsortierten Feldes
        System.out.print("Unsortiertes Feld: ");
        for(int element : werte) System.out.print(element+" ");
        System.out.println("");

        //Sortieren durch Auswahl
        int[] sortierteWerte = werte;
        for(int i=0;i<sortierteWerte.length;i++){
            int posMinimum = i, minimum = sortierteWerte[i];
            //Suchen des kleinsten Wertes
            for(int j=i;j<sortierteWerte.length;j++){
                if(sortierteWerte[j]<minimum){
                    posMinimum=j;
                    minimum = sortierteWerte[j];
                }
            }
            //Tauschen der Werte
            int merke = sortierteWerte[i];
            sortierteWerte[i]=sortierteWerte[posMinimum];
            sortierteWerte[posMinimum]=merke;
        }

        //Ausgabe des sortierten Feldes
        System.out.print("Sortiertes Feld: ");
        for(int element : sortierteWerte) System.out.print(element+" ");
        System.out.println("");

        //Ermittlung des Medians
        int anzahlElemente = sortierteWerte.length;
        double median = anzahlElemente%2==1?sortierteWerte[(anzahlElemente-1)/2]:((double) sortierteWerte[anzahlElemente/2-1]+sortierteWerte[anzahlElemente/2])/2;

        //Ausgabe des Median
        System.out.println("Median: "+median);
    }
}
