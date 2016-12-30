package wetter;

/**
 * Die Klasse Messwert modelliert den Temperatur-Messwert einer Wetterstation an einem bestimmten Datum.
 *
 * Erstellt von M. Lintl am 26.12.2016.
 */

public class Messwert {
    
    private double temperatur;
    private int tag, monat, jahr;
    
    public Messwert(int tag, int monat, int jahr, double temperatur){
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
        this.temperatur = temperatur;
    }
    
    public int getTag(){
        return this.tag;
    }
    
    public int getMonat(){
        return this.monat;
    }
    
    public int getJahr(){
        return this.jahr;
    }
    
    public double getTemperatur(){
        return this.temperatur;
    }
}
