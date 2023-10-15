package cl.dv.listacompras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import cl.dv.listacompras.Entidad.Tienda
import cl.dv.listacompras.R

class listaTiendaAdapter(
    contexto: Context,
    recursos: Int,
    tienda: List<Tienda>
) : ArrayAdapter<Tienda>(contexto, recursos, tienda){

    override fun getView(posicion: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val tiendaView = convertView ?: inflater.inflate(R.layout.item_tiendas, null)

        // Get the patient data at the current position
        val tienda = getItem(posicion)

        // Bind patient data to TextViews in the custom layout
        val nombreTextView = tiendaView.findViewById<TextView>(R.id.tienda_nombre)
        val recursosTextView = tiendaView.findViewById<TextView>(R.id.tienda_ubicacion)
        val horarioTextView = tiendaView.findViewById<TextView>(R.id.tienda_horario)

        // Set the patient data in the TextViews
        nombreTextView.text = tienda?.nombre
        recursosTextView.text = tienda?.ubicacion
        horarioTextView.text = tienda?.horario

        return tiendaView
    }
}