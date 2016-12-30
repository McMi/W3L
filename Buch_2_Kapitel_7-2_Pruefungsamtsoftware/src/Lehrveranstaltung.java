/**
 * Die Klasse Lehrveranstaltung modelliert die Lehrveranstaltung eines Studiengangs inklusive der zugehörigen Credit Points (CPs).
 *
 * Erstellt von M. Lintl am 14.12.2016.
 */
public class Lehrveranstaltung implements CreditPointI {
    private String name;
    private int anzahlCPs;

    Lehrveranstaltung(String name, int anzahlCPs){
        this.name = name;
        this. anzahlCPs = anzahlCPs;
    }

    public String getName() { return this.name; }

    public int getAnzahlCPs(){ return this.anzahlCPs; }
}
