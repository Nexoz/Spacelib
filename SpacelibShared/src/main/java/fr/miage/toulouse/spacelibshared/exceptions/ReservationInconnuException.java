package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class ReservationInconnuException extends Exception {

    /**
     * Creates a new instance of <code>ReservationInconnuException</code> without detail message.
     */
    public ReservationInconnuException() {
    }

    /**
     * Constructs an instance of <code>ReservationInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ReservationInconnuException(String msg) {
        super(msg);
    }
}
