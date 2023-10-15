package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import cl.dv.listacompras.Entidad.Producto
import cl.dv.listacompras.adapter.compraDetalle
import cl.dv.listacompras.adapter.listaCompraAdapter

class ListaCompra : AppCompatActivity() {

    private lateinit var listviewCompras: ListView
    private  var listOption: Boolean = true
    private var detailOption: Boolean = false
    private lateinit var productos: MutableList<Producto>
    private lateinit var adapterProductos: listaCompraAdapter

    companion object{
        const val REQUEST_REGISTER = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_compra)

        listviewCompras = findViewById(R.id.listViewProductos)

        productos = mutableListOf(
            Producto("Pan", "Marraqueta", 6, 400),
            Producto("Coca-Cola", "1.5lt", 1, 1500),
            Producto("Jamon", "Pavo", 6, 150),
            Producto("Queso", "Gauda", 6, 250)

        )

        adapterProductos = listaCompraAdapter(this, R.layout.item_compras, productos)

        listviewCompras.adapter = adapterProductos

        listviewCompras.setOnItemClickListener{ _, _, posicion, _ ->
            val productoSeleccionado = productos[posicion]
            listOption = !listOption
            if (detailOption){
                mostrarProductoDetalle(productoSeleccionado)
            }
            else{
                val intent = Intent(this, DetalleProducto::class.java)
                intent.putExtra("Producto", productoSeleccionado)
                startActivity(intent)
            }
        }
    }

    fun crearProducto(view: View){
        val intent = Intent(this, AgregarItem_Compra::class.java)
        startActivityForResult(intent, REQUEST_REGISTER)
    }

    private fun mostrarProductoDetalle(producto: Producto){
        val dialog = compraDetalle(this, producto)
        dialog.show()
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

//Listar las cosas a comprar

//Boton para agregar cosas a comprar

