package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AgregarItem_Compra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_item_compra)

        var campoNombre:EditText = findViewById<EditText?>(R.id.editNombre)
        var campoEspecificacion:EditText = findViewById(R.id.editEspecificacion)
        var campoCantidad:EditText = findViewById(R.id.editCantidad)
        var campoPrecio:EditText = findViewById(R.id.editPrecio)

        var cantidad:String = campoCantidad.text.toString()
        var precio:String = campoPrecio.text.toString()

        val regresarCompra = findViewById<Button>(R.id.confirmarButton)

        regresarCompra.setOnClickListener{

            var nombre:String = campoNombre.text.toString()
            var especificacion:String = campoEspecificacion.text.toString()
            var intCantidad: Int = Integer.parseInt(cantidad)
            var intPrecio: Int = Integer.parseInt(precio)

            var tamano: Int = Integer.parseInt(comprasProvider.compraList.size.toString()) + 1

            comprasProvider.compraList.add(tamano, Compras(nombre, especificacion, intCantidad, intPrecio))

            val intentAbout = Intent(this, ListaCompra::class.java)
            startActivity(intentAbout)
        }
    }
}