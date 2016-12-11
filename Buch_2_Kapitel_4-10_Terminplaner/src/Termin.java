import java.time.LocalDate;
import java.util.Date;

/**
 * Die Klasse Termin implementiert die Modellierung eines Kalendereintrags/Termins mit Datum und zugehöriger
 * Beschreibung. Außerdem ermöglicht sie den Vergleich zweier Termin-Objekte auf Basis des Datums beider Termine.
 *
 * Erstellt von M. Lintl am 25.11.2016
 */
public class Termin {
    private LocalDate datum;
    private String beschreibung;

    Termin(LocalDate datum, String beschreibung){
        this.datum = datum;
        this.beschreibung = beschreibung;
    }

    public LocalDate getDatum(){
        return this.datum;
    }

    public String getBeschreibung(){
        return this.beschreibung;
    }

    public void setDatum(LocalDate datum){
        this.datum = datum;
    }

    public void setBeschreibung(String beschreibung){
        this.beschreibung = beschreibung;
    }

    public int vergleicheMit(Termin termin){
        return this.getDatum().compareTo(termin.getDatum());
    }
}
