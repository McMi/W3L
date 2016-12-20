/**
 * Die Klasse Person modelliert eine Person inklusive ihrer Eigenschaften wie z.B. Name.
 *
 * Erstellt von M. Lintl am 29.10.2016
 */
public class Person {
    private int nummer;
    private String name;
    private String strasse;
    private String ort;

    public Person(int nummer, String name, String strasse, String ort){
        this.nummer = nummer;
        this.name = name;
        this.strasse = strasse;
        this.ort = ort;
    }

    public int getNummer(){
        return this.nummer;
    }

    public String getName(){
        return this.name;
    }

    public String getStrasse(){
        return this.strasse;
    }

    public String getOrt(){
        return this.ort;
    }
}
