package br.dev.diegocorte.controlyourmoney.persistence;

import android.util.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.dev.diegocorte.controlyourmoney.models.Bill;
import br.dev.diegocorte.controlyourmoney.models.Category;

public class InMemoryDatabase {
    private static final List<Category> categories = new ArrayList<>();
    private static final List<Bill> bills = new ArrayList<>();

    public List<Category> findAllCategories() {
        return new ArrayList<>(categories);
    }

    public List<Bill> findAllBills() {
        return new ArrayList<>(bills);
    }

    public void saveCategory(Category category) {
        categories.add(category);
    }

    public void saveBill(Bill bill) {
        bills.add(bill);
    }

    public Category findCategoryByIndex(int index) {
        return categories.get(index);
    }


    public int getAmountByCategory(Category category) {
        int count = 0;

        for (Bill bill : bills) {
            if (bill.getCategory().equals(category))
                count++;
        }

        return count;
    }

    public void removeCategory(Category category) {
        categories.remove(category);
    }

    public Bill findBillByIndex(int index) {
        return bills.get(index);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
    }

    public BigDecimal getTotalValueByCategory(Category category) {
        BigDecimal totalValue = BigDecimal.ZERO;

        for (Bill bill : bills) {
            if (bill.getCategory().equals(category)) {
                totalValue = totalValue.add(bill.getValue());
            }
        }

        return totalValue;

    }

    public List<Bill> findAllBillsByCategory(Category selectedCategory) {
        return bills.stream().filter(bill -> bill.getCategory().equals(selectedCategory)).collect(Collectors.toList());
    }
}

