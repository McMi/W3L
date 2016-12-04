/**
 * Die Klasse CDSammlung ermöglicht die Verwaltung einer CD-Sammlung mit einer konfigurierbaren Maximalanzahl von CDs.
 * Das Verwalten umfasst die Operationen Hinzufügen und Entfernen von CDs sowie das Ansehen der gesamten Sammlung.
 * Die Ausgabe erfolgt auf der Konsole.
 *
 * Erstellt von M. Lintl am 11.10.2016
 */
public class CDSammlung_ohne_Objekt {
    private static final int kapazitaet = 5;
    private static String[][] sammlung = new String[kapazitaet][2];

    public static void main (String args[]){
        //Sammlung iniitalisieren
        for(int i=0; i<sammlung.length;i++){
            sammlung[i][0]="";
            sammlung[i][1]="";
        }
        //Leere Sammlung zu Beginn
        System.out.println("Sammlung zum Zeitpunkt 0");
        CDSammlung_ohne_Objekt.zeigeCDSammlung();

        //ersten zwei CDs hinzufügen
        CDSammlung_ohne_Objekt.hinzufuegenCD("Mrs. Robinson", "Simon and Garfunkel");
        CDSammlung_ohne_Objekt.hinzufuegenCD("Mambo No. 5", "Lou Bega");

        //Anzeigen der Sammlung nach dem Hinzufügen der ersten zwei CDs
        System.out.println("Sammlung zum Zeitpunkt 1");
        CDSammlung_ohne_Objekt.zeigeCDSammlung();

        //Entfernen einer CD
        CDSammlung_ohne_Objekt.entfernenCD("Mambo No. 5", "Lou Bega");

        //Anzeigen der Sammlung nach dem Entfernen einer CD
        System.out.println("Sammlung zum Zeitpunkt 2");
        CDSammlung_ohne_Objekt.zeigeCDSammlung();
    }

    private static void hinzufuegenCD(String titel, String interpret){
        int i=0;
        //Suche nach freiem Slot i
        while(i<sammlung.length && !(sammlung[i][0].equals("") && sammlung[i][1].equals(""))){
            i++;
        }
        if(i==sammlung.length){
            //Suche nach freiem Slot blieb erfolglos
            System.out.println("Es ist kein Platz für die CD frei. Bitte zuerst eine CD entfernen.");
        }
        else{
            //i<sammlung.length, d.h. der i-te Slot ist frei
            sammlung[i][0] = titel;
            sammlung[i][1] = interpret;
        }
    }

    private static void entfernenCD(String titel, String interpret){
        int i=0;
        //Suche nach Slot i, der die CD enthält
        while(i<sammlung.length && !(sammlung[i][0].equals(titel) && sammlung[i][1].equals(interpret))){
            i++;
        }
        if(i==sammlung.length){
            //Suche nach der CD blieb erfolglos
            System.out.println("Diese CD existiert nicht in der Sammlung.");
        }
        else{
            //gesuchte CD befindet sich in Slot i und wird entfernt
            sammlung[i][0] = "";
            sammlung[i][1] = "";
        }
    }

    private static void zeigeCDSammlung(){
        for(int i=0; i<sammlung.length;i++){
             if(!sammlung[i][0].equals("") || !sammlung[i][1].equals("")){
                 System.out.println("Slot "+(i+1)+": "+sammlung[i][0]+", "+sammlung[i][1]);
             }
             else{
                 //Slot i+1 ist nicht belegt
                 System.out.println("Slot "+(i+1)+": --");
             }
        }
        System.out.println("");
    }
}

