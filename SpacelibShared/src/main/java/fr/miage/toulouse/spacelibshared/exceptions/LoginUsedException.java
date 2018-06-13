package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class LoginUsedException extends Exception {

    /**
     * Creates a new instance of <code>UtilisateurInconnuException</code> without detail message.
     */
    public LoginUsedException() {
    }

    /**
     * Constructs an instance of <code>UtilisateurInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public LoginUsedException(String msg) {
        super(msg);
    }
}
