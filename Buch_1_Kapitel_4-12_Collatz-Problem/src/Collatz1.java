import inout.Console;

/**
 * Created by mlintl on 05.10.2016.
 */
public class Collatz1 {
    public static void main(String args[]){
        System.out.println("Ihre ganzzahlige Eingabe bitte:");
        int rest = inout.Console.readInt();

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
