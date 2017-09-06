package com.doctordoc.doctordoc_paciente.presentation.adapter;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.data.entity.CitaTO;
import com.doctordoc.doctordoc_paciente.data.entity.Familiar;

import java.util.List;

/**
 * Created by Bryam Soto on 29/05/2017.
 */

public class FamiliarAdapter extends RecyclerView.Adapter<FamiliarAdapter.CitaViewHolder> {

    private List<Familiar> familiares;
    private Context context;

    public FamiliarAdapter(List<Familiar> familiares, Context context){
        this.familiares = familiares;
        this.context = context;
    }

    @Override
    public CitaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_familiar, parent, false);
        CitaViewHolder holder = new CitaViewHolder(v);
        return holder;
    }

    @Override
    public int getItemCount() {
        return familiares.size();
    }

    @Override
    public void onBindViewHolder(CitaViewHolder holder, final int position) {
        final Familiar familiar = familiares.get(position);
        holder.tvTipo.setText(familiar.getTipo());
        holder.edtApellido.setText(familiar.getApellidos());
        holder.edtDocumento.setText(familiar.getDocumento());
        holder.edtNombre.setText(familiar.getNombres());
    }


    public static class CitaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTipo;
        private TextInputEditText edtNombre;
        private TextInputEditText edtApellido;
        private TextInputEditText edtDocumento;

        public CitaViewHolder(View itemView) {
            super(itemView);
            tvTipo = (TextView) itemView.findViewById(R.id.tv_tipo);
            edtNombre = (TextInputEditText) itemView.findViewById(R.id.edt_name);
            edtApellido = (TextInputEditText) itemView.findViewById(R.id.edt_last_name);
            edtDocumento = (TextInputEditText) itemView.findViewById(R.id.edt_document);

        }
    }
}
