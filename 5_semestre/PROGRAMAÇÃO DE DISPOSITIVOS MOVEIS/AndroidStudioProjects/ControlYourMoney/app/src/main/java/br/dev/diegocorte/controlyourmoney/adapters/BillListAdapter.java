package br.dev.diegocorte.controlyourmoney.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.dev.diegocorte.controlyourmoney.R;
import br.dev.diegocorte.controlyourmoney.models.Bill;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.ViewHolder> {

    private Context context;
    private List<Bill> bills;

    public BillListAdapter(Context context, List<Bill> bills) {
        this.context = context;
        this.bills = bills;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bill_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bill bill = bills.get(position);
        holder.link(bill);
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    public void update(List<Bill> all) {
        bills.clear();
        bills.addAll(all);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        public void link(Bill bill) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            TextView billName = itemView.findViewById(R.id.billListItemName);
            TextView billDate = itemView.findViewById(R.id.billListItemDate);
            TextView billTotalValue = itemView.findViewById(R.id.billListItemTotalValue);

            billName.setText(bill.getName());
            billDate.setText(simpleDateFormat.format(bill.getCalendar().getTime()));
            billTotalValue.setText("R$ " + bill.getValue().toString());
        }
    }
}
