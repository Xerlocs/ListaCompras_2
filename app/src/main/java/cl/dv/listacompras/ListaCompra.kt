package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.dv.listacompras.adapter.comprasAdapter
import cl.dv.listacompras.databinding.ActivityListaCompraBinding

class ListaCompra : AppCompatActivity() {

    private lateinit var binding: ActivityListaCompraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        val agregarNavigation = findViewById<Button>(R.id.agregarButton)

        agregarNavigation.setOnClickListener{
            val intentAbout = Intent(this, AgregarItem_Compra::class.java)
            startActivity(intentAbout)
        }

    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)

        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.recyclerCompras.layoutManager = manager
        binding.recyclerCompras.adapter = comprasAdapter(comprasProvider.compraList)
        binding.recyclerCompras.addItemDecoration(decoration)
    }

}

//Listar las cosas a comprar

//Boton para agregar cosas a comprar

