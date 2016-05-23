/*
 * Copyright (c) Fiorano Software and affiliates. All rights reserved. http://www.fiorano.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.fiorano.openesb.route;

public abstract class RouteOperationConfiguration {
    RouteOperationType operationType;

    public RouteOperationType getRouteOperationType() {
        return operationType;
    }

    public void setRouteOperationType(RouteOperationType operationType) {
        this.operationType = operationType;
    }
}
