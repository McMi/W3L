import java.util.ArrayList;
import java.util.List;

/**
 * Die abstrakte Klasse Fahrzeug dient als Oberklasse spezieller Fahrzeugtypen. Sie modelliert die Gemeinsamkeiten der
 * Maße und des Gewichts eines Fahrzeugs, sowie der Beladung (Fahrer, Beifahrer, Gepäck). Außerdem hält sie eine Variable
 * für die maximale Anzahl an Beifahrern vor, die von den speziellen Fahrzeugen gefüllt werden muss.
 * Bei der Erzeugung eines Fahrzeug-Objektes müssen der Fahrer, die Breite, die Länge und das Fahrzeuggewicht bekannt sein.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public abstract class Fahrzeug {
    private Person fahrer;
    private List<Person> beifahrer = new ArrayList<>();
    private Gepaeckstueck gepaeck;
    private int breite_cm;
    private int laenge_cm;
    private int gewicht_kg;
    private int maxAnzahlBeifahrer;

    Fahrzeug(Person fahrer, int breite_cm, int laenge_cm, int gewicht_kg) {
        this.fahrer = fahrer;
        this.breite_cm = breite_cm;
        this.laenge_cm = laenge_cm;
        this.gewicht_kg = gewicht_kg;
    }

    public Person getFahrer() {
        return this.fahrer;
    }

    public List<Person> getBeifahrer(){
        return this.beifahrer;
    }

    public Gepaeckstueck getGepaeck() {
        return this.gepaeck;
    }

    public double getBenoetigteFlaeche_sqm() {
        return this.breite_cm * this.laenge_cm * 1.5 / (100*100);
    }

    public int getGewicht_kg() {
        return this.gewicht_kg;
    }

    public int getMaxAnzahlBeifahrer(){
        return this.maxAnzahlBeifahrer;
    }

    protected void setMaxAnzahlBeifahrer(int maxAnzahlBeifahrer){
        this.maxAnzahlBeifahrer = maxAnzahlBeifahrer;
    }

    public void setGepaeck(Gepaeckstueck gepaeck){ this.gepaeck = gepaeck; }

    /*Berechnung des Gesamtgewichts des Fahrzeugs, das sich durch Addition aus dem Gewicht des leeren Fahrzeugs,
    dem Gewicht des Fahrers, dem Gewicht des (optionalen Gepäcks) und den Gewichten der (optionalen) Beifahrer ergibt.*/
    public int berechneGesamtgewicht_kg() {
        int gesamtgewicht_kg = 0;
        //Addition des Fahrzeuggewichts
        gesamtgewicht_kg += getGewicht_kg();
        //Addition des Fahrergewichts
        gesamtgewicht_kg += getFahrer().getGewicht_kg();
        //Addition der Gewichte der Beifahrer
        for(Person einBeifahrer : getBeifahrer()){
            gesamtgewicht_kg += einBeifahrer.getGewicht_kg();
        }
        //Addition des Gepäckgewichts
        if (getGepaeck() != null) gesamtgewicht_kg += getGepaeck().getGewicht_kg();
        return gesamtgewicht_kg;
    }

    public void addBeifahrer(Person einBeifahrer) throws NoSeatAvailableException {
        //Überprüfung, dass die maximale Beifahrerzahl nicht überschritten ist / wird und Hinzufügen eines neuen Beifahrers
        if(this.beifahrer.size() < this.maxAnzahlBeifahrer){
            this.beifahrer.add(einBeifahrer);
        }
        else{
            throw new NoSeatAvailableException("Es ist kein Platz mehr frei.");
        }
    }
}
