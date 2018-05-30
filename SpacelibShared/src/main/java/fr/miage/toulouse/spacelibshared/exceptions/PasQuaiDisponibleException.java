package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class PasQuaiDisponibleException extends Exception {

    /**
     * Creates a new instance of <code>AdministrateurInconnuException</code> without detail message.
     */
    public PasQuaiDisponibleException() {
    }

    /**
     * Constructs an instance of <code>AdministrateurInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public PasQuaiDisponibleException(String msg) {
        super(msg);
    }
}
