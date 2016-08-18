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
package com.vaadin.tests.components.grid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.SingleBrowserTest;
import com.vaadin.v7.testbench.customelements.GridElement;

public class GridItemSetChangeTest extends SingleBrowserTest {

    @Test
    public void testValueChangeListenersWorkAfterItemSetChange() {
        openTestURL();

        GridElement grid = $(GridElement.class).first();
        assertEquals("Last name initially wrong", "Bar",
                grid.getCell(0, 1).getText());

        $(ButtonElement.class).caption("Modify").first().click();
        assertEquals("Last name was not updated", "Spam",
                grid.getCell(0, 1).getText());

        $(ButtonElement.class).caption("Reset").first().click();
        assertEquals("Last name was not updated on reset", "Baz",
                grid.getCell(0, 1).getText());

        $(ButtonElement.class).caption("Modify").first().click();
        assertEquals("Last name was not updated after reset modification",
                "Spam", grid.getCell(0, 1).getText());
    }
}
