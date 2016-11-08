/**
 * Die Klasse Telefon speichert die Daten eines Telefons. Beim Anlegen eines Telefons muss dessen Typ bekannt sein.
 * Außerdem stellt die Klasse eine Methode zum Wählen einer Telefonnummer zur Verfügung.
 *
 * Erstellt von M. Lintl am 07.11.2016
 */
public class Telefon {
    private String nummer = "";
    private int typ;

    public Telefon(int typ){
        this.typ = typ;
    }

    public Telefon(int typ, String nummer){
        this(typ);
        this.nummer = nummer;
    }

    public String getNummer() {
        return this.nummer;
    }

    public int getTyp() {
        return this.typ;
    }

    public void setNummer(String nummer){
        this.nummer = nummer;
    }

    public void waehlen(){
        //Hier würde die Wählmethode implementiert sein
    }
}
