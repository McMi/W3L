/**
 * Die Klasse SymbolrätselDemo ermittelt alle Lösungen für das Symbolrätsel HES + THE = BEST, in welchem
 * jeder Buchstabe für eine Ziffer steht (verschiedene Buchstaben dürfen dabei nicht für die gleiche Zahl stehen).
 * Führende Nullen sind nicht erlaubt, d.h. H*T*B != 0. Die Lösungen werden auf der Konsole ausgegeben.
 *
 * Erstellt von M. Lintl am 05.10.2016
 */
public class SymbolraetselDemo {

    public static void main(String args[]) {
        int h, e, s, t, b;
        int hes, the, best;
        int anzahlLoesungen=0;
        boolean cond;

        for (h = 1; h <= 9; h++) {
            for (e = 0; e <= 9; e++) {
                for (s = 0; s <= 9; s++) {
                    for (t = 1; t <= 9; t++) {
                        for (b = 1; b <= 1; b++) {
                            //Bedingung, dass zwei unterschiedliche Buchstaben nicht dieselbe Zahl repräsentieren
                            cond = (h != e) && (h != s) && (h != t) && (e != s) && (e != t) && (s != t) && (b != h) &&
                                    (b != e) && (b != s) && (b != t);

                            //Erzeugung der konkreten Zahlen
                            hes = 100 * h + 10 * e + s;
                            the = 100 * t + 10 * h + e;
                            best = 1000 * b + 100 * e + 10 * s + t;

                            //Überprüfung, ob die aktuellen Zahlen eine Lösung sind (wenn ja, Ausgabe auf Konsole)
                            if ((hes + the == best) && (cond == true)) {
                                anzahlLoesungen++;
                                System.out.println(anzahlLoesungen+". Lösung:");
                                System.out.println("      "+h+" "+e+" "+s);
                                System.out.println("      + "+t+" "+h+" "+e);
                                System.out.println("    -------");
                                System.out.println("    "+b+" "+e+" "+s+" "+t);
                            }
                        }
                    }
                }
            }
        }
    }
}
