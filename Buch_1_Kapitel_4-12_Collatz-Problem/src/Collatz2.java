import inout.Console;

/**
 * Die Klasse Collatz2 ermittelt die sogenannte Collatzfolge zu einem ganzzahligen Startwert, der über die Konsole
 * eingelesen wird. Zusätzlich wird die Länge der Collatzfolge (ohne Startwert) bestimmt und ausgegeben.
 * Die Ausgabe der Folge und ihrer Länge erfolgt auf der Konsole.
 *
 * Erstellt von M. Lintl am 05.10.2016
 */
public class Collatz2 {
    public static void main(String args[]){
        System.out.println("Ihre ganzzahlige Eingabe bitte:");
        int rest = Console.readInt();
        int laenge=0;

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
        }
        System.out.println(rest);
        System.out.println("Länge der Folge (ohne Startwert): " +laenge);
    }
}
