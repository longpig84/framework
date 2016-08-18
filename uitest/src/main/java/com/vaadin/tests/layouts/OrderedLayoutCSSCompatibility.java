package com.vaadin.tests.layouts;

import com.vaadin.legacy.ui.LegacyTextField;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.HorizontalLayout;

public class OrderedLayoutCSSCompatibility extends TestBase {

    @Override
    protected String getDescription() {
        return "This test is to make sure that spacing/margins in OrderedLayout is still backwards compatible";
    }

    @Override
    protected Integer getTicketNumber() {
        return 2463;
    }

    @Override
    protected void setup() {
        HorizontalLayout l = new HorizontalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.addComponent(new LegacyTextField("abc"));
        l.addComponent(new LegacyTextField("def"));

        addComponent(l);

    }

}