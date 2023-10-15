package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import cl.dv.listacompras.Entidad.Tienda
import cl.dv.listacompras.adapter.listaTiendaAdapter

class ListaTiendas : AppCompatActivity() {

    private lateinit var listviewTiendas: ListView
    private  var listOption: Boolean = true
    private lateinit var tiendas: MutableList<Tienda>
    private lateinit var adapterTienda: listaTiendaAdapter

    companion object{
        const val REQUEST_REGISTER = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tiendas)

        listviewTiendas = findViewById(R.id.listViewTiendas)

        tiendas = mutableListOf(
            Tienda("Jumbo", "El Arenal 441, Talca", "Lunes a sábado 8:00 – 21:00"),
            Tienda("Tottus", "Calle Cuatro Norte 1530, Talca", "Lunes a Domingo 08:30 a 21:30 hrs"),
            Tienda("aCuenta", "Av. 1 Oriente 323", "Lunes a sábado 8:00 – 21:30")
        )

        adapterTienda = listaTiendaAdapter(this, R.layout.item_tiendas, tiendas)

        listviewTiendas.adapter = adapterTienda

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_REGISTER && resultCode == RESULT_OK) {
            val nuevaTienda = data?.getParcelableExtra<Tienda>("new")
            if (nuevaTienda != null) {
                tiendas.add(nuevaTienda)
                if (listOption) {

                }
                adapterTienda.notifyDataSetChanged()
            }
        }
    }
}