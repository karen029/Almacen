package com.example.almacen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.almacen.R;
import com.example.almacen.entity.Articulo;

import java.util.ArrayList;

public class ArticuloAdapter extends RecyclerView.Adapter<ArticuloAdapter.ViewHolder> {
    Context context; //definimos el contexto, para las consultas
    ArrayList<Articulo> articulos; //definimos el modelo en un ArrayList

    public ArticuloAdapter(Context context, ArrayList<Articulo> articulos) { //constructor para llamar al contexto y el modelo
        this.context = context; //asignamos el contexto que recibimos de parámetro al contexto de la clase
        this.articulos = articulos; //igual con el modelo
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //creación del Holder (vista)
        View v = LayoutInflater.from(context) //creamos la vista desde el contexto de la clase (activity invocadora)
                .inflate(R.layout.item_producto, //asignamos el layout que contiene los objetos del holder (Textview)
                        parent, //hace referencia a su contenedor
                        false); //ponlo para evitar errores :v
        return new ArticuloAdapter //dentro del adapter creamos
                .ViewHolder(v); //el holder, que necesita una vista (la que hemos diseñado unas 3 líneas arriba)
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //funcionalidad del holder
        Articulo articulo = articulos.get(position); //obtenemos la fila "position"
        //obtenemos los datos de la fila "position" y los asignamos en variables String
        final String idArticulo = articulo.getIdArticulo();
        final String nombreArticulo = articulo.getNombreArticulo();
        final String stock = articulo.getStock();
        //asignamos el valor de las variables String a los TextView del Holder
        holder.tvIdArticulo.setText("ID: " + idArticulo);
        holder.tvNombreArticulo.setText(nombreArticulo);
        holder.tvStock.setText(stock);
    }

    @Override
    public int getItemCount() { //cantidad de elementos del holder
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdArticulo, tvNombreArticulo, tvStock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdArticulo = (TextView) itemView.findViewById(R.id.tvIdArticulo);
            tvNombreArticulo = (TextView) itemView.findViewById(R.id.tvNombreArticulo);
            tvStock = (TextView) itemView.findViewById(R.id.tvStock);
        }
    }
}
