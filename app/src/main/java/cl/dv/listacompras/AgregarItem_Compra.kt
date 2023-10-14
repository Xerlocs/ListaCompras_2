package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AgregarItem_Compra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_item_compra)

        val regresarCompra = findViewById<Button>(R.id.confirmarButton)

        regresarCompra.setOnClickListener{
            val intentAbout = Intent(this, ListaCompra::class.java)
            startActivity(intentAbout)
        }
    }
}