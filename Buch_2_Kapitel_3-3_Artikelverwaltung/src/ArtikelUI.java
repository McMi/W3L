/**
 * Die Klasse ArtikelUI simuliert den Anwendungsfall einer simplen Verwaltung (d.h. ausschließlich das Hinzufügen) von
 * Artikeln und gibt die erstellten Artikel nachfolgend auf der Konsole aus.
 * Die Konsistenz der Daten ist vom Anwender sicherzustellen (bspw. Vermeidung doppelter Artikelnummern).
 *
 *  Erstellt von M. Lintl am 24.10.2016.
 */
public class ArtikelUI {
    public static void main(String args[]){
        //Erzeugung des zweiten Artikels (Befüllung der Attribute bei Objekterzeugung)
        Artikel artikel1 = new Artikel(4711,"Diashow","Java","Dia-Show auf HTML-Seite",2990);

        //Erzeugung des zweiten Artikels (Befüllen des Attributs Preis im Anschluss)
        Artikel artikel2 = new Artikel(4712,"Bildbeschriftung","Erlaubt Beschriftungen von Bildern");
        artikel2.setPreis(9990);

        //Erzeugung des dritten Artikels (Befüllen der Attribute Preis und Beschreibung im Anschluss)
        Artikel artikel3 = new Artikel(8726, "100 Piktos");
        artikel3.setBeschreibung("100 Piktogramme für HTMl-Seite");
        artikel3.setPreis(5450);

        //Erzeugung des personalisierten Artikels (Korrektur der Standardsprache im Anschluss)
        Artikel meinArtikel = new Artikel(28,"Michael Lintl","Ein echter VBA-Lintl",399);
        meinArtikel.setSprache("VBA");

        System.out.println("Artikelnr\tBezeichnung\tSprache\tBeschreibung\tVerkaufspreis");
        ArtikelUI.druckeArtikel(artikel1);
        ArtikelUI.druckeArtikel(artikel2);
        ArtikelUI.druckeArtikel(artikel3);
        ArtikelUI.druckeArtikel(meinArtikel);
    }

    private static void druckeArtikel(Artikel artikel){
        System.out.println(artikel.getNummer()+"\t"+artikel.getBezeichnung()+"\t"+artikel.getSprache()+
                "\t"+artikel.getBeschreibung()+"\t"+artikel.getPreis());
    }
}
