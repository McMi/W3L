import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse ModulContainer nutzt das Singleton-Pattern, um einen Container für die Speicherung aller Module bereitzustellen.
 *
 * Erstellt von M. Lintl am 15.12.2016.
 */
public class ModulContainer {
    private static ModulContainer modulContainerReferenz = null;

    private List<Modul> module;

    private ModulContainer(){
        this.module = new ArrayList<>();
    }

    public static ModulContainer getModulContainerReferenz(){
        if(modulContainerReferenz == null){
            modulContainerReferenz = new ModulContainer();
        }
        return modulContainerReferenz;
    }

    public List<Modul> getModule(){
        return this.module;
    }

    public void addModul(Modul einModul){
        this.module.add(einModul);
    }
}
