package br.dev.diegocorte.controlyourmoney.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.dev.diegocorte.controlyourmoney.R;
import br.dev.diegocorte.controlyourmoney.models.Category;
import br.dev.diegocorte.controlyourmoney.persistence.InMemoryDatabase;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private List<Category> categories;
    private InMemoryDatabase database;

    public CategoryListAdapter(List<Category> categories, InMemoryDatabase database) {
        this.categories = categories;
        this.database = database;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void update(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryName;
        private TextView description;
        private TextView totalValue;
        private TextView amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryListItemName);
            description = itemView.findViewById(R.id.categoryListItemDescription);
            totalValue = itemView.findViewById(R.id.categoryListItemTotalValue);
            amount = itemView.findViewById(R.id.categoryListItemAmount);
        }

        public void bind(Category category) {
            categoryName.setText(category.getName());
            description.setText(category.getDescription());
            amount.setText(String.valueOf(database.getAmountByCategory(category)));
            totalValue.setText("R$ " + database.getTotalValueByCategory(category));
        }
    }
}