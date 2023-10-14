package cl.dv.listacompras.adapter

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cl.dv.listacompras.Compras
import cl.dv.listacompras.R
import cl.dv.listacompras.databinding.ItemComprasBinding

class comprasViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemComprasBinding.bind(view)

    fun render(comprasModel: Compras){
        binding.itemNombre.text = comprasModel.nombre
        binding.itemEspecificacion.text = comprasModel.especificacion
        binding.itemCantidad.text = comprasModel.cantidad
        binding.itemPrecio.text = comprasModel.precio

        itemView.setOnClickListener{Toast.makeText(binding.itemNombre.context, comprasModel.nombre, Toast.LENGTH_SHORT).show()}
    }

}