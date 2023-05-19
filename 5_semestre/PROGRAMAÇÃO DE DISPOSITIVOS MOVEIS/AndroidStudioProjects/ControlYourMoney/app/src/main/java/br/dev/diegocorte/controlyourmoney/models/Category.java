package br.dev.diegocorte.controlyourmoney.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Category implements Serializable {

    private String name;
    private String description;
    private BigDecimal totalValue;

    private int amount;
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.totalValue = BigDecimal.ZERO;
        this.amount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public int getAmount() {
        return amount;
    }

    public void decrementAmount() {
        this.amount--;
    }

    public void incrementAmount() {
        this.amount++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        String text = String.format("Category{name='%s', amount=%d, totalValue=%f, description='%s'}", name, amount, totalValue, description);
        return text;
    }

}
