package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class MecanicienInconnuException extends Exception {

    /**
     * Creates a new instance of <code>MecanicienInconnuException</code> without detail message.
     */
    public MecanicienInconnuException() {
    }

    /**
     * Constructs an instance of <code>MecanicienInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MecanicienInconnuException(String msg) {
        super(msg);
    }
}
