package cl.dv.listacompras.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.dv.listacompras.Compras
import cl.dv.listacompras.R

class comprasAdapter(private val comprasList:List<Compras>) : RecyclerView.Adapter<comprasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): comprasViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return comprasViewHolder(layoutInflater.inflate(R.layout.item_compras, parent, false))
    }

    override fun getItemCount(): Int = comprasList.size

    override fun onBindViewHolder(holder: comprasViewHolder, position: Int) {
        val item = comprasList[position]
        holder.render(item)

    }
}