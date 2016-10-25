/**
 * Die Klasse Kundenverwaltung ermöglicht zum Einen das (auf- und absteigende) Sortieren einer Menge von Kunden nach
 * den Kriterien Kundennummer, Name, Vorname und Ort mit Hilfe des Verfahrens "Sortieren durch Auswahl". Zum Anderen
 * kann nach einzelnen Kunden gesucht werden. Die Ergebnisse der Sortierung und der Suche werden auf der Konsole ausgegeben.
 *
 * Erstellt von M. Lintl am 25.10.2016
 */
public class Kundenverwaltung {
    public static void main(String args[]) {
        String[][] kundenUnsortiert = {{"1", "Lintl", "Michael", "München"}, {"2", "Balzert", "Helmut", "Dortmund"},
                {"3", "Meyer", "Hans", "Augsburg"}, {"4", "Bohn", "Helga", "Hamburg"}, {"5", "Dorakov", "Johanna", "Berlin"}};

        //Sortierung der Kundendaten nach verschiedenen Kriterien und Ausgabe des Ergebnisses
        for (int spalte = 0; spalte < kundenUnsortiert[0].length; spalte++) {
            String[][] kundenSortiert = sortiere(spalte, "aufsteigend", kundenUnsortiert);
            System.out.println("Ergebnis der Sortierung nach Spalte " + (spalte+1));
            System.out.println("Nr.\tName\tVorname\tOrt");
            for (String[] kunde : kundenSortiert) {
                System.out.println(kunde[0] + "\t" + kunde[1] + "\t" + kunde[2] + "\t" + kunde[3]);
            }
            System.out.println("");
        }

        //Suche nach eigenem Datansatz
        Kundenverwaltung.sucheKunde("Lintl", kundenUnsortiert);
    }

    /**
     * Sortiert ein 2-dim. Feld mit Kundendaten nach einer bestimmten Spalte in parametrisierbarer Sortierreihenfolge.
     *
     * @param spalte  Spalte (=2. Dimension des kunden-Feldes) nach der sortiert wird
     * @param sortierfolge  Parameter, ob aufsteigend oder absteigend sortiert wird.
     * @param kunden  2-dimensionales Feld mit Kundendaten
     */
    private static String[][] sortiere(int spalte, String sortierfolge, String[][] kunden) {
        switch (sortierfolge) {
            //Aufsteigende Sortierung durch Auswahl
            case "aufsteigend":
                for (int i = 0; i < kunden.length; i++) {
                    String minElement = kunden[i][spalte];
                    int posMinElement = i;
                    //Suche nach minimalem Element im unsortierten restlichen Feld
                    for (int j = i; j< kunden.length;j++) {
                        if(kunden[j][spalte].compareToIgnoreCase(minElement)<0){
                            minElement = kunden[j][spalte];
                            posMinElement = j;
                        }
                    }
                    //Tauschen des i-ten Eintrags mit dem minimalen unsortierten Element
                    String[] merkeKunde = kunden[i];
                    kunden[i] = kunden[posMinElement];
                    kunden[posMinElement] = merkeKunde;
                }
                break;
            case "absteigend":
                //Absteigende Sortierung durch Auswahl
                for (int i = 0; i < kunden.length; i++) {
                    String maxElement = kunden[i][spalte];
                    int posMaxElement = i;
                    //Suche nach maximalem Element im unsortierten restlichen Feld
                    for (int j = i; j< kunden.length;j++) {
                        if(kunden[j][spalte].compareToIgnoreCase(maxElement)>0){
                            maxElement = kunden[j][spalte];
                            posMaxElement = j;
                        }
                    }
                    //Tauschen des i-ten Eintrags mit dem maximalen unsortierten Element
                    String[] merkeKunde = kunden[i];
                    kunden[i] = kunden[posMaxElement];
                    kunden[posMaxElement] = merkeKunde;
                }
                break;
            default:
                System.out.println("Keine zulässige Sortierreihenfolge (aufsteigend/absteigend) gewählt." +
                        "\nEs wird mit dem unsortierten Kundenfeld fortgefahren...");
        }
        return kunden;
    }

    /**
     * Sucht in einem 2-dim. Feld mit Kundendaten nach einem Kunden-Datensatz, dessen Name gleich einem Suchstring ist
     * und gibt die weiteren Details zu den Suchtreffern aus.
     *
     * @param suchstring  Der String nach dem gesucht wird.
     * @param kunden  2-dimensionales Feld mit Kundendaten
     */
    private static void sucheKunde(String suchstring, String[][] kunden) {
        boolean gefunden = false;

        for (String[] kunde : kunden) {
            if (kunde[1].equals(suchstring)) {
                System.out.println("Details zum gesuchten Kunden "+suchstring+":");
                System.out.println("\tKundennummer: " + kunde[0]);
                System.out.println("\tName: " + kunde[1]);
                System.out.println("\tVorname: " + kunde[2]);
                System.out.println("\tOrt: " + kunde[3]);
                gefunden = true;
            }
        }
        if (!gefunden) System.out.println("Der Kunde "+suchstring+ " konnte nicht gefunden werden.");
    }
}


