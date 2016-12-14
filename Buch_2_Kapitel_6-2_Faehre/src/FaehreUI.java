import java.util.DoubleSummaryStatistics;

/**
 * Die Klasse FaehreUI dient der Simulation der Beladung einer Fähre mit zufällig erzeugten Fahrzeugen. Die Ausgabe der
 * Daten erfolgt auf der Konsole.
 *
 * Erstelllt von M. Lintl am 09.11.2016.
 */
public class FaehreUI {
    //Wertebereich LKW
    private static final int lb_breiteLKW_cm = 300;
    private static final int ub_breiteLKW_cm = 450;
    private static final int lb_laengeLKW_cm = 800;
    private static final int ub_laengeLKW_cm = 4_000;
    private static final int lb_gewichtLKW_kg = 7_500;
    private static final int ub_gewichtLKW_kg = 20_000;

    //Wertebereich PKW
    private static final int lb_breitePKW_cm = 200;
    private static final int ub_breitePKW_cm = 400;
    private static final int lb_laengePKW_cm = 300;
    private static final int ub_laengePKW_cm = 700;
    private static final int lb_gewichtPKW_kg = 1_000;
    private static final int ub_gewichtPKW_kg = 2_800;

    //Wertebereich Motorrad
    private static final int lb_breiteMotorrad_cm = 100;
    private static final int ub_breiteMotorrad_cm = 300;
    private static final int lb_laengeMotorrad_cm = 150;
    private static final int ub_laengeMotorrad_cm = 400;
    private static final int lb_gewichtMotorrad_kg = 150;
    private static final int ub_gewichtMotorrad_kg = 400;

    //Wertebereich Fahrrad
    private static final int lb_breiteFahrrad_cm = 50;
    private static final int ub_breiteFahrrad_cm = 150;
    private static final int lb_laengeFahrrad_cm = 100;
    private static final int ub_laengeFahrrad_cm = 300;
    private static final int lb_gewichtFahrrad_kg = 5;
    private static final int ub_gewichtFahrrad_kg = 20;

    //Wertebereich Gepäck
    private static final int lb_gewichtGepaeckLKW_kg = 500;
    private static final int ub_gewichtGepaeckLKW_kg = 2_000;
    private static final int lb_gewichtGepaeckPKW_kg = 100;
    private static final int ub_gewichtGepaeckPKW_kg = 300;
    private static final int lb_gewichtGepaeckMotorrad_kg = 10;
    private static final int ub_gewichtGepaeckMotorrad_kg = 50;
    private static final int lb_gewichtGepaeckFahrrad_kg = 1;
    private static final int ub_gewichtGepaeckFahrrad_kg = 30;

    //Wertebereich Person
    private static final int lb_gewichtPerson_kg = 40;
    private static final int ub_gewichtPerson_kg = 120;

    //Wahrscheinlichkeit, ob auf einem Platz im Fahrzeug ein Beifahrer sitzt
    private static final double beifahrerWahrscheinlichkeitProPlatz =0.5;

    public static void main(String args[]) {
        /*Erzeugung der Fähre mit maximalem Nutzgewicht x*100000kg und x*1000sqm, wobei x=25 aufgrund der Initialien
        M = 13 plus L = 12.*/
        Faehre eineFaehre = new Faehre(2_500_000, 25_000);

        druckeFaehrdaten(eineFaehre);
        System.out.println("");
        System.out.println("********Start der Beladung********");

        //Deklaration und Initialisierung eines Abbruchkriteriums
        int abgewieseneFahrzeuge = 0;
        int behandelteFahrzeuge = 0;

        while (abgewieseneFahrzeuge < 10) {
            //Ausgabe und Hochzählen der behandelten Fahrzeuge
            System.out.println("Fahrzeug: " + ++behandelteFahrzeuge);

            //Fahrzeug erzeugen, ausgeben und versuchen aufzuladen
            Fahrzeug naechstesFahrzeug = generiereNaechstesFahrzeug();
            druckeFahrzeugdaten(naechstesFahrzeug);
            try {
                eineFaehre.fahrzeugAufladen(naechstesFahrzeug);
            } catch (VehicleNotValidException e) {
                System.out.println(e.getMessage());
                abgewieseneFahrzeuge++;
                System.out.println("");
                continue;
            }
            druckeFaehrdaten(eineFaehre);
            System.out.println("");
        }
        System.out.println("********Ende der Beladung********");
        druckeFaehrdaten(eineFaehre);
    }

    private static int generiereZufallswert(int min, int max) {
        return (int) ((max - min) * Math.random() + min);
    }

    private static Fahrzeug generiereNaechstesFahrzeug() {
        int fahrzeugtyp = generiereZufallswert(1,5);
        switch(fahrzeugtyp){
            case 1:
                return generiereLKW();
            case 2:
                return generierePKW();
            case 3:
                return generiereMotorrad();
            default:
                return generiereFahrrad();
        }
    }

    private static Person generiereFahrer(){
        return generierePerson();
    }

    private static Person generiereBeifahrer(){
        return generierePerson();
    }

    private static Person generierePerson(){
        int gewicht_kg = generiereZufallswert(lb_gewichtPerson_kg, ub_gewichtPerson_kg);
        return new Person(gewicht_kg);
    }

    private static Gepaeckstueck generiereGepaeckstueck(int minGewicht, int maxGewicht){
        int gewicht_kg = generiereZufallswert(minGewicht, maxGewicht);
        return new Gepaeckstueck(gewicht_kg);
    }

    private static LKW generiereLKW(){
        //zufällige Länge, Breite und Gewicht innerhalb der LKW-Grenzen generieren
        int laenge_cm = generiereZufallswert(lb_laengeLKW_cm, ub_laengeLKW_cm);
        int breite_cm = generiereZufallswert(lb_breiteLKW_cm, ub_breiteLKW_cm);
        int gewicht_kg = generiereZufallswert(lb_gewichtLKW_kg, ub_gewichtLKW_kg);

        LKW einLKW = new LKW(generiereFahrer(), laenge_cm, breite_cm, gewicht_kg);

        //Gepäck generieren und dem LKW zuordnen
        einLKW.setGepaeck(generiereGepaeckstueck(lb_gewichtGepaeckLKW_kg, ub_gewichtGepaeckLKW_kg));

        //Entscheide für jeden Platz ob darauf ein Beifahrer sitzt und wenn ja, dann generiere diesen und versuche ihn dem LKW zuzuordnen
        for(int i=0; i<einLKW.getMaxAnzahlBeifahrer(); i++){
            if(loseObBeifahrerAufPlatz()){
                beifahrerHinzufuegenZu(einLKW);
            }
        }
        return einLKW;
    }

    private static PKW generierePKW(){
        //zufällige Länge, Breite und Gewicht innerhalb der PKW-Grenzen generieren
        int laenge_cm = generiereZufallswert(lb_laengePKW_cm, ub_laengePKW_cm);
        int breite_cm = generiereZufallswert(lb_breitePKW_cm, ub_breitePKW_cm);
        int gewicht_kg = generiereZufallswert(lb_gewichtPKW_kg, ub_gewichtPKW_kg);

        PKW einPKW = new PKW(generiereFahrer(), laenge_cm, breite_cm, gewicht_kg);

        //Gepäck generieren und dem PKW zuordnen
        einPKW.setGepaeck(generiereGepaeckstueck(lb_gewichtGepaeckPKW_kg, ub_gewichtGepaeckPKW_kg));

        //Entscheide für jeden Platz ob darauf ein Beifahrer sitzt und wenn ja, dann generiere diesen und versuche ihn dem PKW zuzuordnen
        for(int i=0; i<einPKW.getMaxAnzahlBeifahrer(); i++){
            if(loseObBeifahrerAufPlatz()){
                beifahrerHinzufuegenZu(einPKW);
            }
        }
        return einPKW;
    }

    private static Motorrad generiereMotorrad(){
        //zufällige Länge, Breite und Gewicht innerhalb der Motorrad-Grenzen generieren
        int laenge_cm = generiereZufallswert(lb_laengeMotorrad_cm, ub_laengeMotorrad_cm);
        int breite_cm = generiereZufallswert(lb_breiteMotorrad_cm, ub_breiteMotorrad_cm);
        int gewicht_kg = generiereZufallswert(lb_gewichtMotorrad_kg, ub_gewichtMotorrad_kg);

        Motorrad einMotorrad = new Motorrad(generiereFahrer(), laenge_cm, breite_cm, gewicht_kg);

        //Gepäck generieren und dem Motorrad zuordnen
        einMotorrad.setGepaeck(generiereGepaeckstueck(lb_gewichtGepaeckMotorrad_kg, ub_gewichtGepaeckMotorrad_kg));

        //Entscheide für jeden Platz ob darauf ein Beifahrer sitzt und wenn ja, dann generiere diesen und versuche ihn dem Motorrad zuzuordnen
        for(int i=0; i<einMotorrad.getMaxAnzahlBeifahrer(); i++){
            if(loseObBeifahrerAufPlatz()){
                beifahrerHinzufuegenZu(einMotorrad);
            }
        }
        return einMotorrad;
    }

    private static Fahrrad generiereFahrrad(){
        //zufällige Länge, Breite und Gewicht innerhalb der Fahrrad-Grenzen generieren
        int laenge_cm = generiereZufallswert(lb_laengeFahrrad_cm, ub_laengeFahrrad_cm);
        int breite_cm = generiereZufallswert(lb_breiteFahrrad_cm, ub_breiteFahrrad_cm);
        int gewicht_kg = generiereZufallswert(lb_gewichtFahrrad_kg, ub_gewichtFahrrad_kg);

        Fahrrad einFahrrad = new Fahrrad(generiereFahrer(), laenge_cm, breite_cm, gewicht_kg);

        //Gepäck generieren und dem Fahrrad zuordnen
        einFahrrad.setGepaeck(generiereGepaeckstueck(lb_gewichtGepaeckFahrrad_kg, ub_gewichtGepaeckFahrrad_kg));

        //Entscheide für jeden Platz ob darauf ein Beifahrer sitzt und wenn ja, dann generiere diesen und versuche ihn dem Fahrrad zuzuordnen
        for(int i=0; i<einFahrrad.getMaxAnzahlBeifahrer(); i++){
            if(loseObBeifahrerAufPlatz()){
                beifahrerHinzufuegenZu(einFahrrad);
            }
        }
        return einFahrrad;
    }

    private static boolean loseObBeifahrerAufPlatz(){
        return Math.random() <= beifahrerWahrscheinlichkeitProPlatz;
    }

    private static void beifahrerHinzufuegenZu(Fahrzeug einFahrzeug){
        Person einBeifahrer = generiereBeifahrer();
        try {
            einFahrzeug.addBeifahrer(einBeifahrer);
        }
        catch (NoSeatAvailableException e){
            System.out.println(e.getMessage());
        }
    }

    private static void druckeFaehrdaten(Faehre eineFaehre){
        System.out.println("Aktuelle Daten der Fähre:");
        druckeAufgeladeneFahrzeuge(eineFaehre);
        System.out.println("\tAktuelle Nutzfläche: " + eineFaehre.getAktuelleNutzflaeche_sqm() + "m2");
        System.out.println("\tAktuelles Nutzgewicht: " + eineFaehre.getAktuellesNutzgewicht_kg() + "kg");
        System.out.println("\tDurchschnittliche Nutzfläche: " + eineFaehre.getDurchschnittlicheNutzflaeche_sqm() + "m2");
        System.out.println("\tDurchschnittliches Fahrzeuggewicht: " + eineFaehre.getDurchschnittlichesNutzgewicht_kg() + "kg");
        System.out.println("\tAnzahl Fahrzeuge (Prognose): " + eineFaehre.getPrognoseAnzahlFahrzeuge());
    }

    private static void druckeFahrzeugdaten(Fahrzeug einFahrzeug) {
        System.out.println("\tFahrzeugtyp: " + einFahrzeug.getClass().getSimpleName());
        System.out.println("\tNutzfläche: " + einFahrzeug.getBenoetigteFlaeche_sqm() + "m2");
        System.out.print("\tGesamtgewicht: " + einFahrzeug.berechneGesamtgewicht_kg() + "kg");
        System.out.print(" (");
        System.out.print("Fahrzeug: " + einFahrzeug.getGewicht_kg() + "kg");
        System.out.print(" / ");
        System.out.print("Fahrer: " + einFahrzeug.getFahrer().getGewicht_kg() +"kg");
        System.out.print(" / ");
        System.out.print("Gepäck: " + einFahrzeug.getGepaeck().getGewicht_kg() +"kg");
        int beifahrernummer=0;
        for(Person einBeifahrer : einFahrzeug.getBeifahrer()){
            System.out.print(" / ");
            System.out.print("Beifahrer " + ++beifahrernummer +": " + einBeifahrer.getGewicht_kg() + "kg");
        }
        System.out.println(")");
    }

    private static void druckeAufgeladeneFahrzeuge(Faehre eineFaehre) {
        System.out.print("\tBeladene Fahrzeuge: ");
        System.out.print(eineFaehre.getAnzahlAufgeladeneLKW() + "x LKW / ");
        System.out.print(eineFaehre.getAnzahlAufgeladenePKW() + "x PKW / ");
        System.out.print(eineFaehre.getAnzahlAufgeladeneMotorraeder() + "x Motorrad / ");
        System.out.println(eineFaehre.getAnzahlAufgeladeneFahrraeder() + "x Fahrrad");
    }
}
