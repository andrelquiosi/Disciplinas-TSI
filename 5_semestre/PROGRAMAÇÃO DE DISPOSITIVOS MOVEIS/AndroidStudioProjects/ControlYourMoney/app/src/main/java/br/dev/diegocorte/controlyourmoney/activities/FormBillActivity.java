package br.dev.diegocorte.controlyourmoney.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.dev.diegocorte.controlyourmoney.R;
import br.dev.diegocorte.controlyourmoney.models.Bill;
import br.dev.diegocorte.controlyourmoney.models.Category;
import br.dev.diegocorte.controlyourmoney.persistence.InMemoryDatabase;

public class FormBillActivity extends AppCompatActivity {

    private static final String SELECTED_CATEGORY = "selected_category";

    private InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
    private Category selectedCategory;
    private Date billDate;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private EditText billNameField;
    private EditText billDateField;
    private EditText billValueField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_bill);
        getSelectedCategory();
        bindViews();
        setUpSaveButton();
        setUpDatePicker();
        setUpTitle();

    }

    private void bindViews() {

        billNameField = findViewById(R.id.billFormBillName);
        billDateField = findViewById(R.id.billFormBillDate);
        billValueField = findViewById(R.id.billFormBillValue);

    }

    private void setUpSaveButton() {

        Button save = findViewById(R.id.billFormBillSave);
        save.setOnClickListener(view -> saveBill());

    }

    private void setUpTitle() {

        TextView title = findViewById(R.id.billFormBillTitle);
        title.setText(selectedCategory.getName());

    }

    private void setUpDatePicker() {

        billDateField.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                showDatePicker();
            }
        });
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(FormBillActivity.this, (datePicker, year, month, day) -> {
            onDateSet(year, month, day);
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void onDateSet(int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        billDate = calendar.getTime();
        billDateField.setText(simpleDateFormat.format(billDate));
    }

    private void saveBill() {
        Bill bill = createNewBill();

        if (bill.getValue().compareTo(BigDecimal.ZERO) > 0 && !bill.getName().isEmpty()) {
            inMemoryDatabase.saveBill(bill);
        }

        finish();
    }

    @NonNull
    private Bill createNewBill() {
        String billName = billNameField.getText().toString();
        Calendar billDate = Calendar.getInstance();

        try {
            billDate.setTime(simpleDateFormat.parse(billDateField.getText().toString()));
        } catch (ParseException ignored) {
        }

        BigDecimal billValue = BigDecimal.ZERO;

        try {
            billValue = new BigDecimal(billValueField.getText().toString());
        } catch (NumberFormatException ignored) {
        }
        return new Bill(billName, billDate, selectedCategory, billValue);
    }

    private void getSelectedCategory() {
        selectedCategory = (Category) getIntent().getSerializableExtra(SELECTED_CATEGORY);
    }

}
