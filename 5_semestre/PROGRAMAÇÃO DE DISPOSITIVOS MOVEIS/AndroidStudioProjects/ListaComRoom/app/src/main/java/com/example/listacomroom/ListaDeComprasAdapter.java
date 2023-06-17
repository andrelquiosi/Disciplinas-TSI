package com.example.listacomroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.shoppinglist.db.Category;
import com.example.listacomroom.modelo.ListaDeCompras;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder> {

    private Context context;
    private List<ListaDeCompras> listaDeCompras;
    private HandleCategoryClick clickListener;

    public CategoryListAdapter(Context context, HandleCategoryClick clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setListaDeCompras(List<ListaDeCompras> listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
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
        holder.tvNomeLista.setText(this.listaDeCompras.get(position).getDescricao());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.itemClick(listaDeCompras.get(position));
            }
        });

        holder.editarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.editItem(listaDeCompras.get(position));
            }
        });

        holder.removeLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.removeItem(listaDeCompras.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listaDeCompras == null || listaDeCompras.size() == 0)
            return 0;
        else
            return listaDeCompras.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeLista;
        ImageView removeLista;
        ImageView editarLista;

        public MyViewHolder(View view) {
            super(view);
            tvNomeLista = view.findViewById(R.id.tvCategoryName);
            removeLista = view.findViewById(R.id.removeCategory);
            editarLista = view.findViewById(R.id.editCategory);

        }
    }

    public interface  HandleCategoryClick {
        void itemClick(ListaDeCompras category);
        void removeItem(ListaDeCompras category);
        void editItem(ListaDeCompras category);
    }
}
