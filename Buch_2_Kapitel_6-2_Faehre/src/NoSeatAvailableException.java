/**
 * Die Klasse NoSeatAvailableException modelliert eine Ausnahmesituation, die auftritt, wenn das beim Versuch einen Beifahrer
 * zu einem Fahrzeug hinzuzufügen, die maximale Beifahreranzahl überschritten würde.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class NoSeatAvailableException extends Exception {
    NoSeatAvailableException(String message) {
        super(message);
    }
}
