
package com.addepar.asd;

/**
 *
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class ASDKeyNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ASDKeyNotFoundException</code> without
     * detail message.
     */
    public ASDKeyNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ASDKeyNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ASDKeyNotFoundException(String msg) {
        super(msg);
    }
}
