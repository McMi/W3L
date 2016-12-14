/**
 * Die Klasse Gepaeckstueck modelliert ein Gepäckstück, welches die Beladung eines Fahrzeuges darstellen kann.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class Gepaeckstueck {
    private int gewicht_kg;

    Gepaeckstueck(int gewicht_kg) {
        this.gewicht_kg = gewicht_kg;
    }

    public int getGewicht_kg() {
        return this.gewicht_kg;
    }
}
