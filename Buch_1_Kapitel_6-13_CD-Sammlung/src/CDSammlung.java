/**
 * Die Klasse CDSammlung ermöglicht die Verwaltung einer CD-Sammlung mit maximal 15 CDs. Das Verwalten umfasst die
 * Operationen Hinzufügen und Entfernen von CDs sowie das Ansehen der gesamten Sammlung. Die Ausgabe erfolgt auf
 * der Konsole.
 *
 * Erstellt von M. Lintl am 10.10.2016
 */
public class CDSammlung {
    private static final int kapazitaet = 5;
    private static CD[] sammlung = new CD[kapazitaet];

    public static void main (String args[]){
        //Leere Sammlung zu Beginn
        System.out.println("Sammlung zum Zeitpunkt 0");
        CDSammlung.zeigeCDSammlung();

        //ersten zwei CDs hinzufügen
        CD ersteCD = new CD("Mrs. Robinson", "Simon and Garfunkel");
        CDSammlung.hinzufuegenCD( ersteCD);
        CD zweiteCD = new CD("Mambo No. 5", "Lou Bega");
        CDSammlung.hinzufuegenCD(zweiteCD);

        //Sammlung nach dem Hinzufügen der ersten zwei CDs anzeigen
        System.out.println("Sammlung zum Zeitpunkt 1");
        CDSammlung.zeigeCDSammlung();

        //dritte CD als anonymes Objekt hinzufügen
        CDSammlung.hinzufuegenCD(new CD("Let it be","Beatles"));

        //Sammlung nach dem Hinzufügen der dritten CD anzeigen
        System.out.println("Sammlung zum Zeitpunkt 2");
        CDSammlung.zeigeCDSammlung();

        //Entfernen der zweiten CD mit Hilfe der zugehörigen Objektreferenz
        CDSammlung.entfernenCD(zweiteCD);

        //Anzeigen der Sammlung nach dem Entfernen
        System.out.println("Sammlung zum Zeitpunkt 3");
        CDSammlung.zeigeCDSammlung();

        //Entfernen über Titel und Interpret
        CDSammlung.entfernenCD("Test-Titel","Test-Interpret");

        //Anzeigen der Sammlung nach dem Entfernen über Titel und Interpret
        System.out.println("Sammlung zum Zeitpunkt 4");
        CDSammlung.zeigeCDSammlung();
    }

    private static void hinzufuegenCD(CD cd){
        int i =0;
        //Freien Platz i suchen
        while(i<sammlung.length && sammlung[i]!=null){
            i++;
        }
        if(i==sammlung.length){
            System.out.println("Es ist kein Platz für die CD frei. Bitte zuerst eine CD entfernen.");
            System.out.println("");
        }
        else{
            //i<sammlung.length, d.h. der i-te Platz ist frei
            sammlung[i] = cd;
        }
    }

    private static void entfernenCD(CD cd){
        int i=0;
        //Suche nach Slot i, der die CD enthält
        while(i<sammlung.length && sammlung[i]!=cd){
            i++;
        }
        if(i==sammlung.length){
            //Suche nach der CD blieb erfolglos
            System.out.println("Diese CD existiert nicht in der Sammlung.");
            System.out.println("");
        }
        else{
            //gesuchte CD befindet sich in Slot i und wird entfernt
            sammlung[i] = null;
        }
    }

    private static void entfernenCD(String titel, String interpret){
        boolean entfernt = false;
        //Suche nach der ersten CD, die den übergebenen Titel trägt und vom übergegebenen Interpret ist
        for(int i=0; i<sammlung.length; i++){
            if(sammlung[i] != null && sammlung[i].getTitel().equals(titel) && sammlung[i].getInterpret().equals(interpret)){
                //Slot i freigeben
                sammlung[i] = null;
                entfernt = true;
                break;
            }
        }
        if(!entfernt){
            //Suche nach der CD blieb erfolglos
            System.out.println("Diese CD existiert nicht in der Sammlung.");
            System.out.println("");
        }
    }

    private static void zeigeCDSammlung(){
        for(int i=0; i<sammlung.length;i++){
             if(sammlung[i]!= null){
                 System.out.println("Slot "+(i+1)+": "+sammlung[i].getTitel()+", "+sammlung[i].getInterpret());
             }
             else{
                 //Slot i+1 ist nicht belegt
                 System.out.println("Slot "+(i+1)+": --");
             }
        }
        System.out.println("");
    }
}

