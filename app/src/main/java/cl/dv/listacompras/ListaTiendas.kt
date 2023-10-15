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
            Tienda("Jumbo", "Marraqueta"),
            Tienda("Jumbo", "Marraqueta"),
            Tienda("Jumbo", "Marraqueta"),
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