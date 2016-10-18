/**
 * Die Klasse Collatz4 ermittelt die sogenannten Collatzfolgen für die ersten 40 positiven Zahlen als Startwerte.
 * Zusätzlich wird zu jeder Folge ihre Länge(ohne Startwert) und ihr größtes Folgenglied bestimmt und ausgegeben.
 * Alle Ausgaben erfolgen auf der Konsole.
 *
 * Erstellt von M. Lintl am 05.10.2016
 */
public class Collatz4 {
    public static void main(String args[]){
        int rest, laenge, max;

        for(int zaehler = 1;zaehler<=40;zaehler++){
            rest = zaehler;
            max = rest;
            laenge=0;

            System.out.println("Folge mit Startwert " +zaehler);

            while(rest != 1){
                laenge++;
                System.out.print(rest + " -> ");

                //Rest ist gerade
                if(rest%2 == 0){
                    rest = rest/2;
                }
                //Rest ist ungerade
                else {
                    rest = 3 * rest + 1;
                }

                if(rest>max) max=rest;
            }
            System.out.println(rest);
            System.out.println("Länge der Folge (ohne Startwert): " +laenge);
            System.out.println("Größtes Folgenglied: " +max);
            System.out.println("");
        }
    }
}
