package com.example.listacomroom;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacomroom.modelo.Produto;

import java.util.List;

public class ListaProdutosAdapter extends RecyclerView.Adapter<ListaProdutosAdapter.MyViewHolder> {

    private Context context;
    private List<Produto> itemsList;
    private HandleProdutosClick clickListener;

    public ListaProdutosAdapter(Context context, HandleProdutosClick clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setCategoryList(List<Produto> itemsList) {
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvItemName.setText(this.itemsList.get(position).getDescricao());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.produtoClick(itemsList.get(position));
            }
        });

        holder.editCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.editarProduto(itemsList.get(position));
            }
        });

        holder.removeCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.removeProduto(itemsList.get(position));
            }
        });

        if(this.itemsList.get(position).isComprado()) {
            holder.tvItemName.setPaintFlags(holder.tvItemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.tvItemName.setPaintFlags(0);
        }
    }

    @Override
    public int getItemCount() {
        if(itemsList == null || itemsList.size() == 0)
            return 0;
        else
            return itemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName;
        ImageView removeCategory;
        ImageView editCategory;

        public MyViewHolder(View view) {
            super(view);
            tvItemName = view.findViewById(R.id.tvName);
            removeCategory = view.findViewById(R.id.remove);
            editCategory = view.findViewById(R.id.edit);

        }
    }

    public interface HandleProdutosClick {

        void produtoClick(Produto produto);
        void removeProduto(Produto produto);
        void editarProduto(Produto produto);
    }
}
