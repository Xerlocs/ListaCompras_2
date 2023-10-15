package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import cl.dv.listacompras.Entidad.Producto

class AgregarItem_Inventario : AppCompatActivity() {

    private lateinit var Nombre: EditText
    private lateinit var Especificacion: EditText
    private lateinit var Cantidad: EditText
    private lateinit var AgregarButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_item_inventario)

        Nombre = findViewById(R.id.editNombre)
        Especificacion = findViewById(R.id.editEspecificacion)
        Cantidad = findViewById(R.id.editCantidad)
        AgregarButton = findViewById(R.id.confirmarButton)

        AgregarButton.setOnClickListener{

            val nombre = Nombre.text.toString()
            val especificaion = Especificacion.text.toString()
            val cantidad = Cantidad.text.toString().toIntOrNull() ?: 0

            val producto = Producto(nombre, especificaion, cantidad, 0)

            val resultIntent = Intent()
            resultIntent.putExtra("new", producto)
            setResult(AppCompatActivity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
