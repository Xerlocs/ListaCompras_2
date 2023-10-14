package cl.dv.listacompras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import cl.dv.listacompras.Entidad.Producto
import cl.dv.listacompras.R

class listaCompraAdapter(
    contexto: Context,
    recursos: Int,
    producto: List<Producto>
) : ArrayAdapter<Producto>(contexto, recursos, producto){

    override fun getView(posicion: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val compraView = convertView ?: inflater.inflate(R.layout.item_compras, null)

        // Get the patient data at the current position
        val producto = getItem(posicion)

        // Bind patient data to TextViews in the custom layout
        val nombreTextView = compraView.findViewById<TextView>(R.id.item_nombre)
        val recursosTextView = compraView.findViewById<TextView>(R.id.item_especificacion)
        val cantidadTextView = compraView.findViewById<TextView>(R.id.item_cantidad)
        val precioTextView = compraView.findViewById<TextView>(R.id.item_precio)

        // Set the patient data in the TextViews
        nombreTextView.text = producto?.nombre
        recursosTextView.text = producto?.especificacion
        cantidadTextView.text = producto?.cantidad.toString()
        precioTextView.text = producto?.precio.toString()

        return compraView
    }
}