package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class NavetteInconnuException extends Exception {

    /**
     * Creates a new instance of <code>NavetteInconnuException</code> without detail message.
     */
    public NavetteInconnuException() {
    }

    /**
     * Constructs an instance of <code>NavetteInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NavetteInconnuException(String msg) {
        super(msg);
    }
}
