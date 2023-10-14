package cl.dv.listacompras

class comprasProvider {
    companion object{
        val compraList = listOf<Compras>(
            Compras("Pan", "Marraqueta", "6", "600"),
            Compras("Coca-Cola", "1.5lt", "1", "1500"),
            Compras("Jamon", "Pavo", "6", "650"),
            Compras("Queso", "Gauda", "6", "750")

        )
    }
}