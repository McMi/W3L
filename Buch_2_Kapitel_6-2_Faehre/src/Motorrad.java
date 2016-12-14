/**
 * Die Klasse Motorrad modelliert ein Motorrad und die zugehörige maximale Beifahrerzahl.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class Motorrad extends Fahrzeug {
    private static final int maxAnzahlBeifahrerMotorrad = 1;

    public Motorrad(Person fahrer, int breite_cm, int laenge_cm, int gewicht_kg){
        super(fahrer, breite_cm, laenge_cm, gewicht_kg);
        super.setMaxAnzahlBeifahrer(maxAnzahlBeifahrerMotorrad);
    }
}
