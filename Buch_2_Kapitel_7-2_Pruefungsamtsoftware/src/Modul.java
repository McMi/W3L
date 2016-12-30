import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Modul modelliert ein Modul eines Studiengangs. Es ist in der Lage die ihm zugeordneten Lehrveranstaltungen
 * zu speichern und zu verwalten.
 *
 * Erstellt von M. Lintl am 14.12.2016.
 */
public class Modul implements CreditPointI {
    private static final int maxAnzahlLehrveranstaltungen = 4;

    private String name;
    private List<Lehrveranstaltung> lehrveranstaltungen;

    Modul(String name, Lehrveranstaltung... lehrveranstaltungen) throws ModuleOverloadException{
        this.name = name;
        this.lehrveranstaltungen = new ArrayList<>();
        for(Lehrveranstaltung eineLehrveranstaltung : lehrveranstaltungen){
                addLehrveranstaltung(eineLehrveranstaltung);
        }
    }

    public String getName(){ return this.name; }

    public int getAnzahlCPs(){
        int anzahlCPs = 0;
        for(Lehrveranstaltung eineLehrveranstaltung : this.lehrveranstaltungen){
            anzahlCPs += eineLehrveranstaltung.getAnzahlCPs();
        }
        return anzahlCPs;
    }

    public void addLehrveranstaltung(Lehrveranstaltung eineLehrveranstaltung) throws ModuleOverloadException{
        if(this.lehrveranstaltungen.size() < maxAnzahlLehrveranstaltungen){
            this.lehrveranstaltungen.add(eineLehrveranstaltung);
        }
        else{
            throw new ModuleOverloadException("Die Lehrveranstaltung kann nicht hinzugefügt bzw. das Modul nicht angelegt " +
                    "werden, da dem Modul zu viele Lehrveranstaltungen zugeordnet sind.");
        }
    }
}
