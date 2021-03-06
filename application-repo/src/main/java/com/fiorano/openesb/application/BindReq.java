/*
 * Copyright (c) Fiorano Software and affiliates. All rights reserved. http://www.fiorano.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.fiorano.openesb.application;

import com.fiorano.openesb.utils.exception.FioranoException;

/**
 * <p><strong> </strong> represents </p>
 *
 * @author FSIPL
 * @created April 13, 2005
 * @version 1.0
 */
public class BindReq extends DmiObject
{

    private String  m_strServInstName;
    private String  m_strAppName;
    private String  m_strConnectionID;

    /**
     */
    public BindReq()
    {
    }

    /**
     *  Gets the servInstName attribute of the RuntimeArgsReq object
     *
     * @return The servInstName value
     */
    public String getServInstName()
    {
        return m_strServInstName;
    }

    /**
     *  Gets the appName attribute of the RuntimeArgsReq object
     *
     * @return The appName value
     */
    public String getAppName()
    {
        return m_strAppName;
    }


    /**
     *  Gets the connectionID attribute of the RuntimeArgsReq object
     *
     * @return The connectionID value
     */
    public String getConnectionID()
    {
        return m_strConnectionID;
    }

    /**
     *  Gets the objectID attribute of the LoginInfo object
     *
     * @return The objectID value
     */
    public int getObjectID()
    {
        return DmiObjectTypes.BIND_REQ;
    }

    /**
     *  Sets the servInstName attribute of the RuntimeArgsReq object
     *
     * @param servInstName The new servInstName value
     */
    public void setServInstName(String servInstName)
    {
        m_strServInstName = servInstName;
    }

    /**
     *  Sets the appName attribute of the RuntimeArgsReq object
     *
     * @param appName The new appName value
     */
    public void setAppName(String appName)
    {
        m_strAppName = appName;
    }

    /**
     *  Sets the connectionID attribute of the RuntimeArgsReq object
     *
     * @param connectionID The new connectionID value
     */
    public void setConnectionID(String connectionID)
    {
        m_strConnectionID = connectionID;
    }

    /**
     *  Description of the Method
     *
     * @param os Description of the Parameter
     * @param versionNo Description of the Parameter
     * @exception java.io.IOException Description of the Exception
     */
    public void toStream(java.io.DataOutput os, int versionNo)
        throws java.io.IOException
    {
        super.toStream(os, versionNo);
        writeUTF(os, m_strAppName);
        writeUTF(os, m_strServInstName);
        writeUTF(os, m_strConnectionID);
    }

    /**
     *  Description of the Method
     *
     * @param is Description of the Parameter
     * @param versionNo Description of the Parameter
     * @exception java.io.IOException Description of the Exception
     */
    public void fromStream(java.io.DataInput is, int versionNo)
        throws java.io.IOException
    {
        super.fromStream(is, versionNo);
        m_strAppName = readUTF(is);
        m_strServInstName = readUTF(is);
        m_strConnectionID = readUTF(is);
    }


    /**
     *  Description of the Method
     *
     * @exception FioranoException Description of the Exception
     */
    public void validate()
        throws FioranoException
    {
    }

    /**
     *  Description of the Method
     */
    public void reset()
    {
    }



}
