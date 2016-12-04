/**
 * Die Klasse Artikel modelliert einen Artikel (d.h. ein Softwareprodukt) der Firma WebSoft mit seinen Attributen.
 * Die Erzeugung eines Artikels setzt vorraus, dass Artikelnummer und Bezeichnung bekannt sind.
 *
 * Erstellt von M. Lintl am 24.10.2016.
 */
public class Artikel {
    private int nummer;
    private String bezeichnung;
    private String sprache = "Java";
    private String beschreibung;
    private int preis = 0;

    //Privater Konstruktor, um Objekterzeugung ohne Mindestinformationen Nummer und Bezeichnung zu verhindern
    private Artikel(){
    }

    Artikel(int nummer, String bezeichnung){
        this.nummer = nummer;
        this.bezeichnung = bezeichnung;
    }

    Artikel(int nummer, String bezeichnung, String beschreibung){
        this(nummer, bezeichnung);
        this.beschreibung = beschreibung;
    }

    Artikel(int nummer, String bezeichnung, String beschreibung, int preis){
        this(nummer, bezeichnung, beschreibung);
        this.preis = preis;
    }

    Artikel(int nummer, String bezeichnung, String sprache, String beschreibung, int preis){
        this(nummer,bezeichnung,beschreibung, preis);
        this.sprache = sprache;
    }

    public int getNummer(){
        return this.nummer;
    }

    public String getBezeichnung(){
        return this.bezeichnung;
    }

    public String getSprache(){
        return this.sprache;
    }

    public String getBeschreibung(){
        return this.beschreibung;
    }

    public int getPreis(){
        return this.preis;
    }

    public void setNummer(int nummer){
        this.nummer = nummer;
    }

    public void setBezeichnung(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }

    public void setSprache(String sprache){
        this.sprache = sprache;
    }

    public void setBeschreibung(String beschreibung){
        this.beschreibung = beschreibung;
    }

    public void setPreis(int preis){
        this.preis = preis;
    }
}
