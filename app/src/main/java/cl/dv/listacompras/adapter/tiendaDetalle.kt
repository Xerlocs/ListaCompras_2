package cl.dv.listacompras.adapter

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import cl.dv.listacompras.Entidad.Tienda
import cl.dv.listacompras.R

class tiendaDetalle(
    contexto: Context,
    private val tienda: Tienda
) : Dialog(contexto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.producto_detalle)

        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewEspecificacion = findViewById<TextView>(R.id.textViewEspec)
        val buttonRegresar = findViewById<Button>(R.id.buttonRegresar2)

        // Set patient information in TextViews
        textViewNombre.text = tienda.nombre
        textViewEspecificacion.text = tienda.ubicacion

        // Set a click listener for the "Go Back" button to dismiss the dialog
        buttonRegresar.setOnClickListener {
            dismiss()
        }
    }
}