package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class RevisionInconnuException extends Exception {

    /**
     * Creates a new instance of <code>RevisionInconnuException</code> without detail message.
     */
    public RevisionInconnuException() {
    }

    /**
     * Constructs an instance of <code>RevisionInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RevisionInconnuException(String msg) {
        super(msg);
    }
}
