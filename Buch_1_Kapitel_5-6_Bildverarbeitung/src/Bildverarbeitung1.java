/**
 * Die Klasse Bildverarbeitung1 stellt die Funktionalität das Histogramm eines beliebig aufgelösten Bildes
 * (mit 256 Farbwerten) zu berechnen bereit. Das Bild muss dafür als zweidimensionales Feld von ganzzahligen
 * Farbwerten vorliegen.
 *
 * Erstellt durch M. Lintl am 07.10.2016.
 */

public class Bildverarbeitung1 {

    public static void main(String args[]){
        int[][] bild = {{34,255,255,56},{127,204,11,34},{123,98,127,34},{34,34,127,17}};
        int[] haeufigkeit = new int[256];

        for(int i=0;i<bild.length;i++){
            for(int j=0; j<bild[i].length;j++){
                haeufigkeit[bild[i][j]]++;
            }
        }

        for(int i=0; i<haeufigkeit.length;i++){
            if(haeufigkeit[i]>0) System.out.println("Farbwert: "+i+"\t"+"Häufigkeit: "+haeufigkeit[i]);
        }
    }
}
