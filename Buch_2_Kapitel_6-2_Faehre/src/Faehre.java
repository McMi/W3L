import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Fahre modelliert eine Fähre inklusive ihrer Eigenschaften wie maximales Nutzgewicht und maximale Nutzfläche.
 * Desweiteren hält sie verschiedene Variablen für die Speicherung des aktuellen und durchschnittlichen Beladungsstatus.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class Faehre {
    private int maximalesNutzgewicht_kg;
    private int maximalesNutzflaeche_sqm;

    private int aktuellesNutzgewicht_kg;
    private double aktuelleNutzflaeche_sqm;

    private double durchschnittlichesNutzgewicht_kg;
    private double durchschnittlicheNutzflaeche_sqm;

    private int anzahlAufgeladeneFahrzeuge;
    private int prognoseAnzahlFahrzeuge;

    private List<Fahrzeug> aufgeladeneFahrzeuge;

    Faehre(int maximalesNutzgewicht_kg, int maximalesNutzflaeche_sqm) {
        this.maximalesNutzgewicht_kg = maximalesNutzgewicht_kg;
        this.maximalesNutzflaeche_sqm = maximalesNutzflaeche_sqm;
        this.aufgeladeneFahrzeuge = new ArrayList<>();
    }

    public int getAktuellesNutzgewicht_kg() {
        return this.aktuellesNutzgewicht_kg;
    }

    public double getAktuelleNutzflaeche_sqm() {
        return this.aktuelleNutzflaeche_sqm;
    }

    public double getDurchschnittlichesNutzgewicht_kg(){ return this.durchschnittlichesNutzgewicht_kg; }

    public double getDurchschnittlicheNutzflaeche_sqm() {
        return this.durchschnittlicheNutzflaeche_sqm;
    }

    public int getPrognoseAnzahlFahrzeuge() {
        return this.prognoseAnzahlFahrzeuge;
    }

    public int getAnzahlAufgeladeneLKW() {
        int anzahlAufgeladeneLKW = 0;
        for(Fahrzeug fahrzeug : aufgeladeneFahrzeuge){
            if(fahrzeug != null && fahrzeug instanceof LKW) anzahlAufgeladeneLKW++;
        }
        return anzahlAufgeladeneLKW;
    }

    public int getAnzahlAufgeladenePKW() {
        int anzahlAufgeladenePKW = 0;
        for(Fahrzeug fahrzeug : aufgeladeneFahrzeuge){
            if(fahrzeug != null && fahrzeug instanceof PKW) anzahlAufgeladenePKW++;
        }
        return anzahlAufgeladenePKW;
    }

    public int getAnzahlAufgeladeneMotorraeder() {
        int anzahlAufgeladeneMotorraeder = 0;
        for(Fahrzeug fahrzeug : aufgeladeneFahrzeuge){
            if(fahrzeug != null && fahrzeug instanceof Motorrad) anzahlAufgeladeneMotorraeder++;
        }
        return anzahlAufgeladeneMotorraeder;
    }

    public int getAnzahlAufgeladeneFahrraeder() {
        int anzahlAufgeladeneFahrraeder = 0;
        for(Fahrzeug fahrzeug : aufgeladeneFahrzeuge){
            if(fahrzeug != null && fahrzeug instanceof Fahrrad) anzahlAufgeladeneFahrraeder++;
        }
        return anzahlAufgeladeneFahrraeder;
    }

    private void aktualisiereDurchschnittlicheNutzflaeche(){
        this.durchschnittlicheNutzflaeche_sqm = this.aktuelleNutzflaeche_sqm / this.anzahlAufgeladeneFahrzeuge;
    }

    private void aktualisiereDurchschnittlichesNutzgewicht(){
        this.durchschnittlichesNutzgewicht_kg = (double) this.aktuellesNutzgewicht_kg / this.anzahlAufgeladeneFahrzeuge;
    }

    private void aktualisierePrognoseAnzahlFahrzeuge() {
        int flaechenprognoseAnzahlFahrzeuge = (int) ((this.maximalesNutzflaeche_sqm - this.aktuelleNutzflaeche_sqm) / this.durchschnittlicheNutzflaeche_sqm);
        int gewichtsprognoseAnzahlFahrzeuge = (int) ((this.maximalesNutzgewicht_kg - this.aktuellesNutzgewicht_kg) / this.durchschnittlichesNutzgewicht_kg);
        this.prognoseAnzahlFahrzeuge = Math.min(flaechenprognoseAnzahlFahrzeuge, gewichtsprognoseAnzahlFahrzeuge);
    }

    private boolean fahrzeugZulaessig(Fahrzeug fahrzeug) {
        boolean gewichtZulaessig = fahrzeug.berechneGesamtgewicht_kg() <= this.maximalesNutzgewicht_kg - this.aktuellesNutzgewicht_kg;
        boolean flaecheZulaessig = fahrzeug.getBenoetigteFlaeche_sqm() <= this.maximalesNutzflaeche_sqm - this.aktuelleNutzflaeche_sqm;
        return gewichtZulaessig && flaecheZulaessig;
    }

    public void fahrzeugAufladen(Fahrzeug fahrzeug) throws VehicleNotValidException {
        if (fahrzeugZulaessig(fahrzeug)) {
            this.aufgeladeneFahrzeuge.add(fahrzeug);

            //Update der Anzahl an aufgeladenen Fahrzeugen
            this.anzahlAufgeladeneFahrzeuge++;

            //Update aktuelle Nutzfläche, aktuelles Nutzgewicht
            this.aktuelleNutzflaeche_sqm += fahrzeug.getBenoetigteFlaeche_sqm();
            this.aktuellesNutzgewicht_kg += fahrzeug.berechneGesamtgewicht_kg();

            //Update durchschnittliche Nutzfläche, durchschnittliches Nutzgewicht
            aktualisiereDurchschnittlicheNutzflaeche();
            aktualisiereDurchschnittlichesNutzgewicht();

            //Update der Prognose
            aktualisierePrognoseAnzahlFahrzeuge();
        } else {
            throw new VehicleNotValidException("Das Fahrzeug passt nicht mehr auf die Fähre.");
        }
    }
}
