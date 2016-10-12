import inout.Console;

/**
 * Die Klasse Geheimschrift ermöglicht wahlweise das Ver- und Entschlüsseln eines Textes mit Hilfe der
 * Zweifachsubstitution.
 * Das Schlüsselwort, sowie der Klartext bzw. Codetext werden von der Konsole eingelesen und dürfen nur aus Groß-
 * buchstaben [A-Z] bestehen. Die Ausgabe des ver- / entdschlüsselten Textes erfolgt ebenfalls über die Konsole.
 *
 * Erstellt von M. Lintl am 10.10.2016
 */
public class Geheimschrift {
    public static void main (String args[]){

        char[] schluessel, eingabetext;

        System.out.println("Verfügbare Funktionen:");
        System.out.println("\t1. Verschlüsseln");
        System.out.println("\t2. Entschlüsseln");
        System.out.println("Bitte Funktion wählen:");

        int wahl = Console.readInt();

        if(wahl==1 || wahl==2){
            System.out.println("Bitte Schlüsselwort eingeben:");
            schluessel = Console.readCharArray();
            System.out.println("Bitte Text zum Ver-/Entschlüsseln eingeben:");
            eingabetext = Console.readCharArray();

            if(eingabePruefen(schluessel) && eingabePruefen(eingabetext)){
                System.out.println("");
                System.out.println("Schlüsselwort");
                System.out.println(schluessel);
                System.out.println("Text");
                System.out.println(eingabetext);

                switch(wahl) {
                    case 1: {
                        System.out.println("Verschlüsselter Text");
                        System.out.println(verschluesseln(schluessel,eingabetext));
                        break;
                    }
                    case 2: {
                        System.out.println("Entschlüsselter Text");
                        System.out.println(entschluesseln(schluessel,eingabetext));
                        break;
                    }
                }
            }
            else{
                //eingabeOK==false
                System.out.println("Bitte nur Großbuchstaben A-Z verwenden.");
            }
        }
        else{
            //wahl != 1 & wahl !=2
            System.out.println("Ungültige Funktionswahl.");
        }
    }

    private static char[] verschluesseln(char[] schluessel, char[] klartext){
        char[] codetext = new char[klartext.length];

        for (int i = 0; i < klartext.length; i++) {
            //Bestimmung des Versatzes des i-ten Klartextbuchstabens ggü. dem i-ten Buchstaben
            //(ggf. Modulo) im normalen Alphabet.
            int versatz = klartext[i] - ('A'+(i%26));

            //Bestimmung des verschlüsselten Buchstabens
            char buchstabe = (char) ('A' + (schluessel[i%schluessel.length] - 'A' + versatz + 26 )%26);

            codetext[i]=buchstabe;
        }
        return codetext;
    }

    private static char[] entschluesseln(char[] schluessel, char[] codetext){
        char[] klartext = new char[codetext.length];

        for (int i = 0; i < codetext.length; i++) {
            //Bestimmung des Versatzes des i-ten Codetextbuchstabens ggü. dem i-ten Schlüsselbuchstaben
            //im normalen Alphabet
            int versatz = codetext[i] - schluessel[i%schluessel.length];

            //Bestimmung des Klartextbuchstabens
            char buchstabe = (char) ('A'+ (i +  versatz + 26)%26);

            klartext[i]=buchstabe;
        }
        return klartext;
    }

    private static boolean eingabePruefen(char[] eingabe){
        boolean eingabeOK = true;
        for(char buchstabe : eingabe){
            if(buchstabe <'A' || buchstabe > 'Z') eingabeOK=false; break;
        }
        return eingabeOK;
    }
}
