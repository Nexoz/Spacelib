package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class AdministrateurInconnuException extends Exception {

    /**
     * Creates a new instance of <code>AdministrateurInconnuException</code> without detail message.
     */
    public AdministrateurInconnuException() {
    }

    /**
     * Constructs an instance of <code>AdministrateurInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public AdministrateurInconnuException(String msg) {
        super(msg);
    }
}
