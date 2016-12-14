/**
 * Die Klasse Fahrrad modelliert ein Fahrrad und die zugehörige maximale Beifahrerzahl.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class Fahrrad extends Fahrzeug {
    private static final int maxAnzahlBeifahrerFahrrad = 0;

    public Fahrrad(Person fahrer, int breite_cm, int laenge_cm, int gewicht_kg){
        super(fahrer, breite_cm, laenge_cm, gewicht_kg);
        super.setMaxAnzahlBeifahrer(maxAnzahlBeifahrerFahrrad);
    }
}
