package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class PasNavetteDisponibleException extends Exception {

    /**
     * Creates a new instance of <code>AdministrateurInconnuException</code> without detail message.
     */
    public PasNavetteDisponibleException() {
    }

    /**
     * Constructs an instance of <code>AdministrateurInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public PasNavetteDisponibleException(String msg) {
        super(msg);
    }
}
