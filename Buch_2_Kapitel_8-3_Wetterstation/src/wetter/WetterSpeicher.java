package wetter;

import java.io.*;
import java.util.*;

/**
 * Die Klasse WetterSpeicher stellt statische Funktionen zur Speicherung und zum Auslesen der Messwerte in / aus einer Datei
 * zur Verfügung. Die Klasse kann nicht instanziiert werden.
 *
 * Erstellt von M. Lintl am 26.12.2016.
 */
public class WetterSpeicher {
    
    private static final String DATEIPFAD = "messungen.txt";

    private WetterSpeicher(){
        //Leerer Konstruktor, um Instanziierung zu verhindern
    }
    
    public static void leseWerte(){
        try(FileReader fileReader = new FileReader(DATEIPFAD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);){
            //Zeilenweises Einlesen
            String zeile = bufferedReader.readLine();
            while(zeile != null){
                System.out.println(zeile);
                zeile = bufferedReader.readLine();
            }
        }
        catch(IOException exception){
            System.out.println("Fehler: " + exception.getMessage());
        }
    }
    
    public static void speichereWerte(List<Messwert> werte){
        
        try(FileWriter fileWriter = new FileWriter(DATEIPFAD);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);){
            //Zeilenweises Speichern jedes Messwertes
                for(Messwert wert: werte){
                    String neueZeile = wert.getTag() +"."+ wert.getMonat() +"."+ wert.getJahr() +", "+ Double.toString(wert.getTemperatur()) + ";\n";
                    bufferedWriter.write(neueZeile);
                }           
        }
        catch(IOException exception){
            System.out.println("Fehler: " + exception.getMessage());
        }
    }
}
