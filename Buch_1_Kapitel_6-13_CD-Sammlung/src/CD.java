/**
 * Die Klasse CD modelliert eine CD mit Titel und Interpret.
 *
 * Erstellt von M. Lintl am 10.10.2016
 */

public class CD {
    private String titel;
    private String interpret;

    public CD(){
    }

    public CD(String titel, String interpret){
        this.titel = titel;
        this.interpret = interpret;
    }

    public String getTitel() {
        return this.titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInterpret() {
        return this.interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }
}