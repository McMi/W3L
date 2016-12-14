/**
 * Die Klasse LKW modelliert einen LKW und die zugehörige maximale Beifahrerzahl.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class LKW extends Fahrzeug {
    private static final int maxAnzahlBeifahrerLKW = 2;

    LKW(Person fahrer, int breite_cm, int laenge_cm, int gewicht_kg){
        super(fahrer, breite_cm, laenge_cm, gewicht_kg);
        super.setMaxAnzahlBeifahrer(maxAnzahlBeifahrerLKW);
    }
}