import java.util.List;

/**
 * Die Klasse HelferSuche ist eine Hilfsklasse, welche die Funktionalität bereitstellt, zu einer Menge an Patienten
 * geeignete Helfer zu finden, sodass (wenn möglich) jeder Patient genau einen Helfer zugewiesen bekommt, der im
 * gleichen Ort wohnt und wenn nötig eine zur Pflegestufe passende Ausbildung hat. Sollte ein solcher Helfer nicht
 * existieren, dann wird kein Helfer zugeordnet.
 *
 * Erstellt von M. Lintl am 29.10.2016
 */
public class HelferSuche {
    private HelferSuche() {
        //Leerer Konstruktor, um eine Objektinstanziierung zu verhindern, da Hilfsklasse
    }

    public static void setHelfer(List<Patient> patienten, List<Helfer> helfer) {
        for (Patient einPatient : patienten) {
            for (Helfer einHelfer : helfer) {
                boolean istGeeignet = true;
                //Prüfung auf Eignung durch Ausbildung ab Pflegestufe II
                if (brauchtAusgebildetenHelfer(einPatient)) {
                    istGeeignet = einHelfer.getHatAusbildung();
                }

                //Suche nach geeignetem Helfer und Zuordnung
                if (einPatient.getOrt().equals(einHelfer.getOrt())
                        && !einHelfer.hatPatient()
                        && istGeeignet) {
                    einPatient.setHelfer(einHelfer);
                    einHelfer.setPatient(einPatient);
                    break;
                }
            }
        }
    }

    private static boolean brauchtAusgebildetenHelfer(Patient einPatient){
        return einPatient.getPflegestufe() != Pflegestufe.I;
    }
}
