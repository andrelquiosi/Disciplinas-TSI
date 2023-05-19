package br.dev.diegocorte.controlyourmoney.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.concurrent.atomic.AtomicBoolean;

import br.dev.diegocorte.controlyourmoney.R;
import br.dev.diegocorte.controlyourmoney.adapters.BillListAdapter;
import br.dev.diegocorte.controlyourmoney.listeners.RecyclerItemClickListener;
import br.dev.diegocorte.controlyourmoney.models.Bill;
import br.dev.diegocorte.controlyourmoney.models.Category;
import br.dev.diegocorte.controlyourmoney.persistence.InMemoryDatabase;

public class BillListActivity extends AppCompatActivity {

    private InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
    private BillListAdapter adapter;

    private Category selectedCategory;

    private Category updatedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);
        selectedCategory = (Category) getIntent().getSerializableExtra("selected_category");
        initializeCategoryListAdapter();
        setUpRecyclerView();
        setUpAddBillButton();
        updatedCategory = selectedCategory;
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.update(inMemoryDatabase.findAllBillsByCategory(selectedCategory));
    }

    private void initializeCategoryListAdapter() {
        adapter = new BillListAdapter(this, inMemoryDatabase.findAllBillsByCategory(selectedCategory));
    }

    private void setUpAddBillButton() {
        FloatingActionButton addBill = findViewById(R.id.billListAddBill);
        addBill.setOnClickListener(view -> redirectToFormBillActivity());
    }

    private void redirectToFormBillActivity() {
        selectedCategory = (Category) getIntent().getSerializableExtra("selected_category");
        Intent intent = new Intent(this, FormBillActivity.class);
        intent.putExtra("selected_category", selectedCategory);
        launcher.launch(intent);
    }

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
            }
    );

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.billListRecyclerView);
        recyclerView.setAdapter(adapter);

        AtomicBoolean isLongClick = new AtomicBoolean(false);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                (view, position) -> {
                    if (!isLongClick.get()) {

                    } else {
                        isLongClick.set(false);
                    }
                },
                (view, position) -> {
                    isLongClick.set(true);
                    Bill bill = inMemoryDatabase.findBillByIndex(position);

                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                    alertBuilder.setTitle("Confirmação");
                    alertBuilder.setMessage("Deseja realmente remover a conta " +
                            bill.getName() + "?");

                    alertBuilder.setPositiveButton("Sim", (dialogInterface, i) -> {
                        inMemoryDatabase.removeBill(bill);
                        updateView();
                    });

                    alertBuilder.setCancelable(false);
                    alertBuilder.setNegativeButton("Não", null);
                    alertBuilder.show();

                }));

    }

    private void updateView() {
        adapter.update(inMemoryDatabase.findAllBills());
    }

}