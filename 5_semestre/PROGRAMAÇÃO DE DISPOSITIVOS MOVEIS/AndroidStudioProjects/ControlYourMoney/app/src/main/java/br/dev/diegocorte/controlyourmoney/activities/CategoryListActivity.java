package br.dev.diegocorte.controlyourmoney.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.concurrent.atomic.AtomicBoolean;

import br.dev.diegocorte.controlyourmoney.R;
import br.dev.diegocorte.controlyourmoney.adapters.CategoryListAdapter;
import br.dev.diegocorte.controlyourmoney.listeners.RecyclerItemClickListener;
import br.dev.diegocorte.controlyourmoney.models.Category;
import br.dev.diegocorte.controlyourmoney.persistence.InMemoryDatabase;

public class CategoryListActivity extends AppCompatActivity {

    private InMemoryDatabase inMemoryDatabase;
    private CategoryListAdapter adapter;
    private final AtomicBoolean isLongClick = new AtomicBoolean(false);
    private Category selectedCategory;

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        initializeAttributes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateView();
    }

    private void initializeAttributes() {
        inMemoryDatabase = new InMemoryDatabase();
        adapter = new CategoryListAdapter(inMemoryDatabase.findAllCategories(), inMemoryDatabase);
        setUpAddCategoryButton();
        setUpLauncher();
        setUpRecyclerView();
    }

    private void setUpAddCategoryButton() {
        FloatingActionButton addCategory = findViewById(R.id.categoryListAddCategory);
        addCategory.setOnClickListener(view -> redirectToCategoryFormActivity());
    }

    private void redirectToActivity(Class<?> activityClass, Category selectedCategory) {
        Intent intent = new Intent(this, activityClass);
        if (selectedCategory != null) {
            intent.putExtra("selected_category", selectedCategory);
        }
        launcher.launch(intent);
    }

    private void redirectToCategoryFormActivity() {
        redirectToActivity(FormCategoryActivity.class, null);
    }

    private void redirectToBillListActivity(Category selectedCategory) {
        redirectToActivity(BillListActivity.class, selectedCategory);
    }

    private void setUpLauncher() {
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        updateView();
                    }
                });
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.categoryListRecyclerView);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, this::onCategoryClick, this::onCategoryLongClick));
    }

    private void onCategoryClick(View view, int position) {
        if (!isLongClick.get()) {
            selectedCategory = inMemoryDatabase.findCategoryByIndex(position);
            redirectToBillListActivity(selectedCategory);
        } else {
            isLongClick.set(false);
        }
    }

    private void onCategoryLongClick(View view, int position) {
        isLongClick.set(true);

        removeAndShowMessage(position);

        updateView();
    }

    private void updateView() {
        adapter.update(inMemoryDatabase.findAllCategories());
    }

    private void removeAndShowMessage(int position) {
        Category category = inMemoryDatabase.findCategoryByIndex(position);

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Confirmação");
        alertBuilder.setMessage("Deseja realmente remover a categoria " +
                category.getName() + "?");

        alertBuilder.setPositiveButton("Sim", (dialogInterface, i) -> {
            inMemoryDatabase.removeCategory(category);
            updateView();
        });

        alertBuilder.setCancelable(false);
        alertBuilder.setNegativeButton("Não", null);
        alertBuilder.show();
    }

}
