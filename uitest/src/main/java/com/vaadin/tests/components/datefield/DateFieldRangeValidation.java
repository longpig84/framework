package com.vaadin.tests.components.datefield;

import java.util.Date;
import java.util.Locale;

import com.vaadin.data.HasValue;
import com.vaadin.data.util.BeanItem;
import com.vaadin.legacy.data.validator.LegacyRangeValidator;
import com.vaadin.legacy.ui.LegacyPopupDateField;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.TestBase;
import com.vaadin.tests.util.CheckBoxWithPropertyDataSource;
import com.vaadin.ui.CheckBox;

public class DateFieldRangeValidation extends TestBase {

    public class Range {
        private Date from, to;
        private boolean fromInclusive = true;
        private boolean toInclusive = true;

        public boolean isFromInclusive() {
            return fromInclusive;
        }

        public void setFromInclusive(boolean fromInclusive) {
            this.fromInclusive = fromInclusive;
        }

        public boolean isToInclusive() {
            return toInclusive;
        }

        public void setToInclusive(boolean toInclusive) {
            this.toInclusive = toInclusive;
        }

        public Date getFrom() {
            return from;
        }

        public void setFrom(Date from) {
            this.from = from;
        }

        public Date getTo() {
            return to;
        }

        public void setTo(Date to) {
            this.to = to;
        }

    }

    private Range range = new Range();

    private LegacyPopupDateField actualDateField;
    private HasValue.ValueChangeListener<Boolean> refreshField = event -> actualDateField
            .markAsDirty();

    @Override
    protected void setup() {
        BeanItem<Range> bi = new BeanItem<Range>(range);
        range.setFrom(new Date(2011 - 1900, 12 - 1, 4));
        range.setTo(new Date(2011 - 1900, 12 - 1, 15));

        LegacyPopupDateField fromField = createDateField();
        fromField.setPropertyDataSource(bi.getItemProperty("from"));
        CheckBox fromInclusive = new CheckBoxWithPropertyDataSource(
                "From inclusive", bi.getItemProperty("fromInclusive"));
        CheckBox toInclusive = new CheckBoxWithPropertyDataSource(
                "To inclusive", bi.getItemProperty("toInclusive"));
        fromInclusive.setImmediate(true);
        fromInclusive.addValueChangeListener(refreshField);
        toInclusive.setImmediate(true);
        toInclusive.addValueChangeListener(refreshField);

        LegacyPopupDateField toField = createDateField();
        toField.setPropertyDataSource(bi.getItemProperty("to"));

        actualDateField = createDateField();
        actualDateField.setValue(new Date(2011 - 1900, 12 - 1, 1));
        actualDateField.addValidator(
                new LegacyRangeValidator<Date>("", Date.class, null, null) {
                    @Override
                    public boolean isMinValueIncluded() {
                        return range.isFromInclusive();
                    }

                    @Override
                    public boolean isMaxValueIncluded() {
                        return range.isToInclusive();
                    }

                    @Override
                    public Date getMaxValue() {
                        return range.getTo();
                    }

                    @Override
                    public Date getMinValue() {
                        return range.getFrom();
                    }

                    @Override
                    public String getErrorMessage() {
                        return "Date must be in range " + getMinValue() + " - "
                                + getMaxValue();
                    }
                });
        addComponent(fromField);
        addComponent(fromInclusive);
        addComponent(toField);
        addComponent(toInclusive);
        addComponent(actualDateField);
    }

    private LegacyPopupDateField createDateField() {
        LegacyPopupDateField df = new LegacyPopupDateField();
        df.setLocale(new Locale("en", "US"));
        df.setResolution(Resolution.DAY);
        df.setBuffered(false);
        df.setImmediate(true);
        return df;
    }

    @Override
    protected String getDescription() {
        return "Tests the DateField range validator. The first field sets the minimum date, the second the maximum. Checkboxes control if the selected date is ok or not.";
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}