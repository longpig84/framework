package com.vaadin.tests.components;

import com.vaadin.legacy.ui.LegacyTextField;
import com.vaadin.ui.Button;

public class MultipleDebugIds extends TestBase {

    @Override
    protected String getDescription() {
        return "An exception should be thrown if the same debugId is assigned to several components";
    }

    @Override
    protected Integer getTicketNumber() {
        return 2796;
    }

    @Override
    protected void setup() {
        LegacyTextField textField = new LegacyTextField();
        LegacyTextField textField2 = new LegacyTextField();
        Button button = new Button();
        Button button2 = new Button();
        textField.setId("textfield");
        button.setId("button");
        textField2.setId("textfield2");
        button2.setId("textfield");

        addComponent(textField);
        addComponent(textField2);
        addComponent(button);
        addComponent(button2);
    }

}