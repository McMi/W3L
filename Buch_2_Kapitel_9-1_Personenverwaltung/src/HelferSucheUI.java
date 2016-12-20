import java.util.List;

/**
 * Die Klasse HelferSucheUI bündelt die Anzeige- und Ausgabefunktionalität der Helfer- und Patientenverwaltung
 * und -suche. Die Ausgabe erfolgt auf der Konsole.
 *
 * Erstellt von M. Lintl am 29.10.2016
 */
public class HelferSucheUI {
    public static void main(String args[]){
        //Aufruf der Personenverwaltung
        Personenverwaltung personenverwaltung = Personenverwaltung.getPersonenverwaltungReferenz();

        //Hinzufügen einiger Beispiel-Patienten
        personenverwaltung.addPatient("Hans","Almgasse", "Magdeburg", Pflegestufe.I);
        personenverwaltung.addPatient("Ulrike","Marsstraße", "Magdeburg", Pflegestufe.III);
        personenverwaltung.addPatient("Ludwig","Rathausweg", "Nürnberg", Pflegestufe.II);
        personenverwaltung.addPatient("Hans","Niederweg", "Dortmund", Pflegestufe.II);
        personenverwaltung.addPatient("Anna","Ziegelweg", "Augsburg", Pflegestufe.II);

        //Hinzufügen einiger Beispiel-Helfer
        personenverwaltung.addHelfer("Mario","Am Stadion","Augsburg",false);
        personenverwaltung.addHelfer("Bruno","Rosengasse","Dortmund",false);
        personenverwaltung.addHelfer("Andrea","Hafenallee","Dortmund",true);
        personenverwaltung.addHelfer("Roswita","Steinstraße","Nürnberg",true);
        personenverwaltung.addHelfer("Michael","Bahnhofsweg","Magdeburg",true);

        //Ermitteln einer Zuordnung von Helfern zu Patienten für alle gespeicherten Patienten und Helfer
        List<Patient> patienten = personenverwaltung.getPatienten();
        List<Helfer> helfer = personenverwaltung.getHelfer();
        HelferSuche.setHelfer(patienten, helfer);

        System.out.println("Patienten:");
        for(Patient einPatient : patienten) {
            druckePatientendaten(einPatient);
            System.out.println("");
        }
        System.out.println("");

        System.out.println("Helfer:");
        for(Helfer einHelfer : helfer) {
            druckeHelferdaten(einHelfer);
            System.out.println("");
        }
        System.out.println("");

        System.out.println("Übersicht der Zuordnungen:");
        for(Patient einPatient : patienten){
            druckePatientendaten(einPatient);
            if(einPatient.hatHelfer()){
                druckeHelferdaten(einPatient.getHelfer());
            }
            System.out.println("");
        }
        System.out.println("");

        System.out.println("Freie Helfer:");
        for(Helfer einHelfer : helfer){
            if(!einHelfer.hatPatient()){
                druckeHelferdaten(einHelfer);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void druckePersonendaten(Person einePerson){
        System.out.print("\t" + einePerson.getNummer() + "\t" + einePerson.getName() + "\t"
                + einePerson.getStrasse() + "\t" + einePerson.getOrt());
    }

    private static void druckePatientendaten(Patient einPatient){
        druckePersonendaten(einPatient);
        System.out.print("\t" + einPatient.getPflegestufe());
    }

    private static void druckeHelferdaten(Helfer einHelfer){
        druckePersonendaten(einHelfer);
        System.out.print("\t" + einHelfer.getHatAusbildung());
    }
}
