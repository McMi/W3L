package wetter;

/**
 * Die Klasse WetterUI simuliert eine Wetterstation, die mehrere Messwerte misst und deren Verarbeitung anstößt.
 *
 * Erstellt von M. Lintl am 26.12.2016.
 */

public class WetterUI {

    public static void main(String[] args) {
        WetterContainer wetterContainer = WetterContainer.getWetterContainerReferenz();
        
        Messwert wert1 = new Messwert(14,12,2012,12.0);
        wetterContainer.addMesswert(wert1);
        Messwert wert2 = new Messwert(15,2,2013,13.0);
        wetterContainer.addMesswert(wert2);
        Messwert wert3 = new Messwert(16,2,2013,13.4);
        wetterContainer.addMesswert(wert3);
        Messwert wert4 = new Messwert(17,2,2013,14.5);
        wetterContainer.addMesswert(wert4);
        
        WetterSpeicher.speichereWerte(wetterContainer.getMesswerte());
        WetterSpeicher.leseWerte();
    }
    
}
