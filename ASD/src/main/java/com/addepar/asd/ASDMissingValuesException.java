/**************************************************************************
**
**                  < ASDMissingValuesException.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ASDMissingValuesException.java
**
**  Author       : Addepar Infrastructure Platform Tools Team 
**                          
**  Date         : 13 Jun 2022
**
**  Version      : 0.0.1
**
**  Modification : Some
**
**  Application  :
**
**  Functions    :
**
**  Description  :
**
**  Notes        :
**
**
**************************************************************************/


/**************************************************************************
**
**                               Copyright
**
**                   (C) Copyright 2022 Addepar, Inc.
**                         <iptools@addepar.com>
**
**                          All Rights Reserved
**
**************************************************************************/


/**************************************************************************
**
**                                Package
**
**************************************************************************/
package com.addepar.asd;



/**************************************************************************
**
**                                Imports
**
**************************************************************************/


/**
 *
 * @author Josef Grosch (josef.grosch@addepar.com)
 */
public class ASDMissingValuesException extends Exception {

    /**
     * Creates a new instance of <code>ASDException</code> without detail
     * message.
     */
    public ASDMissingValuesException() {
        super();
    }

    /**
     * Constructs an instance of <code>ASDException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ASDMissingValuesException(String msg) {
        super(msg);
    }

}   // End of class ASDMissingValuesException.java


/**************************************************************************
**
**               < End of ASDMissingValuesException.java >
**
**************************************************************************/
