/**
 * Die Klasse Helfer modelliert einen freiwilligen Helfer mit seinen Eigenschaften als Person (z.B. Name) sowie
 * seinen helfertypischen Eigenschaften wie z.B. seiner Pflegeausbildung.
 *
 * Erstellt von M. Lintl am 29.10.2016
 */
public class Helfer extends Person {
    private boolean hatAusbildung;
    private Patient patient;

    public Helfer(int nummer, String name, String strasse, String ort, boolean hatAusbildung){
        super(nummer, name, strasse, ort);
        this.hatAusbildung = hatAusbildung;
    }

    public boolean getHatAusbildung(){
        return this.hatAusbildung;
    }

    public Person getPatient(){
        return this.patient;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public boolean hatPatient(){ return this.patient != null; }
}
