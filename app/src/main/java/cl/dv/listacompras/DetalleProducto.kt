package cl.dv.listacompras

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cl.dv.listacompras.Entidad.Producto

class DetalleProducto : AppCompatActivity() {

    private lateinit var textNombre: TextView
    private lateinit var textEspecificaion: TextView
    private lateinit var textCantidad: TextView
    private lateinit var textPrecio: TextView

    private lateinit var producto: Producto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        textNombre = findViewById(R.id.textViewNombre2)
        textEspecificaion = findViewById(R.id.textViewEspec2)
        textCantidad = findViewById(R.id.textViewCantidad2)
        textPrecio = findViewById(R.id.textViewPrecio2)

        if(Build.VERSION.SDK_INT >= 33){
            producto = intent.getParcelableExtra("Producto", Producto::class.java) ?: Producto("", "", 0, 0)
        }else{
            producto = intent.getParcelableExtra("Producto") ?: Producto("", "", 0, 0)
        }
    }
}