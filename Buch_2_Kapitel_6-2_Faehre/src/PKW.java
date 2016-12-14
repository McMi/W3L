/**
 * Die Klasse PKW modelliert einen PKW und die zugehörige maximale Beifahrerzahl.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class PKW extends Fahrzeug {
    private static final int maxAnzahlBeifahrerPKW = 3;

    PKW(Person fahrer, int breite_cm, int laenge_cm, int gewicht_kg) {
        super(fahrer, breite_cm, laenge_cm, gewicht_kg);
        super.setMaxAnzahlBeifahrer(maxAnzahlBeifahrerPKW);
    }
}
