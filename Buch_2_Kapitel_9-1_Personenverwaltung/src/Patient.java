/**
 * Die Klasse Helfer modelliert einen pflegebedürftigen Patienten mit seinen Eigenschaften als Person (z.B. Name) sowie
 * seinen patiententypischen Eigenschaften wie z.B. seiner Pflegestufe.
 *
 * Erstellt von M. Lintl am 29.10.2016
 */
public class Patient extends Person {
    private Pflegestufe pflegestufe;
    private Helfer helfer;

    public Patient(int nummer, String name, String strasse, String ort, Pflegestufe pflegestufe){
        super(nummer, name, strasse, ort);
        this.pflegestufe = pflegestufe;
    }

    public void setHelfer(Helfer helfer){
        this.helfer = helfer;
    }

    public Helfer getHelfer(){
        return this.helfer;
    }

    public Pflegestufe getPflegestufe(){
        return this.pflegestufe;
    }

    public boolean hatHelfer(){ return this.helfer != null; }
}
