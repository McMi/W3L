package wetter;

import java.util.*;

/**
 * Die Klasse WetterContainer modelliert einen Container zur Verwaltung der Messwerte einer Wetterstation. Für die
 * Umsetzung wird das Singleton-Pattern verwendet.
 *
 * Erstellt von M. Lintl am 26.12.2016.
 */
public class WetterContainer {
    
    private List<Messwert> werte = new ArrayList<>();
    private static WetterContainer wetterContainerReferenz = null;
    
    //statische Methode, welche im Sinne des Singleton-Patterns
    //einen bereits bestehenden oder neuen WetterContainer zurückliefert
    public static WetterContainer getWetterContainerReferenz(){
        if(wetterContainerReferenz == null){
            wetterContainerReferenz = new WetterContainer();
        }
        return wetterContainerReferenz;
    }
    
    private WetterContainer(){
        //Leerer privater Konstruktor als Teil der Umsetzung des
        //Singleton-Patterns
    }
            
    public void addMesswert(Messwert messwert){
        werte.add(messwert);
    }
    
    public List<Messwert> getMesswerte(){
        return this.werte;
    }
    
}
