package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class UsagerInconnuException extends Exception {

    /**
     * Creates a new instance of <code>UtilisateurInconnuException</code> without detail message.
     */
    public UsagerInconnuException() {
    }

    /**
     * Constructs an instance of <code>UtilisateurInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UsagerInconnuException(String msg) {
        super(msg);
    }
}
