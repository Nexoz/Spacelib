package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class QuaiInconnuException extends Exception {

    /**
     * Creates a new instance of <code>QuaiInconnuException</code> without detail message.
     */
    public QuaiInconnuException() {
    }

    /**
     * Constructs an instance of <code>QuaiInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public QuaiInconnuException(String msg) {
        super(msg);
    }
}
