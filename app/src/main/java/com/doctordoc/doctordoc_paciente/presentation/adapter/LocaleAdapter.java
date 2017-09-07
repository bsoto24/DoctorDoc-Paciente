package com.doctordoc.doctordoc_paciente.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.data.entity.CitaTO;
import com.doctordoc.doctordoc_paciente.data.entity.Locale;

import java.util.List;

/**
 * Created by Bryam Soto on 29/05/2017.
 */

public class LocaleAdapter extends RecyclerView.Adapter<LocaleAdapter.LocaleViewHolder> {

    private List<Locale> locales;
    private Context context;

    public LocaleAdapter(List<Locale> locales, Context context){
        this.locales = locales;
        this.context = context;
    }

    @Override
    public LocaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_locale, parent, false);
        LocaleViewHolder holder = new LocaleViewHolder(v);
        return holder;
    }

    @Override
    public int getItemCount() {
        return locales.size();
    }

    @Override
    public void onBindViewHolder(LocaleViewHolder holder, final int position) {
        final Locale locale = locales.get(position);
        holder.tvClinica.setText(locale.getLocalNombre());
        holder.tvDireccion.setText(locale.getLocalDireccion());
        holder.tvHorario.setText(locale.getLocalHorario());
        holder.imgClinica.setImageResource(locale.getImgFoto());
    }


    public static class LocaleViewHolder extends RecyclerView.ViewHolder{

        private TextView tvClinica ;
        private TextView tvHorario ;
        private TextView tvDireccion ;
        private ImageView imgClinica;

        public LocaleViewHolder(View itemView) {
            super(itemView);
            tvClinica = (TextView) itemView.findViewById(R.id.tv_clinica);
            tvHorario = (TextView) itemView.findViewById(R.id.tv_hora);
            tvDireccion = (TextView) itemView.findViewById(R.id.tv_direccion);
            imgClinica = (ImageView) itemView.findViewById(R.id.img_clinica);
        }
    }
}
