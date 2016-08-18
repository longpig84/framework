package com.vaadin.tests.tickets;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.legacy.ui.LegacyTextField;
import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Notification;

public class Ticket2038 extends LegacyApplication {

    @Override
    public void init() {
        final LegacyWindow w = new LegacyWindow("Testing for #2038");
        setMainWindow(w);

        final LegacyTextField tf = new LegacyTextField(
                "Test-field, enter someting and click outside the field to activate");
        tf.setRequired(true);
        tf.setImmediate(true);
        tf.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                w.showNotification(
                        "TextField is " + (tf.isValid() ? "" : "in")
                                + "valid, with error: " + tf.getErrorMessage(),
                        Notification.TYPE_WARNING_MESSAGE);
            }
        });
        w.addComponent(tf);

        final CheckBox b = new CheckBox(
                "Field should use error message. (!) should be shown when invalid.",
                false);
        w.addComponent(b);
        b.setImmediate(true);
        b.addValueChangeListener(event -> tf.setRequiredError(
                b.getValue() ? "Field must not be empty" : null));
    }

}