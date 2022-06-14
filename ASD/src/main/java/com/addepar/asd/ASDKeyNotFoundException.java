
/**************************************************************************
**
**                   < ASDKeyNotFoundException.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ASDKeyNotFoundException.java
**
**  Author       : Addepar Infrastructure Platform Tools Team 
**                          
**  Date         : 13 Jun 2022
**
**  Version      : 1.0
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
 * @author Josef Grosch -- josef.grosch@addepar.com 
 */
public class ASDKeyNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ASDKeyNotFoundException</code> without
     * detail message.
     */
    public ASDKeyNotFoundException() {
        super();
    }   // End of ASDKeyNotFoundException

    /**
     * Constructs an instance of <code>ASDKeyNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ASDKeyNotFoundException(String msg) {
        super(msg);
    }   // End of ASDKeyNotFoundException

}   // End of class ASDKeyNotFoundException


/**************************************************************************
**
**                < End of ASDKeyNotFoundException.java >
**
**************************************************************************/
