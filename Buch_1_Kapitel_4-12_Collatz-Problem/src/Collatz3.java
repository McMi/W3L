import inout.Console;

/**
 * Created by mlintl on 05.10.2016.
 */
public class Collatz3 {
    public static void main(String args[]){
        System.out.println("Ihre ganzzahlige Eingabe bitte:");
        int rest = Console.readInt();
        int laenge=0;
        int max = rest;

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
    }
}
