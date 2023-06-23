package com.example.listacomroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacomroom.modelo.Setor;

import java.util.List;

public class SetorAdapter extends RecyclerView.Adapter<SetorAdapter.MyViewHolder> {

    private Context context;
    private List<Setor> setorList;
    private HandleListaClick clickListener;

    public SetorAdapter(Context context, HandleListaClick clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setSetor(List<Setor> setores) {
        this.setorList = setores;
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
        holder.tvNomeLista.setText(this.setorList.get(position).getDescricao());
        holder.editarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.editaItem(setorList.get(position));
            }
        });

        holder.removeLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.removeItem(setorList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (setorList == null || setorList.size() == 0)
            return 0;
        else
            return setorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeLista;
        ImageView removeLista;
        ImageView editarLista;

        public MyViewHolder(View view) {
            super(view);
            tvNomeLista = view.findViewById(R.id.tvName);
            removeLista = view.findViewById(R.id.remove);
            editarLista = view.findViewById(R.id.edit);

        }
    }

    public interface HandleListaClick {
        void removeItem(Setor setor);

        void editaItem(Setor setor);
    }
}
