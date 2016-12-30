/**
 * Die Klasse ModuleOverloadException modelliert eine Ausnahme, die auftritt, wenn einem Modul mehr als die zulässige
 * Maximalzahl an Lehrveranstaltungen zugeordnet wird.
 *
 * Erstellt von M. Lintl am 14.12.2016.
 */
public class ModuleOverloadException extends Exception {
    ModuleOverloadException(String message){ super(message); }
}
