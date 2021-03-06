/*
 * Copyright (c) Fiorano Software and affiliates. All rights reserved. http://www.fiorano.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.fiorano.openesb.application.configuration.data;

import com.fiorano.openesb.application.DmiObjectTypes;
import com.fiorano.openesb.utils.exception.FioranoException;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PortConfigurationNamedObject extends NamedObject {
    private DestinationType destinationType;
    private PortType portType;

    public PortConfigurationNamedObject() {}

    /**
     * Constructs PortConfigurationNamed Object
     *
     * @param name Config name
     * @param label Environment label
     * @param objectCategory  ObjectCategory (In this case:Port)
     * @param destinationType  Destination Type(Topic/Queue)
     * @param portType  Port Type(Input/Output)
     */
    public PortConfigurationNamedObject(String name, Label label, ObjectCategory objectCategory, DestinationType destinationType, PortType portType) {
        super(name, label, objectCategory);
        this.destinationType = destinationType;
        this.portType = portType;
    }

    /**
     * Gets Destination type
     * @return  Destination type(Topic/Queue)
     */
    public DestinationType getDestinationType() {
        return destinationType;
    }

    /**
     * Gets Port type
     * @return Port type(Input/Output)
     */
    public PortType getPortType() {
        return portType;
    }

    public ObjectCategory getObjectCategory() {
        return ObjectCategory.PORT_CONFIGURATION;
    }

    public void setObjectCategory(ObjectCategory objectCategory) throws UnsupportedOperationException {
        if(objectCategory == null || !objectCategory.equals(ObjectCategory.PORT_CONFIGURATION))
            throw new UnsupportedOperationException("OBJECT_CATEGORY_READ_ONLY");
    }

    /**
     * Sets Destination type
     * @param destinationType Destination type (Topic/Queue)
     */
    public void setDestinationType(DestinationType destinationType) {
        this.destinationType = destinationType;
    }

    /**
     * Sets Port type
     * @param portType Port type (Input/Output)
     */
    public void setPortType(PortType portType) {
        this.portType = portType;
    }

    /**
     * Returns ID of this object.
     *
     * @return the id of this object.
     * @since Tifosi2.0
     */
    public int getObjectID() {
        return DmiObjectTypes.PORT_CONFIGURATION_NAMED_OBJECT;
    }

    /**
     * Resets the values of the data members of the object. This
     * may possibly be used to help the Dmifactory reuse Dmi objects.
     *
     * @since Tifosi2.0
     */
    public void reset() {
        super.reset();
        destinationType = null;
        portType = null;
    }

    /**
     * Tests whether this <code>DmiObject</code> object has the
     * required(mandatory) fields set. This method must be called before
     * inserting values in the database.
     *
     * @throws com.fiorano.openesb.utils.exception.FioranoException if the object is not valid
     * @since Tifosi2.0
     */
    public void validate() throws FioranoException {
        super.validate();
    }

    /**
     * Writes this object to specified output stream <code>out</code>
     *
     * @param out       output stream
     * @param versionNo version
     * @throws IOException If an error occurs while writing to stream
     */
    public void toStream(DataOutput out, int versionNo) throws IOException {
        super.toStream(out, versionNo);
        writeUTF(out, destinationType != null ? destinationType.toString() : null);
        writeUTF(out, portType != null ? portType.toString() : null);
    }

    /**
     * Reads this object from specified stream <code>is</code>
     *
     * @param is        input stream
     * @param versionNo version
     * @throws IOException If an error occurs while reading from stream
     */
    public void fromStream(DataInput is, int versionNo) throws IOException {
        super.fromStream(is, versionNo);
        destinationType = readDestinationType(readUTF(is));
        portType = readPortType(readUTF(is));
    }

    private PortType readPortType(String portType) {
        if(portType == null)
            return null;

        return PortType.getPortType(portType);
    }

    private DestinationType readDestinationType(String destinationType) {
        if(destinationType == null)
            return null;

        return DestinationType.valueOf(destinationType);
    }
}
