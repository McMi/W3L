/**
 * Created by mlintl on 05.10.2016.
 */
public class Collatz5 {
    public static void main(String args[]){
        int rest, laenge, max;
        int globalMax=0;

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

            if(max>globalMax){
                globalMax=max;
            }
        }
        //Bei jeder der ersten 40 Collatz-Folgen ist 1 das minimale Folgenglied, damit ist die Differenz
        //aus maximalem Folgenglied und beliebigem Folgenglied in jener Folge am größten, wo das global größte
        //Folgenglied auftritt. Dieses muss man sich merken, kann dann die größte Differenz aber leicht errechnen,
        //indem man den Wert 1 abzieht.
        System.out.println("Größte Differenz zwischen zwei Folgengliedern: "+ (globalMax-1));
    }
}
