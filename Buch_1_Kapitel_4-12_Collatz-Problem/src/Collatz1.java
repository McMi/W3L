import inout.Console;

/**
 * Die Klasse Collatz1 ermittelt die sogenannte Collatzfolge zu einem ganzzahligen Startwert, der über die Konsole
 * eingelesen wird. Die Ausgabe der ermittelten Folge erfolgt ebenfalls auf der Konsole.
 *
 * Erstellt von M. Lintl am 05.10.2016
 */
public class Collatz1 {
    public static void main(String args[]){
        System.out.println("Ihre ganzzahlige Eingabe bitte:");
        int rest = Console.readInt();

        while(rest != 1){
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
        System.out.print(rest);
    }
}
