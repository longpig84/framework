/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.event.dnd;

import java.lang.reflect.Method;

import com.vaadin.event.ConnectorEventListener;

/**
 * Interface to be implemented when creating a dragstart listener on a drag
 * source for HTML5 drag and drop.
 *
 * @see DragSourceExtension#addDragStartListener(DragStartListener)
 */
@FunctionalInterface
public interface DragStartListener extends ConnectorEventListener {
    static final Method DRAGSTART_METHOD = DragStartListener.class
            .getDeclaredMethods()[0];

    /**
     * Called when a server side dragstart event is fired.
     *
     * @param event
     *         The dragstart event that is fired.
     */
    void dragStart(DragStartEvent event);
}
