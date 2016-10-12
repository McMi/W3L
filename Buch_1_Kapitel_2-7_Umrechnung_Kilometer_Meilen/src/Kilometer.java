import inout.Console;

/**
 * Programm zur Umrechnung von Kilometer in Meilen und umgekehrt. Ein- und Ausgabe erfolgt über die Konsole.
 *
 * Erstellt durch M. Lintl am 03.10.2016
 */
public class Kilometer {
    public static void main(String args[]) {
        double kilometer;
        double meilen;
        System.out.println("Geben Sie bitte die Kilometeranzahl ein:");
        kilometer = Console.readDoubleComma();
        //1 Meile entspricht 1.609344 Kilometer
        meilen = 1.0 / 1.609344 * kilometer;
        System.out.println(kilometer + " Kilometer ergeben " + meilen + " Meilen");
        System.out.println("Geben Sie bitte die Meilenanzahl ein:");
        meilen = Console.readDoubleComma();
        kilometer = 1.609344 * meilen;
        System.out.println(meilen + " Meilen ergeben " + kilometer + " Kilometer");
    }
}
