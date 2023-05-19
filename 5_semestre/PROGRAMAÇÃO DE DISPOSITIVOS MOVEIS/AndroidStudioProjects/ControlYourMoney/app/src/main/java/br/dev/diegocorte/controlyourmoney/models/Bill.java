package br.dev.diegocorte.controlyourmoney.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class Bill {

    private String name;
    private Calendar calendar;
    private Category category;
    private BigDecimal value;

    public Bill(String name, Calendar calendar, Category category, BigDecimal value) {
        this.name = name;
        this.calendar = calendar;
        this.category = category;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return name.equals(bill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        String text = String.format("Bill{name='%s', category='%s', calendar='%s', value=%f}",
                name, category.getName(), calendar.toString(), value);
        return text;
    }
}
