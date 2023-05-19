package br.dev.diegocorte.controlyourmoney.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.dev.diegocorte.controlyourmoney.R;
import br.dev.diegocorte.controlyourmoney.models.Category;
import br.dev.diegocorte.controlyourmoney.persistence.InMemoryDatabase;

public class FormCategoryActivity extends AppCompatActivity {

    private InMemoryDatabase inMemoryDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_category);
        inMemoryDatabase = new InMemoryDatabase();
        setUpSaveButton();

    }

    private void setUpSaveButton() {

        Button save = findViewById(R.id.categoryFormSave);
        save.setOnClickListener(view -> saveCategory());

    }

    private void saveCategory() {

        EditText categoryNameField = findViewById(R.id.categoryFormCategoryName);
        EditText descriptionField = findViewById(R.id.categoryFormDescription);
        String categoryName = categoryNameField.getText().toString().trim();
        String description = descriptionField.getText().toString().trim();

        if (!categoryName.isEmpty()) {
            Category category = new Category(categoryName, description);
            inMemoryDatabase.saveCategory(category);
        }

        finish();
    }
}