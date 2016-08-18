package com.vaadin.tests.components.textfield;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.legacy.ui.LegacyTextField;
import com.vaadin.tests.components.TestBase;

public class TextFieldMaxLengthRemovedFromDOM extends TestBase {

    @Override
    protected void setup() {
        final LegacyTextField tf = new LegacyTextField();
        tf.setMaxLength(11);
        tf.setRequired(true);
        tf.setImmediate(true);
        addComponent(tf);

        tf.addFocusListener(new FieldEvents.FocusListener() {

            @Override
            public void focus(FocusEvent event) {
                // Resetting Max length should not remove maxlength attribute
                tf.setMaxLength(11);
            }
        });
    }

    @Override
    protected String getDescription() {
        return "Maxlength attribute should not dissappear from the DOM when I focus the text field.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 9940;
    }

}