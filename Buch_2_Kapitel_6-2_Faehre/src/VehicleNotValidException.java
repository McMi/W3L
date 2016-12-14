/**
 * Die Klasse VehicleNotValidException modelliert eine Ausnahmesituation, die auftritt, wenn das Aufladen eines Fahrzeuges
 * auf die Fähre nicht mehr zulässig ist, da dies das Maximalgewicht oder die verfügbare Fläche überschreiten würde.
 *
 * Erstellt von M. Lintl am 08.11.2016.
 */
public class VehicleNotValidException extends Exception {
    VehicleNotValidException(String message) {
        super(message);
    }
}
