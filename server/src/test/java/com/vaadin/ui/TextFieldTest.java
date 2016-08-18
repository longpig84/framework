/*
 * Copyright 2000-2014 Vaadin Ltd.
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
package com.vaadin.ui;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.legacy.ui.LegacyTextField;

public class TextFieldTest {

    @Test
    public void initiallyEmpty() {
        LegacyTextField tf = new LegacyTextField();
        Assert.assertTrue(tf.isEmpty());
    }

    @Test
    public void emptyAfterClearUsingPDS() {
        LegacyTextField tf = new LegacyTextField(
                new ObjectProperty<String>("foo"));
        Assert.assertFalse(tf.isEmpty());
        tf.clear();
        Assert.assertTrue(tf.isEmpty());
    }

    @Test
    public void emptyAfterClear() {
        LegacyTextField tf = new LegacyTextField();
        tf.setValue("foobar");
        Assert.assertFalse(tf.isEmpty());
        tf.clear();
        Assert.assertTrue(tf.isEmpty());
    }

}