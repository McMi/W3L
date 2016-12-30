/**
 * Die Klasse StudiengangUI simuliert die Verwaltung eines Studiengangs in einem Prüfungsamt. Dies umfasst das Hinzufügen
 * von Modulen und Lehrveranstaltungen zu einem Studiengang. Die Ausgabe erfolgt auf der Konsole.
 *
 * Erstellt von M. Lintl am 14.12.2016.
 */
public class StudiengangUI {
    public static void main(String args[]) {
        Modul informatikModul = null, matheModul = null;

        //Erzeugung des Informatik-Moduls
        try{
            informatikModul = new Modul("Grundlagen der Informatik",
                    new Lehrveranstaltung("Grundlagen der Informatik I", 5),
                    new Lehrveranstaltung("Grundlagen der Informatik II", 5)
            );
            ModulContainer.getModulContainerReferenz().addModul(informatikModul);
        }
        catch(ModuleOverloadException e){
            System.out.println(e.getMessage());
        }

        //Erzeugung des Mathematik-Moduls
        try{
            matheModul = new Modul("Mathematik",
                    new Lehrveranstaltung("Algebra", 5),
                    new Lehrveranstaltung("Analysis", 5),
                    new Lehrveranstaltung("Statistik", 5),
                    new Lehrveranstaltung("Diskrete Mathematik", 5)
            );
            ModulContainer.getModulContainerReferenz().addModul(matheModul);
        }
        catch(ModuleOverloadException e){
            System.out.println(e.getMessage());
        }

        System.out.print("Modul ");
        ausgeben(informatikModul);
        System.out.print("Modul ");
        ausgeben(matheModul);

        ///Personalisierte Lehrveranstaltungen
        Lehrveranstaltung erstePersonalisierteLV = new Lehrveranstaltung("Lineare Optimierung", 2);
        Lehrveranstaltung zweitePersonalisierteLV = new Lehrveranstaltung("Mittelwertbestimmung", 3);

        //Erzeugung des personalisierten Moduls
        Modul alternativesModul = null;
        try {
            alternativesModul = new Modul("Mathematik II", erstePersonalisierteLV);
            ModulContainer.getModulContainerReferenz().addModul(alternativesModul);
            alternativesModul.addLehrveranstaltung(zweitePersonalisierteLV);
        } catch (ModuleOverloadException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ausgeben(CreditPointI creditPointI) {
        if(creditPointI != null){
            System.out.println("\"" + creditPointI.getName() + "\" (" + creditPointI.getAnzahlCPs() + " CPs)");
        }
        else{
            System.out.println("\tKein zulässiger Datensatz.");
        }
    }
}
