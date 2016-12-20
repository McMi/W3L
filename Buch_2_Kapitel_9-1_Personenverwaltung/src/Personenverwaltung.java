import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Personenverwaltung speichert und verwaltet Patienten und Helfer.
 *
 * Erstellt von M. Lintl am 29.10.2016
 */
public class Personenverwaltung  {
    private List<Patient> patienten = new ArrayList<>();
    private List<Helfer> helfer = new ArrayList<>();
    private static Personenverwaltung personenverwaltungReferenz = null;

    private int anzahlHelfer = 0;
    private int anzahlPatienten = 0;

    private Personenverwaltung(){
        //Leerer Konstruktor zur Implementierung des Singleton-Patterns
    }

    //Statische Methode, die eine Objektreferenz auf ein Objekt der eigenen Klasse liefert (Teil des Singleton-Patterns)
    public static Personenverwaltung getPersonenverwaltungReferenz(){
        if(personenverwaltungReferenz == null){
            personenverwaltungReferenz = new Personenverwaltung();
        }
        return personenverwaltungReferenz;
    }

    public void addPatient(String name, String strasse, String ort, Pflegestufe pflegestufe){
        Patient einPatient = new Patient(anzahlPatienten+1, name, strasse, ort, pflegestufe);
        anzahlPatienten++;
        patienten.add(einPatient);
    }

    public void addHelfer(String name, String strasse, String ort, boolean hatAusbildung){
        Helfer einHelfer = new Helfer(anzahlHelfer+1, name, strasse, ort, hatAusbildung);
        anzahlHelfer++;
        helfer.add(einHelfer);
    }

    public List<Patient> getPatienten(){
        return patienten;
    }

    public List<Helfer> getHelfer(){
        return helfer;
    }
}
