package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import cl.dv.listacompras.Entidad.Producto
import cl.dv.listacompras.adapter.listaInventarioAdapter


class Inventario : AppCompatActivity() {

    private lateinit var listviewInventario: ListView
    private  var listOption: Boolean = true
    private lateinit var productos: MutableList<Producto>
    private lateinit var adapterProductos: listaInventarioAdapter

    companion object{
        const val REQUEST_REGISTER = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventario)

        listviewInventario = findViewById(R.id.listViewInventario)

        productos = mutableListOf(
            Producto("Papas fritas", "Lays", 6, 0),
            Producto("Monster", "Ultra Watermelon", 1, 0)

        )

        adapterProductos = listaInventarioAdapter(this, R.layout.item_inventario, productos)

        listviewInventario.adapter = adapterProductos

    }

    fun crearProducto(view: View){
        val intent = Intent(this, AgregarItem_Inventario::class.java)
        startActivityForResult(intent, REQUEST_REGISTER)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_REGISTER && resultCode == RESULT_OK) {
            val nuevoProducto = data?.getParcelableExtra<Producto>("new")
            if (nuevoProducto != null) {
                productos.add(nuevoProducto)
                if (listOption) {

                }
                adapterProductos.notifyDataSetChanged()
            }
        }
    }
}

