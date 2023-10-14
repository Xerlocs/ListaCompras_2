package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Compras
        val compraNavigation = findViewById<Button>(R.id.ComprasButton)

        compraNavigation.setOnClickListener{
            val intentAbout = Intent(this, ListaCompra::class.java)
            startActivity(intentAbout)
        }

        //Inventario
        val inventarioNavigation = findViewById<Button>(R.id.InventarioButton)

        inventarioNavigation.setOnClickListener{
            val intentAbout = Intent(this, Inventario::class.java)
            startActivity(intentAbout)
        }

    }
}

