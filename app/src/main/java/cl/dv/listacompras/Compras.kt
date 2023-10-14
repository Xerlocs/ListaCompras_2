package cl.dv.listacompras

data class Compras (val nombre: String, val especificacion: String, val cantidad: Int, val precio: Int){

    val precioFinal = cantidad * precio


}