package cl.dv.listacompras.adapter

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import cl.dv.listacompras.Entidad.Producto
import cl.dv.listacompras.R

class compraDetalle(
    contexto: Context,
    private val producto: Producto
) : Dialog(contexto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.producto_detalle)

        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewEspecificacion = findViewById<TextView>(R.id.textViewEspec)
        val textViewCantidad = findViewById<TextView>(R.id.textViewCantidad)
        val textViewPrecio = findViewById<TextView>(R.id.textViewPrecio)
        val buttonRegresar = findViewById<Button>(R.id.buttonRegresar)

        // Set patient information in TextViews
        textViewNombre.text = producto.nombre
        textViewEspecificacion.text = producto.especificacion
        textViewCantidad.text = producto.cantidad.toString()
        textViewPrecio.text = producto.precio.toString()

        // Set a click listener for the "Go Back" button to dismiss the dialog
        buttonRegresar.setOnClickListener {
            dismiss()
        }
    }
}