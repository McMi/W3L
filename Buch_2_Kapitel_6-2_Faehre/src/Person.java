/**
 * Die Klasse Person modelliert eine Person, die als Fahrer und Beifahrer in Fahrzeugen fungieren kann (inkl. ihrem Gewicht).
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class Person {
    private int gewicht_kg;

    Person(int gewicht_kg) {
        this.gewicht_kg = gewicht_kg;
    }

    public int getGewicht_kg() {
        return this.gewicht_kg;
    }
}
