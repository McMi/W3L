/**
 * Die Klasse Nutzer speichert die Daten eines Nutzers und seine Endgeräte. Die Anzahl der Endgeräte ist auf 2
 * beschränkt.
 *
 * Erstellt von M. Lintl am 07.11.2016
 */
public class Nutzer {
    private String name;
    private Telefon[] endgeraete = new Telefon[2];

    public Nutzer (String name){
        this.name = name;
    }

    public Nutzer(String name, Telefon[] endgeraete){
        this(name);
        this.endgeraete = endgeraete;
    }

    public String getName() {
        return this.name;
    }

    public Telefon[] getEndgeraete() {
        return this.endgeraete;
    }

    public void setEndgeraete(Telefon[] endgeraete) {
        this.endgeraete = endgeraete;
    }
}