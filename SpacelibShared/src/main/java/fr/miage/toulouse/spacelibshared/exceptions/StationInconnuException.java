package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class StationInconnuException extends Exception {

    /**
     * Creates a new instance of <code>StationInconnuException</code> without detail message.
     */
    public StationInconnuException() {
    }

    /**
     * Constructs an instance of <code>StationInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public StationInconnuException(String msg) {
        super(msg);
    }
}
